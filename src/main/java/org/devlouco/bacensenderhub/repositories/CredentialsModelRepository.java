package org.devlouco.bacensenderhub.repositories;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialsModelRepository extends JpaRepository<CredentialsModel, Long> {

    @Query("SELECT c FROM CredentialsModel c where c.company.coop= :coop")
    public Optional<CredentialsModel> findByCoop(@Param("coop") int coop);
}
