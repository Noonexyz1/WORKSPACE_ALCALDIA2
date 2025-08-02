package com.sicopi.infrastructure.persistence.db.adapter.solicitud;

import com.sicopi.application.port.out.persistence.solicitud.SolicitudAbs;
import com.sicopi.domain.model.solicitud.Solicitud;
import com.sicopi.infrastructure.persistence.db.entity.solicitud.SolicitudEntity;
import com.sicopi.infrastructure.persistence.db.entity.solicitud.TipoSolicitudEntity;
import com.sicopi.infrastructure.persistence.db.map.solicitud.SolicitudMapper;
import com.sicopi.infrastructure.persistence.db.repository.solicitud.SolicitudRepository;
import com.sicopi.infrastructure.persistence.db.repository.solicitud.TipoSolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SolicitudAbsAdapter implements SolicitudAbs {

    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private TipoSolicitudRepository tipoSolicitudRepository;

    @Override
    @Transactional
    public Solicitud registrarSolicitudAbs(Solicitud solicitud) {
        if (solicitud.getId() != null) {
            throw new RuntimeException("El id de esta solicitud debe ser null");
        }

        if (solicitud.getSolicitante().getId() == null &&
                solicitud.getTipoSolicitud().getId() == null) {
            throw new RuntimeException("Ingrese Ids existentes");
        }

        TipoSolicitudEntity tipoSolicitudEntity = this.tipoSolicitudRepository
                .findById(solicitud.getTipoSolicitud().getId()).orElse(null);

        if (tipoSolicitudEntity == null) {
            throw new RuntimeException("Este id de tipo-solicitud no existe");
        }


        SolicitudEntity solicitudEntity = SolicitudMapper.INSTANCE.toSolicitudEntity(solicitud);
        solicitudEntity.setTipoSolicitud(tipoSolicitudEntity);
        this.solicitudRepository.save(solicitudEntity);
        return SolicitudMapper.INSTANCE.toSolicitud(solicitudEntity);
    }
}
