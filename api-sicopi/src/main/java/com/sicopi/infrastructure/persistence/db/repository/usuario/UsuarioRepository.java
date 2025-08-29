package com.sicopi.infrastructure.persistence.db.repository.usuario;

import com.sicopi.infrastructure.persistence.db.entity.usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UsuarioEntity findByUsername(String username);
}
