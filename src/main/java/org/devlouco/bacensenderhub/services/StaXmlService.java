package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.devlouco.bacensenderhub.models.ProtocolResponseModel;
import org.devlouco.bacensenderhub.services.exceptions.NotNullValidationService;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

@Service
public class StaXmlService {


    public String marshalProtocol(ProtocolModel protocol) {
        NotNullValidationService.notNull(protocol, "Protocol cannot be null");

        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(ProtocolModel.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();
            jaxbMarshaller.marshal(protocol, stringWriter);
            return stringWriter.toString();
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }

    public ProtocolModel unmarshalProtocol(String xml){
        NotNullValidationService.notNull(xml, "Protocol cannot be null");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ProtocolModel.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader stringReader = new StringReader(xml);
            return (ProtocolModel) jaxbUnmarshaller.unmarshal(stringReader);
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }

    public ProtocolResponseModel unmarshalProtocolResponse(String xml){
        NotNullValidationService.notNull(xml, "Protocol cannot be null");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ProtocolResponseModel.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader stringReader = new StringReader(xml);
            return (ProtocolResponseModel) jaxbUnmarshaller.unmarshal(stringReader);
        }catch(Exception e){
            throw new RuntimeException(e);
        }


    }

}


