package com.sicopi.infrastructure.persistence.db.adapter.solicitud;

import com.sicopi.application.port.out.persistence.solicitud.TipoSolicitudAbs;
import com.sicopi.domain.model.solicitud.TipoSolicitud;
import com.sicopi.infrastructure.persistence.db.entity.solicitud.TipoSolicitudEntity;
import com.sicopi.infrastructure.persistence.db.map.solicitud.TipoSolicitudMapper;
import com.sicopi.infrastructure.persistence.db.repository.solicitud.TipoSolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TipoSolicitudAbsAdapter implements TipoSolicitudAbs {

    @Autowired
    private TipoSolicitudRepository tipoSolicitudRepository;

    @Override
    public TipoSolicitud registrarTipoSolicitudAbs(TipoSolicitud tipoSolicitud) {
        TipoSolicitudEntity tipoSolicitudEntity = this.tipoSolicitudRepository
                .save(TipoSolicitudMapper.INSTANCE.toTipoSolicitudEntity(tipoSolicitud));
        return TipoSolicitudMapper.INSTANCE.toTipoSolicitud(tipoSolicitudEntity);
    }
}
