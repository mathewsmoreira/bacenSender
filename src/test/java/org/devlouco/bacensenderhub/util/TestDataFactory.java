package org.devlouco.bacensenderhub.util;

import org.devlouco.bacensenderhub.models.*;
import org.devlouco.bacensenderhub.services.ProtocolFactoryService;
import wiremock.org.eclipse.jetty.util.security.Credential;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestDataFactory {

    private static ProtocolFactoryService protocolFactoryService;

    public TestDataFactory(ProtocolFactoryService protocolFactoryService) {
        this.protocolFactoryService = protocolFactoryService;
    }

    public static CompanyModel.Builder createCompanyModel() {
        return CompanyModel.builder()
                .withID(1l)
                .withCoop(3027)
                .withCnpj("09897648571235");
    }
    public static CompanyModel.Builder createCompanyModelNull() {
        return CompanyModel.builder();
    }

    public static CompanyModel.Builder createCompanyModeWithCredentials() {
        return createCompanyModel()
                .withCredentials(createCredentialsModel().build());

    }


    public static CredentialsModel.Builder createCredentialsModel() {
        return CredentialsModel.builder()
                .withLogin("teste")
                .withPassword("teste");
    }

    public static CredentialsModel.Builder createCredentialsModelNull() {
        return CredentialsModel.builder();
    }

    public static ProtocolModel.Builder createProtocolModel() {
        return ProtocolModel.builder()
                .withID(1l)
                .withDate(LocalDate.now())
                .withIdetification("4010")
                .withHash("9179ec02b930c1bd44744d784680b21f6ebcb4c1fccbfe1a5bc0f64df7559d58")
                .withSize(256)
                .withDocName("teste.zip")
                .withObservation("")
                .withRecipient("")
                .withFilesBytes("Conteúdo binário simulado".getBytes(StandardCharsets.UTF_8))
                .withCompany(createCompanyModel().build()
                );

    }

    public static ProtocolModel.Builder createProtocolModelNull() {
        return ProtocolModel.builder();
    }

    public static ProtocolResponseModel.Builder createProtocolResponseModel() {
        return ProtocolResponseModel.builder()
                .withID(1l)
                .withProtocol("90108045")
                .withLinkContent(
                        new LinkResponseModel(
                              "https://{host}/staws/arquivos/{protocolo}/conteudo","conteudo","application/octet-stream"
                        )
                )
                .withCompanyModel(createCompanyModel().build());
    }

    public static ProtocolResponseModel.Builder createProtocolResponseModelNull() {
        return ProtocolResponseModel.builder();
    }

    public static List<ProtocolModel> createProtocolResponseModelList() {
        List<ProtocolModel> protocolModelList = new ArrayList<>();
        for(int i=0;i < 1000;i++){
            ProtocolModel prot = createProtocolModel().build();
            protocolModelList.add(prot);
        }

        return protocolModelList;
    }



}
