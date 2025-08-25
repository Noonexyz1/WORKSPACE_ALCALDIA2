package com.sicopi.infrastructure.persistence.db.adapter.solicitud;

import com.sicopi.application.port.out.persistence.solicitud.TipoSolicitudAbs;
import com.sicopi.domain.model.solicitud.TipoSolicitud;
import com.sicopi.infrastructure.persistence.db.entity.solicitud.TipoSolicitudEntity;
import com.sicopi.infrastructure.persistence.db.map.solicitud.TipoSolicitudMapper;
import com.sicopi.infrastructure.persistence.db.repository.solicitud.TipoSolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    @Override
    public Optional<TipoSolicitud> encontrarTipoSolicitudById(Long idTipoSolicitud) {
        Optional<TipoSolicitudEntity> byId = this.tipoSolicitudRepository.findById(idTipoSolicitud);
        return byId.map(TipoSolicitudMapper.INSTANCE::toTipoSolicitud);
    }

    @Override
    public Page<TipoSolicitud> listaDeTipoSolicitud(Pageable pageable) {
        Page<TipoSolicitudEntity> all = this.tipoSolicitudRepository.findAll(pageable);
        return all.map(TipoSolicitudMapper.INSTANCE::toTipoSolicitud);
    }
}
