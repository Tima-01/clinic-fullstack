package org.security.clinic.repository;

import org.security.clinic.entity.ServiceProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProcedureRepository extends JpaRepository<ServiceProcedure, Long> {
}
