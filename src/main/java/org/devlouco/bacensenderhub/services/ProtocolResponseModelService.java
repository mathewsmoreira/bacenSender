package org.devlouco.bacensenderhub.services;


import org.devlouco.bacensenderhub.models.ProtocolResponseModel;
import org.devlouco.bacensenderhub.repositories.ProtocolResponseModelRepository;
import org.springframework.stereotype.Service;

@Service
public class ProtocolResponseModelService extends GenericCrudService<ProtocolResponseModel, Long> {

    public ProtocolResponseModelService(ProtocolResponseModelRepository repository) {
        super(repository);
    }
}
