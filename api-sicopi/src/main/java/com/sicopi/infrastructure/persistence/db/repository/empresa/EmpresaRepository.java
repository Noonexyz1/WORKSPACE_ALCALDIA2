package com.sicopi.infrastructure.persistence.db.repository.empresa;

import com.sicopi.infrastructure.persistence.db.entity.empresa.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
}
