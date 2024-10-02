package org.devlouco.bacensenderhub.util.headerStrategy;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.util.BasicAuth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
abstract class BacenHeaderTest<T> {

@Mock
private BasicAuth basicAuth;


    protected BacenHeader bacenHeader;

    protected T entity;
    protected T basicAuthHeader;

    protected abstract T createEntity();




    @BeforeEach
    void setUp() {
        entity = createEntity();
    }

    @Test
    void Dado_a_implementaçao_protocol_Quando_chamado_getHeader_Entao_nao_deve_retornar_null(){


        when(basicAuth.createBasicAuthHeader(any())).thenReturn(
                basicAuthHeader.toString()
        );


        HttpHeaders header = bacenHeader.getHeader((CredentialsModel) entity);

        assertAll(
                ()->{
                    assertNotNull(header);
                    assertEquals(basicAuthHeader, header.getFirst("Authorization"));
                    verify(basicAuth, times(1)).createBasicAuthHeader((CredentialsModel) entity);
                    verify(bacenHeader, times(1)).getHeader((CredentialsModel) entity);
                }
        );

    }

}