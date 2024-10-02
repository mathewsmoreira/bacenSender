package org.devlouco.bacensenderhub.models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CredentialsModelTest {

    @Mock
    private CompanyModel company;
    @InjectMocks
    private CredentialsModel credentials;
    private Validator validator;

    @BeforeEach
    void setUp() {
        credentials.setLogin("teste");
        credentials.setPassword("password");
        validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    @Test
    void Dado_um_objeto_Quando_instanciado_com_atributos_Entao_nao_deve_ser_nullo(){
        Set<ConstraintViolation<CredentialsModel>> validate = validator.validate(credentials);
        assertFalse(!validate.isEmpty());
    }

    @Test
    void Dado_um_objeto_Quando_os_atribuido_forem_null_Entao_deve_lancar_exception(){
        credentials.setLogin(null);
        Set<ConstraintViolation<CredentialsModel>> validate = validator.validate(credentials);
        assertTrue(!validate.isEmpty());
    }

}