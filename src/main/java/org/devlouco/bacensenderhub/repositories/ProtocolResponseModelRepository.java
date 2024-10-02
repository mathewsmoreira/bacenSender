package org.devlouco.bacensenderhub.repositories;

import org.devlouco.bacensenderhub.models.ProtocolResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocolResponseModelRepository extends JpaRepository<ProtocolResponseModel, Long> {
}
