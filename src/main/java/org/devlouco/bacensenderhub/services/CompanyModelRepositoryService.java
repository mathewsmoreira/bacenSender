package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.repositories.CompanyModelRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyModelRepositoryService extends GenericCrudService<CompanyModel, Long> {

    private CompanyModelRepository repository;

    public CompanyModelRepositoryService(CompanyModelRepository repository) {
        super(repository);
    }

    public CompanyModel getCompanyModelByCoop(int coop) {

        return this.repository.findByCoop(coop).orElseThrow(
                () -> new RuntimeException("Could not find company model with coop " + coop)
        );
    }
}
