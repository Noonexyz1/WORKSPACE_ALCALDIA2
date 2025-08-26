package com.sicopi.infrastructure.persistence.db.repository.precioempresa;

import com.sicopi.infrastructure.persistence.db.entity.precioempresa.PrecioEmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioEmpresaRepository extends JpaRepository<PrecioEmpresaEntity, Long> {
}
