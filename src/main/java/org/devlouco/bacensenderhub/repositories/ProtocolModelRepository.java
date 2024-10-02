package org.devlouco.bacensenderhub.repositories;

import org.devlouco.bacensenderhub.models.ProtocolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocolModelRepository extends JpaRepository<ProtocolModel, Long> {
}
