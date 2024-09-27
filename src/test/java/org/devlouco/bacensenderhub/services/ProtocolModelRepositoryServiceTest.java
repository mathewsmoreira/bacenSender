package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.devlouco.bacensenderhub.repositories.ProtocolModelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ProtocolModelRepositoryServiceTest {


    @Mock
    private ProtocolModelRepository repo;
    @InjectMocks
    private ProtocolModelRepositoryService service;

    private CompanyModel companyModel;

    private ProtocolModel protocolModel;

    private byte[] fileByte;

    @BeforeEach
    void setup(){
        companyModel = new CompanyModel(
                3027,"90101030201018"
        );

        protocolModel = new ProtocolModel(
                1l, LocalDate.now(), "4010","9179ec02b930c1bd44744d784680b21f6ebcb4c1fccbfe1a5bc0f64df7559d58",
                256,"terste.zip","","544",companyModel,fileByte);
    }

    @Test
    void Dado_uma_entidade_valida_Quando_salvar_Entao_retorna_uma_entidade(){
        when(repo.save(any())).thenReturn(
                protocolModel
        );

        ProtocolModel save = service.save(protocolModel);
        assertAll(
                ()->{
                    assertNotNull(save);
                    assertEquals(protocolModel.getHash(),save.getHash());
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
                protocolModel
        );

        ProtocolModel update = service.update(protocolModel);
        assertAll(
                ()->{
                    assertNotNull(update);
                    assertEquals(protocolModel.getHash(), update.getHash());
                    verify(repo,times(1)).save(any());
                }
        );
    }

    @Test
    void Dado_uma_entidade_valida_Quando_feito_o_findById_Entao_deve_retornar_a_entidade(){
        when(repo.findById(anyLong())).thenReturn(
                Optional.of(protocolModel)
        );

        ProtocolModel update = service.findById(protocolModel.getID()).orElse(null);
        assertAll(
                ()->{
                    assertNotNull(update);
                    assertEquals(1l,update.getID());
                    verify(repo,times(1)).findById(anyLong());
                }
        );
    }

    @Test
    void Dado_uma_entidade_valida_Quando_chamado_findAll_protocolModel_Entao_retorna_uma_lista_de_entidade(){
        when(repo.findAll()).thenReturn(
                List.of(protocolModel)
        );

        List<ProtocolModel> all = service.findAll();
        assertAll(
                ()->{
                    assertNotNull(all);
                    assertEquals(1, all.size());
                    verify(repo, times(1)).findAll();
                }
        );
    }




}