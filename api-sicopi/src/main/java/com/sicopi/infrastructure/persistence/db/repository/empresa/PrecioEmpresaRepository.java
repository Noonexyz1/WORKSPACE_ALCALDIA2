package com.sicopi.infrastructure.persistence.db.repository.empresa;

import com.sicopi.infrastructure.persistence.db.entity.empresa.PrecioEmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioEmpresaRepository extends JpaRepository<PrecioEmpresaEntity, Long> {
}
