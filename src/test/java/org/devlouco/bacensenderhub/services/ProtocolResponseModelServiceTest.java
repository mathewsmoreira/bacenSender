package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.devlouco.bacensenderhub.models.ProtocolResponseModel;
import org.devlouco.bacensenderhub.repositories.ProtocolResponseModelRepository;
import org.devlouco.bacensenderhub.util.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProtocolResponseModelServiceTest extends GenericCrudServiceTest<ProtocolResponseModel, Long>{


    @Mock
    private ProtocolResponseModelRepository repository;


    @Override
    protected ProtocolResponseModel createEntity() {
        return TestDataFactory.createProtocolResponseModel().build();
    }


    @BeforeEach
    void setup(){
        super.setUp();
        jpaRepository = repository;
        genericCrudService = new ProtocolResponseModelService(repository);
        id = 1l;
    }





}