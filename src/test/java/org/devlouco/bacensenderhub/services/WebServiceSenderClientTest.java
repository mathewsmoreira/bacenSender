package org.devlouco.bacensenderhub.services;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.devlouco.bacensenderhub.models.ProtocolResponseModel;
import org.devlouco.bacensenderhub.repositories.CredentialsModelRepository;
import org.devlouco.bacensenderhub.util.TestDataFactory;
import org.devlouco.bacensenderhub.util.headerStrategy.HeaderProtocol;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.client.AutoConfigureWebServiceClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.w3c.dom.stylesheets.LinkStyle;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebServiceClient
@ExtendWith({WireMockExtension.class, SpringExtension.class})
class WebServiceSenderClientTest {

    private HeaderProtocol headerProtocol;


    private ProtocolModel protocolModel;
    private List<ProtocolModel> protocolModels;
    private CredentialsModel credentialsModel;
    private WireMockServer wireMockServer;
    @Autowired
    private StaXmlService staXmlService;

    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private CredentialsModelRepository credentialsModelRepository;

    @MockBean
    private CredentialsModelRepositoryService credentialsModelRepositoryService;

    @InjectMocks
    private ProtocolFactoryService protocolFactoryService;

    @InjectMocks
    @Autowired
    private WebServiceSenderClient webServiceSenderClient;

    @BeforeEach
    void setUp() throws IOException {

        protocolModel = TestDataFactory.createProtocolModel().build();
        protocolModels = TestDataFactory.createProtocolResponseModelList();
        credentialsModel = TestDataFactory.createCredentialsModel().build();

    }

    @Test
    void Dado_um_webServiceClient_valido_Quando_chamar_createProtocol_Entao_deve_retornar_um_xml_valido() throws ExecutionException, InterruptedException {

        String xml = staXmlService.marshalProtocol(protocolModel);

        when(credentialsModelRepositoryService.getCredentialsModelByCoop(anyInt()))
                .thenReturn(credentialsModel);

        when(credentialsModelRepository.findByCoop(anyInt())).thenReturn(
                Optional.of(credentialsModel)
        );


        webServiceSenderClient.setURI("http://localhost:8181/staws/arquivos/");
        //nesse metodo e usa o block para fazer as asserções das resposta do stub
        List<ProtocolResponseModel> protocols = webServiceSenderClient.createProtocols(protocolModels).collectList().block();

        assertEquals(1000, protocols.size());
        // Verifica se a requisição POST foi feita conforme esperado



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