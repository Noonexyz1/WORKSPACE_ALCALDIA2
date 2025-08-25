package com.sicopi.application.port.in.solicitud;

import com.sicopi.domain.model.solicitud.TipoSolicitud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TipoSolicitudService {
    TipoSolicitud registrarTipoSolicitud(TipoSolicitud tipoSolicitud);
    TipoSolicitud editarTipoSolicitud(Long idTipoSolicitud, TipoSolicitud tipoSolicitud);
    void deshabilitarTipoSolicitud(Long idTipoSolicitud);
    void habilitarTipoSolicitud(Long idTipoSolicitud);
    Page<TipoSolicitud> listaDeTipoSolicitud(Pageable pageable);
}
