package com.sicopi.infrastructure.persistence.db.repository.solicitud;

import com.sicopi.infrastructure.persistence.db.entity.solicitud.SolicitudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepository extends JpaRepository<SolicitudEntity, Long> {
}
