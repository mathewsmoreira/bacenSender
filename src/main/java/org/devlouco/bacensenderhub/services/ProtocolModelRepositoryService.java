package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.devlouco.bacensenderhub.repositories.ProtocolModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProtocolModelRepositoryService {

    @Autowired
    private ProtocolModelRepository repo;

    public ProtocolModel save(ProtocolModel protocolModel){
        return repo.save(protocolModel);
    }

    public ProtocolModel update(ProtocolModel protocolModel){
        return repo.save(protocolModel);
    }

    public void delete(ProtocolModel protocolModel){
        repo.delete(protocolModel);
    }

    public ProtocolModel findProtocolbyId(ProtocolModel protocolModel){
        return repo.findById(protocolModel.getID()).orElse(null);
    }

    public List<ProtocolModel> findAllProtocol(ProtocolModel protocolModel){
        return repo.findAll();
    }



}
