package org.devlouco.bacensenderhub.repositories;

import org.devlouco.bacensenderhub.models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyModelRepository extends JpaRepository<CompanyModel, Long> {
    @Query("SELECT c FROM CompanyModel c where c.coop= :coop")
    public Optional<CompanyModel> findByCoop(@Param("coop") int coop);
}
