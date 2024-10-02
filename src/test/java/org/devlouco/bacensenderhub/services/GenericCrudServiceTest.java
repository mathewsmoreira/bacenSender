package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
abstract class GenericCrudServiceTest<T, ID> {


    protected GenericCrudService<T, ID> genericCrudService;

    @Mock
    protected JpaRepository<T, ID> jpaRepository;

    protected T entity;
    protected abstract T createEntity();

    protected ID id;

    @BeforeEach
    void setUp() {
        entity = createEntity();
    }

    @Test
    void Dado_uma_entidade_valida_Quando_salvar_Entao_retorna_uma_entidade(){
        when(jpaRepository.save(any())).thenReturn(
                entity
        );

        T save = genericCrudService.save(entity);
        assertAll(
                ()->{
                    assertNotNull(save);
                    assertEquals(entity,save);
                    verify(jpaRepository, times(1)).save(any());
                }
        );
    }

    @Test
    void Dado_uma_entidade_valida_Quando_tentar_salvar_nulo_Entao_deve_lancar_exception(){
        assertThrows(NullPointerException.class, () ->genericCrudService.save(null));

    }

    @Test
    void Dado_uma_entidade_valida_Quando_feito_o_update_Entao_deve_retornar_a_entidade(){
        when(jpaRepository.save(any())).thenReturn(
                entity
        );

        T update = genericCrudService.update(entity);
        assertAll(
                ()->{
                    assertNotNull(update);
                    assertEquals(entity, update);
                    verify(jpaRepository,times(1)).save(any());
                }
        );
    }

    @Test
    void Dado_uma_entidade_valida_Quando_feito_o_findById_Entao_deve_retornar_a_entidade(){
        when(jpaRepository.findById(any())).thenReturn(
                Optional.of(entity)
        );

        T update = genericCrudService.findById(id).orElse(null);
        assertAll(
                ()->{
                    assertNotNull(update);
                    assertEquals(entity, update);
                    verify(jpaRepository,times(1)).findById(any());
                }
        );
    }

    @Test
    void Dado_uma_entidade_valida_Quando_chamado_findAll_protocolModel_Entao_retorna_uma_lista_de_entidade(){
        when(jpaRepository.findAll()).thenReturn(
                List.of(entity)
        );

        List<T> all = genericCrudService.findAll();
        assertAll(
                ()->{
                    assertNotNull(all);
                    assertEquals(1, all.size());
                    verify(jpaRepository, times(1)).findAll();
                }
        );
    }




}