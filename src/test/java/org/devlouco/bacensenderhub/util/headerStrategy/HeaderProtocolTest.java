package org.devlouco.bacensenderhub.util.headerStrategy;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.*;

class HeaderProtocolTest extends BacenHeaderTest{

    private CompanyModel companyModel;
    private CredentialsModel credentialsModel;

    @InjectMocks
    @Spy
    private HeaderProtocol headerProtocol;

    @Override
    protected CredentialsModel createEntity() {
        companyModel = new CompanyModel(
                3027,"45986258491235"
        );

        credentialsModel = new CredentialsModel(
                1l,"teste2","teste2",companyModel
        );

        return credentialsModel;
    }


    @BeforeEach
    void setUp() {
        super.setUp();
        super.setUp();
        bacenHeader = headerProtocol;
        basicAuthHeader = "Basic dGVzdGUyOnRlc3RlMg==";


    }
}