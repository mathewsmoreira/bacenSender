package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.repositories.CredentialsModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialsModelRepositoryService {

    private CredentialsModelRepository credentialsModelRepository;


    public CredentialsModel save(CredentialsModel credentialsModel) {
        return credentialsModelRepository.save(credentialsModel);
    }

    public CredentialsModel update(CredentialsModel credentialsModel) {
        return credentialsModelRepository.save(credentialsModel);
    }

    public CredentialsModel getCredentialsModel( CredentialsModel credentialsModel ) {
        return credentialsModelRepository.findById(credentialsModel.getID()).orElse(null);
    }

    public List<CredentialsModel> getAllCredentialsModels() {
        return credentialsModelRepository.findAll();
    }

    public void deleteCredentialsModel(CredentialsModel credentialsModel) {
        credentialsModelRepository.delete(credentialsModel);
    }


}
