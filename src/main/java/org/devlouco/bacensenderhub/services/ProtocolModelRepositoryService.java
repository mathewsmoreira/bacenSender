package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.devlouco.bacensenderhub.repositories.ProtocolModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProtocolModelRepositoryService {

    @Autowired
    private ProtocolModelRepository repo;

    public ProtocolModel save(ProtocolModel protocolModel){
        Objects.requireNonNull(protocolModel);
        return repo.save(protocolModel);
    }

    public ProtocolModel update(ProtocolModel protocolModel){
        Objects.requireNonNull(protocolModel);
        return repo.save(protocolModel);
    }

    public void delete(ProtocolModel protocolModel){
        Objects.requireNonNull(protocolModel);
        repo.delete(protocolModel);
    }

    public ProtocolModel findProtocolbyId(ProtocolModel protocolModel){
        Objects.requireNonNull(protocolModel);
        return repo.findById(protocolModel.getID()).orElse(null);
    }

    public List<ProtocolModel> findAllProtocol(){
        return repo.findAll();
    }



}
