package com.sicopi.infrastructure.persistence.db.repository.autenticacion;

import com.sicopi.infrastructure.persistence.db.entity.autenticacion.PermisoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends JpaRepository<PermisoEntity, Long> {
}
