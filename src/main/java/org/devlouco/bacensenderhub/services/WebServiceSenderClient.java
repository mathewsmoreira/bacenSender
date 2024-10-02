package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.devlouco.bacensenderhub.models.ProtocolResponseModel;
import org.devlouco.bacensenderhub.util.headerStrategy.BacenHeader;
import org.devlouco.bacensenderhub.util.headerStrategy.HeaderFileUpload;
import org.devlouco.bacensenderhub.util.headerStrategy.HeaderProtocol;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class WebServiceSenderClient{

    private String PROTOCOL_URI = "https://sta-h.bcb.gov.br/staws/arquivos/";

    private final RestTemplate restTemplate = new RestTemplate();

    private StaXmlService staXmlService;

    private ApplicationContext applicationContext;

    private WebClient webClient;

    private BacenHeader bacenHeader;

    private ProtocolFactoryService protocolFactoryService;
    private CredentialsModelRepositoryService credentialsModelRepositoryService;


    public WebServiceSenderClient(StaXmlService staXmlService, ApplicationContext applicationContext, ProtocolFactoryService protocolFactoryService, CredentialsModelRepositoryService credentialsModelRepositoryService) {

        this.staXmlService = staXmlService;
        this.applicationContext = applicationContext;
        this.webClient = WebClient.builder()
                .build();
        this.protocolFactoryService = protocolFactoryService;
         this.credentialsModelRepositoryService = credentialsModelRepositoryService;
    }

    public void setURI(String uri){
        this.PROTOCOL_URI = uri;
    }

    //metodo resposanvel por fazer uma iteração na lista de protocolModel e passar para o metodo CreateProtocol fazer o envio async

    public Flux<ProtocolResponseModel> createProtocols(List<ProtocolModel> protocolModels) {

        return Flux.fromIterable(protocolModels)
                .flatMap(protocolModel -> {
                    CredentialsModel credentialsModel = credentialsModelRepositoryService.getCredentialsModelByCoop(protocolModel.getCompany().getCoop());
                    return createProtocol(protocolModel, credentialsModel);
                });
    }


    //metodo responsavel por fazer a requisição do protocolo ao webService do Bacen

    public Mono<ProtocolResponseModel> createProtocol(ProtocolModel protocolModel, CredentialsModel credentialsModel) {

        bacenHeader = applicationContext.getBean(HeaderProtocol.class, BacenHeader.class);

        return webClient.post()
                .uri(PROTOCOL_URI)
                .headers(headers -> headers.addAll(bacenHeader.getHeader(credentialsModel)))
                .bodyValue(staXmlService.marshalProtocol(protocolModel))
                .retrieve()
                .bodyToMono(String.class) // WebClient retorna Mono<String>
                .map(response -> staXmlService.unmarshalProtocolResponse(response.trim()));
    }


    public ResponseEntity<String> uploadFile(String protocol, byte[] content, CredentialsModel credentialsModel) throws Exception {
        bacenHeader = applicationContext.getBean(HeaderFileUpload.class,BacenHeader.class);
        HttpEntity<byte[]> request = new HttpEntity<>(content, bacenHeader.getHeader(credentialsModel));
        ResponseEntity<String> response = restTemplate.exchange(PROTOCOL_URI + protocol, HttpMethod.PUT, request, String.class);
        return response;

    }


}
