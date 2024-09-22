package org.devlouco.bacensenderhub.models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProtocolModelTest {

    @Mock
    private CompanyModel companyModel;

    private ProtocolModel protocolModel;
    @Mock
    private byte[] fileByte;

    private Validator validator;

    @BeforeEach
    void setUp() {

        protocolModel = new ProtocolModel(
                1l, LocalDate.now(), "4010","9179ec02b930c1bd44744d784680b21f6ebcb4c1fccbfe1a5bc0f64df7559d58",
                256,"terste.zip","","544",companyModel,fileByte);


        validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    @Test
    void Dado_um_objeto_instanciado_valido_Quando_atribuido_um_valor_nulo_Entao_nao_deve_lancar_exception(){
        Set<ConstraintViolation<ProtocolModel>> validate = validator.validate(protocolModel);
        assertFalse(validate.isEmpty());
    }

    @Test
    void Dado_um_objeto_instanciado_valido_Quando_atribuido_um_valor_nulo_Entao_deve_lancar_exception(){
        protocolModel.setDate(null);
        Set<ConstraintViolation<ProtocolModel>> validate = validator.validate(protocolModel);
        assertTrue(!validate.isEmpty());
    }

    @Test
    void Dado_um_objeto_instanciado_valido_Quando_atribuido_o_hash_Entao_deve_conter_sessenta_e_quatro_digitos(){
        protocolModel.setHash("9179ec02b930c1bd44744d784680b21f6ebcb4c1fccbfe1a5bc0f64df7559d585649874");
        protocolModel.setCompany(
                new CompanyModel(4010,"90102748374658")
        );
        Set<ConstraintViolation<ProtocolModel>> validate = validator.validate(protocolModel);
        String mensagem = validate.stream().findFirst().get().getMessage();
        assertEquals("tamanho deve ser entre 0 e 64", mensagem);
    }

}