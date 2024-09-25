package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.repositories.CompanyModelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyModelRepositoryServiceTest {


    @InjectMocks
    private CompanyModelRepositoryService service;
    @Mock
    private CompanyModelRepository repo;
    private CompanyModel companyModel;
    private CredentialsModel credentialsModel;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        credentialsModel = mock(CredentialsModel.class);

        companyModel = new CompanyModel(1l,9010,"90203020102019",credentialsModel);



    }

    @Test
    void Dado_uma_entidade_valida_Quando_salvar_Entao_salva_a_entidade(){
        when(repo.save(any(CompanyModel.class))).thenReturn(
                companyModel
        );

        assertEquals(companyModel, service.save(companyModel));
    }

    @Test
    void Dado_uma_entidade_valida_Quando_tentar_salvar_nulo_Entao_deve_lancar_exception(){
        assertThrows(NullPointerException.class, () -> service.save(null));
       verify(repo, never()).save(any(CompanyModel.class));
    }

    @Test
    void Dado_uma_entidade_valida_Quando_feito_update_Entao_retorna_a_entidade(){
        when(repo.save(any(CompanyModel.class))).thenReturn(
                companyModel
        );

        CompanyModel update = service.update(companyModel);

        assertEquals(companyModel, update);
        verify(repo, times(1)).save(any(CompanyModel.class));

    }

    @Test
    void Dado_uma_entidade_valida_Quando_chamado_findById_Entao_retorna_uma_entidade(){
        when(repo.findById(anyLong())).thenReturn(
                Optional.of(companyModel)
        );

        CompanyModel byId = service.findById(companyModel);
        assertAll(
                ()->{
                    assertNotNull(byId);
                    assertEquals(companyModel, byId);
                    verify(repo, times(1)).findById(anyLong());
                }
        );


    }

    @Test
    void Dado_uma_entidade_valida_Quando_chamado_findAll_Entao_retorna_uma_lista_de_entidade(){
        when(repo.findAll()).thenReturn(
                List.of(companyModel)
        );

        List<CompanyModel> all = service.findAll();
        assertAll(
                ()->{
                    assertNotNull(all);
                    assertEquals(1, all.size());
                    verify(repo, times(1)).findAll();
                }
        );
    }

}