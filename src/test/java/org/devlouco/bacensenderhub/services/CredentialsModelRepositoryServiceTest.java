package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.repositories.CredentialsModelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CredentialsModelRepositoryServiceTest {

    @Mock
    private CredentialsModelRepository repo;

    @InjectMocks
    private CredentialsModelRepositoryService service;

    private CredentialsModel credentialsModel;

    @BeforeEach
    void setup(){
        CompanyModel companyModel = new CompanyModel(3027,"90301720193847");
        credentialsModel = new CredentialsModel(
                1l,"teste","teste",companyModel
        );

    }

    @Test
    void Dado_uma_entidade_valida_Quando_salvar_Entao_retorna_uma_entidade(){
        when(repo.save(any())).thenReturn(
                credentialsModel
        );

        CredentialsModel save = service.save(credentialsModel);
        assertAll(
                ()->{
                    assertNotNull(save);
                    assertEquals(credentialsModel,save);
                    verify(repo, times(1)).save(any());
                }
        );
    }

    @Test
    void Dado_uma_entidade_valida_Quando_tentar_salvar_nulo_Entao_deve_lancar_exception(){
        assertThrows(NullPointerException.class, () ->service.save(null));

    }

    @Test
    void Dado_uma_entidade_valida_Quando_feito_o_update_Entao_deve_retornar_a_entidade(){
        when(repo.save(any())).thenReturn(
                credentialsModel
        );

        CredentialsModel update = service.update(credentialsModel);
        assertAll(
                ()->{
                    assertNotNull(update);
                    assertEquals(credentialsModel, update);
                    verify(repo,times(1)).save(any());
                }
        );
    }

    @Test
    void Dado_uma_entidade_valida_Quando_feito_o_getCredentialsModel_Entao_deve_retornar_a_entidade(){
        when(repo.findById(anyLong())).thenReturn(
                Optional.of(credentialsModel)
        );

        CredentialsModel update = service.findCredentialsById(credentialsModel);
        assertAll(
                ()->{
                    assertNotNull(update);
                    assertEquals(1l,update.getID());
                    verify(repo,times(1)).findById(anyLong());
                }
        );
    }

    @Test
    void Dado_uma_entidade_valida_Quando_chamado_findAll_Credentials_Entao_retorna_uma_lista_de_entidade(){
        when(repo.findAll()).thenReturn(
                List.of(credentialsModel)
        );

        List<CredentialsModel> all = service.findAllCredentials();
        assertAll(
                ()->{
                    assertNotNull(all);
                    assertEquals(1, all.size());
                    verify(repo, times(1)).findAll();
                }
        );
    }

}