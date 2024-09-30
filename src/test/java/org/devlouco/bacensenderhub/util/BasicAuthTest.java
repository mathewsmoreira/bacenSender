package org.devlouco.bacensenderhub.util;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;

class BasicAuthTest {

    private BasicAuth basicAuth;

    private CompanyModel companyModel;
    private CredentialsModel credentialsModel;

    @BeforeEach
    void setUp() {

        basicAuth = new BasicAuth();

        companyModel = new CompanyModel(
                3027, "90380840189890"
        );

        credentialsModel = new CredentialsModel(
                1l,"teste2","teste2",companyModel
        );


    }

    @Test
    void testBasicAuth() {

        String basicAuthLocal = "Basic dGVzdGUyOnRlc3RlMg==";

        assertEquals(basicAuthLocal, basicAuth.createBasicAuthHeader(credentialsModel));


    }

}