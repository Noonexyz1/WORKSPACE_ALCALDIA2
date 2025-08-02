package com.sicopi.infrastructure.persistence.db.repository.autenticacion;

import com.sicopi.infrastructure.persistence.db.entity.autenticacion.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
