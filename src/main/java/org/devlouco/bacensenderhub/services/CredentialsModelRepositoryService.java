package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.repositories.CredentialsModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CredentialsModelRepositoryService {

    private CredentialsModelRepository credentialsModelRepository;


    public CredentialsModel save(CredentialsModel credentialsModel) {
        Objects.requireNonNull(credentialsModel);
        return credentialsModelRepository.save(credentialsModel);
    }

    public CredentialsModel update(CredentialsModel credentialsModel) {
        Objects.requireNonNull(credentialsModel);
        return credentialsModelRepository.save(credentialsModel);
    }

    public CredentialsModel findCredentialsById(CredentialsModel credentialsModel ) {
        Objects.requireNonNull(credentialsModel);
        return credentialsModelRepository.findById(credentialsModel.getID()).orElse(null);
    }

    public List<CredentialsModel> findAllCredentials() {
        return credentialsModelRepository.findAll();
    }

    public void deleteCredentialsModel(CredentialsModel credentialsModel) {
        credentialsModelRepository.delete(credentialsModel);
    }


}
