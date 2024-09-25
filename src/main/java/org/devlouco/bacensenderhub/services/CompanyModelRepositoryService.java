package org.devlouco.bacensenderhub.services;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.repositories.CompanyModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CompanyModelRepositoryService {

    @Autowired
    private CompanyModelRepository repo;

    public CompanyModel save(CompanyModel companyModel){
        Objects.requireNonNull(companyModel);
        return repo.save(companyModel);
    }

    public CompanyModel update(CompanyModel companyModel){
        Objects.requireNonNull(companyModel);
        return repo.save(companyModel);
    }
    public CompanyModel findById(CompanyModel companyModel){
        return repo.findById(companyModel.getID()).orElse(null);
    }

    public List<CompanyModel> findAll(){
        return repo.findAll();
    }

    public void deleteById(CompanyModel companyModel){
        repo.deleteById(companyModel.getID());
    }

}
