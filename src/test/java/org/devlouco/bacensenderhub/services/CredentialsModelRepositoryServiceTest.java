package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.repositories.CredentialsModelRepository;
import org.devlouco.bacensenderhub.util.TestDataFactory;
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
class CredentialsModelRepositoryServiceTest extends GenericCrudServiceTest<CredentialsModel, Long>{

    @Mock
    private CredentialsModelRepository repo;


    @Override
    protected CredentialsModel createEntity() {
        return TestDataFactory.createCredentialsModel()
                .withID(1l)
                .build();
    }

    @BeforeEach
    void setup(){
        super.setUp();
        jpaRepository = repo;
        genericCrudService = new CredentialsModelRepositoryService(repo);
        id = entity.getID();
    }



}