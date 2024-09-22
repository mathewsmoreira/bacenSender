package org.devlouco.bacensenderhub.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ProtocolResponseModelTest {

    @Mock
    private CompanyModel companyModel;
    private ProtocolResponseModel protocolResponseModel;

    @Mock
    private LinkResponseModel linkResponseModel;

    @BeforeEach
    void setUp() {
        protocolResponseModel = new ProtocolResponseModel("9010830"
                ,linkResponseModel,
                companyModel
        );
    }

    @Test
    void Dado_uma_instacia_de_protocolResponseModel_Quando_os_atributos_forem_nulos_Entao_deve_lancar_exception(){

        IllegalArgumentException illegalArgumentExceptionId = assertThrows(IllegalArgumentException.class, () -> protocolResponseModel.setID(null));
        assertEquals("The Parameter cannot be null", illegalArgumentExceptionId.getMessage());
    }

    @Test
    void Dado_uma_instacia_de_protocolResponseModel_Quando_os_atributos_forem_nulos_ou_empty_Entao_deve_lancar_exception(){

        assertAll(()->{
            IllegalArgumentException illegalArgumentExceptionProtocolNull = assertThrows(IllegalArgumentException.class, () -> protocolResponseModel.setProtocol(null));
            assertEquals("The Parameter cannot be null or empty", illegalArgumentExceptionProtocolNull.getMessage());

            IllegalArgumentException illegalArgumentExceptionProtocolEmpty = assertThrows(IllegalArgumentException.class, () -> protocolResponseModel.setProtocol(""));
            assertEquals("The Parameter cannot be null or empty", illegalArgumentExceptionProtocolEmpty.getMessage());

        });


    }


}