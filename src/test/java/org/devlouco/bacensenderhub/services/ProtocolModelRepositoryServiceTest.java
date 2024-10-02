package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.devlouco.bacensenderhub.repositories.ProtocolModelRepository;
import org.devlouco.bacensenderhub.util.TestDataFactory;
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
class ProtocolModelRepositoryServiceTest extends GenericCrudServiceTest<ProtocolModel, Long>{


    @Mock
    private ProtocolModelRepository repo;


    @Override
    protected ProtocolModel createEntity() {
        return TestDataFactory.createProtocolModel().build();
    }

    @BeforeEach
    void setup() {
        super.setUp();
        jpaRepository = repo;
        genericCrudService = new ProtocolModelRepositoryService(repo);
        id = entity.getID();

    }






}