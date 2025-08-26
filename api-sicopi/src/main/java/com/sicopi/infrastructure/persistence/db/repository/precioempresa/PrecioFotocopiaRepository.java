package com.sicopi.infrastructure.persistence.db.repository.precioempresa;

import com.sicopi.infrastructure.persistence.db.entity.precioempresa.PrecioFotocopiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioFotocopiaRepository extends JpaRepository<PrecioFotocopiaEntity, Long> {
}
