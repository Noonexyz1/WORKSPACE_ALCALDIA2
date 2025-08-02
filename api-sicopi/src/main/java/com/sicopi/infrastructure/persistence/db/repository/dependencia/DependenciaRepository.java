package com.sicopi.infrastructure.persistence.db.repository.dependencia;

import com.sicopi.infrastructure.persistence.db.entity.dependencia.DependenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependenciaRepository extends JpaRepository<DependenciaEntity, Long> {
}
