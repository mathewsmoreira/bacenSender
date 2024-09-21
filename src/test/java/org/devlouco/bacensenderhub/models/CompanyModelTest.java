package org.devlouco.bacensenderhub.models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CompanyModelTest {

    private CompanyModel company;
    private Validator validator;


    @BeforeEach
    void setup(){

        company = new CompanyModel(2037,"90801765901272");
        company.setID(1l);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    @Test
    void Dado_a_criacao_do_objeto_Quando_atribuir_a_coop_Entao_nao_deve_lancar_exception(){
        assertDoesNotThrow(()->company.getCoop());
    }
    @Test
    void Dado_a_criacao_do_objeto_Quando_nao_atribuir_a_coop_Entao_deve_lancar_exception(){
        Integer inte = null;
        assertThrows(NullPointerException.class, () -> company.setCoop(inte.intValue()));
    }

    @Test
    void Dado_a_criacao_do_objeto_Quando_atribuir_a_cnpj_Entao_nao_deve_lancar_exception(){
        assertDoesNotThrow(()->company.getCnpj());
    }
    @Test
    void Dado_a_criacao_do_objeto_Quando_nao_atribuir_a_cnpj_Entao_deve_lancar_exception(){
        String cnpj = null;
        assertThrows(NullPointerException.class, () -> company.setCnpj(cnpj));
    }

    @Test
    void Dado_a_criacao_do_objeto_Quando_atribuir_uma_string_Entao_nao_deve_ser_em_branco(){
        String cnpjBranco = "";
        company.setCnpj(cnpjBranco);
        Set<ConstraintViolation<CompanyModel>> validate = validator.validate(company);
        assertFalse(validate.isEmpty());
    }

    @Test
    void Dado_a_criacao_do_objeto_Quando_atribuir_uma_string_Entao_nao_deve_ter_mais_que_quartoze_digitos(){
        String cnpjBranco = "0906080608050406";
        company.setCnpj(cnpjBranco);
        Set<ConstraintViolation<CompanyModel>> validate = validator.validate(company);
        assertFalse(validate.isEmpty());
    }

    @Test
    void Dado_a_criacao_do_objeto_Quando_atribuir_uma_coop_Entao_nao_deve_ter_mais_que_quatro_digitos(){
        int coop = 90102;
        company.setCoop(coop);
        Set<ConstraintViolation<CompanyModel>> validate = validator.validate(company);
        assertFalse(validate.isEmpty());
    }

}