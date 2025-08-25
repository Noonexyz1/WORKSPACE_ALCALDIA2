package com.sicopi.application.port.out.persistence.solicitud;

import com.sicopi.domain.model.solicitud.TipoSolicitud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TipoSolicitudAbs {
    TipoSolicitud registrarTipoSolicitudAbs(TipoSolicitud tipoSolicitud);
    Optional<TipoSolicitud> encontrarTipoSolicitudById(Long idTipoSolicitud);
    Page<TipoSolicitud> listaDeTipoSolicitud(Pageable pageable);
}
