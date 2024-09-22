package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.LinkResponseModel;
import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.devlouco.bacensenderhub.models.ProtocolResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class StaXmlServiceTest {


    @Mock
    private ProtocolModel protocolModel;

    private StaXmlService staXmlService;

    private String xmlRequest;

    private String xmlResponse;

    @BeforeEach
    void setUp() {
        staXmlService = new StaXmlService();

        MockitoAnnotations.openMocks(this);

        xmlRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Parametros>\n" +
                "   <IdentificadorDocumento>4010</IdentificadorDocumento>\n" +
                "   <Hash>9179ec02b930c1bd44744d784680b21f6ebcb4c1fccbfe1a5bc0f64df7559d58</Hash>\n" +
                "   <Tamanho>1045</Tamanho>\n" +
                "   <NomeArquivo>teste.zip</NomeArquivo>\n" +
                "   <Observacao></Observacao>\n" +
                "   <Destinatarios></Destinatarios>\n" +
                "</Parametros>";

        xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Resultado xmlns:atom=\"http://www.w3.org/2005/Atom\">\n" +
                "<Protocolo>90108045</Protocolo>\n" +
                "<atom:link href=\"https://{host}/staws/arquivos/{protocolo}/conteudo\"\n" +
                "rel=\"conteudo\" type=\"application/octet-stream\" />\n" +
                "</Resultado>";
    }

    @Test
    void Dado_uma_instancia_do_service_Quando_chamado_o_metodo_marshal_Entao_deve_retornar_um_xml(){

        when(protocolModel.getIdetification()).thenReturn("4010");
        when(protocolModel.getHash()).thenReturn("9179ec02b930c1bd44744d784680b21f6ebcb4c1fccbfe1a5bc0f64df7559d58");
        when(protocolModel.getSize()).thenReturn(1045l);
        when(protocolModel.getDocName()).thenReturn("teste.zip");
        when(protocolModel.getObservation()).thenReturn("");
        when(protocolModel.getRecipient()).thenReturn("");


        assertEquals(normalizeXml(xmlRequest), normalizeXml(staXmlService.marshalProtocol(protocolModel)));


    }

    @Test
    void Dado_uma_instancia_do_service_Quando_chamado_o_metodo_unMarshalProtocol_Entao_deve_retornar_um_objeto_ProtocolModel(){
        when(protocolModel.getHash()).thenReturn("9179ec02b930c1bd44744d784680b21f6ebcb4c1fccbfe1a5bc0f64df7559d58");
        ProtocolModel unmarshalProtocol = staXmlService.unmarshalProtocol(xmlRequest);
        assertEquals(protocolModel.getHash(), unmarshalProtocol.getHash());
    }

    @Test
    void Dado_uma_instancia_do_service_Quando_chamado_os_metodos_com_valores_null_Entao_deve_lancar_exception(){
        assertAll(
                () ->{
                    assertThrows(IllegalArgumentException.class, () -> staXmlService.marshalProtocol(null));
                    assertThrows(IllegalArgumentException.class, () -> staXmlService.unmarshalProtocol(null));
                    assertThrows(IllegalArgumentException.class, () -> staXmlService.unmarshalProtocolResponse(null));
                }
        );

    }

    @Test
    void Dado_uma_instancia_do_service_Quando_chamado_o_unMarshal_com_string_sem_serializacao_xml_Entao_deve_lancar_exception(){
        assertAll(
                () ->{
                    assertThrows(RuntimeException.class, () -> staXmlService.unmarshalProtocol("oaisdio"));
                    assertThrows(RuntimeException.class, () -> staXmlService.unmarshalProtocolResponse("asopdiopas"));
                }
        );

    }

    @Test
    void Dado_uma_instancia_do_service_Quando_chamado_o_unmarshalProtocolResponse_Entao_deve_retornar_um_objeto_ProtocolResponseModel(){
        LinkResponseModel linkTest= new LinkResponseModel(
                "https://{host}/staws/arquivos/{protocolo}/conteudo","conteudo","application/octet-stream"
        );

        ProtocolResponseModel protocolResponseModel = staXmlService.unmarshalProtocolResponse(xmlResponse);

        assertAll(()->{
            assertEquals("90108045",protocolResponseModel.getProtocol());
            assertEquals(linkTest, protocolResponseModel.getLinkContent());
        });



    }



    private String normalizeXml(String xml) {
        return xml.trim()
                // Remove espaços excessivos entre tags
                .replaceAll(">\\s+<", "><")
                // Padroniza as quebras de linha para um formato único
                .replaceAll("\\r?\\n", "\n")
                // Remove espaços no início e no fim de cada linha
                .replaceAll("\\s*\n\\s*", "\n");
    }


}