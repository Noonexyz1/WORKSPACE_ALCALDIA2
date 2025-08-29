package com.sicopi.infrastructure.persistence.db.repository.usuario;

import com.sicopi.infrastructure.persistence.db.entity.usuario.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long> {
}
