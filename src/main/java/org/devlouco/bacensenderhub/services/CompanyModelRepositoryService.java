package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.repositories.CompanyModelRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyModelRepositoryService extends GenericCrudService<CompanyModel, Long> {

    public CompanyModelRepositoryService(CompanyModelRepository repository) {
        super(repository);
    }
}
