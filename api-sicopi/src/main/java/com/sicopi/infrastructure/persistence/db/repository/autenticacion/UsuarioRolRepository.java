package com.sicopi.infrastructure.persistence.db.repository.autenticacion;

import com.sicopi.infrastructure.persistence.db.entity.autenticacion.UsuarioRolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRolEntity, Long> {
}
