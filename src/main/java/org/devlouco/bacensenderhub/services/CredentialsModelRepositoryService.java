package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.repositories.CredentialsModelRepository;
import org.springframework.stereotype.Service;

@Service
public class CredentialsModelRepositoryService extends GenericCrudService<CredentialsModel, Long> {


    public CredentialsModelRepositoryService(CredentialsModelRepository credentialsModelRepository) {
        super(credentialsModelRepository);
    }




}
