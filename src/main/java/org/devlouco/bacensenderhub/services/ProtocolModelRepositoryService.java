package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.devlouco.bacensenderhub.repositories.ProtocolModelRepository;
import org.springframework.stereotype.Service;

@Service
public class ProtocolModelRepositoryService extends GenericCrudService<ProtocolModel, Long> {

    public ProtocolModelRepositoryService(ProtocolModelRepository protocolModelRepository) {
        super(protocolModelRepository);
    }



}
