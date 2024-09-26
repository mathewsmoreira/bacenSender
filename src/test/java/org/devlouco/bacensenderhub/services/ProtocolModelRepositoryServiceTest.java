package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.devlouco.bacensenderhub.repositories.ProtocolModelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProtocolModelRepositoryServiceTest {


    @Mock
    private ProtocolModelRepository repo;
    @InjectMocks
    private ProtocolModelRepositoryService service;

    private CompanyModel companyModel;

    private ProtocolModel protocolModel;

    @Mock
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




}