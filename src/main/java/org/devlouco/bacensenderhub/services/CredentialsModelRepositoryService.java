package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.repositories.CredentialsModelRepository;
import org.springframework.stereotype.Service;

@Service
public class CredentialsModelRepositoryService extends GenericCrudService<CredentialsModel, Long> {

    private CredentialsModelRepository credentialsRepository;

    public CredentialsModelRepositoryService(CredentialsModelRepository credentialsModelRepository) {

        super(credentialsModelRepository);
        this.credentialsRepository = credentialsModelRepository;
    }

    public CredentialsModel getCredentialsModelByCoop(int coop) {
        return credentialsRepository.findByCoop(coop).orElseThrow(
                () -> new RuntimeException("Could not find credentials with coop " + coop)
        );
    }




}
