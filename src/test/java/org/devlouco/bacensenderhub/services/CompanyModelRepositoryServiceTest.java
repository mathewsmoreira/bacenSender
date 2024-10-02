package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.repositories.CompanyModelRepository;
import org.devlouco.bacensenderhub.util.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyModelRepositoryServiceTest extends GenericCrudServiceTest < CompanyModel, Long>{

    @Mock
    private CompanyModelRepository repository;

    private CredentialsModel credentialsModel;


    @Override
    protected CompanyModel createEntity() {

        return TestDataFactory.createCompanyModel().build();

    }

    @BeforeEach
    void setUp() {
        super.setUp();
        genericCrudService = new CompanyModelRepositoryService(repository);
        jpaRepository = repository;
        id = 1l;
    }


}