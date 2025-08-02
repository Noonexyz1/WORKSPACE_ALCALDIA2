package com.sicopi.infrastructure.persistence.db.repository.solicitud;

import com.sicopi.infrastructure.persistence.db.entity.solicitud.TipoSolicitudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSolicitudRepository extends JpaRepository<TipoSolicitudEntity, Long> {
}
