package org.devlouco.bacensenderhub.util.headerStrategy;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.*;

class HeaderFileUploadTest extends BacenHeaderTest{

    @Spy
    @InjectMocks
    private HeaderFileUpload headerFileUpload;

    private CredentialsModel credentialsModel;
    private CompanyModel companyModel;
    private HttpHeaders headers;

    @Override
    protected CredentialsModel createEntity() {
        companyModel = new CompanyModel(
                3027,"90380840189890"
        );

        credentialsModel = new CredentialsModel(
                1l,"teste","teste",companyModel
        );

        return credentialsModel;
    }

    @BeforeEach
    void setUp() {

        basicAuthHeader = "Basic dGVzdGU6dGVzdGU=";
        super.setUp();
        bacenHeader = headerFileUpload;

    }





}