package com.sicopi.application.adapter.solicitud;

import com.sicopi.application.port.in.solicitud.TipoSolicitudService;
import com.sicopi.application.port.out.persistence.solicitud.TipoSolicitudAbs;
import com.sicopi.domain.model.solicitud.TipoSolicitud;

public class TipoSolicitudAdapter implements TipoSolicitudService {

    private final TipoSolicitudAbs tipoSolicitudAbs;

    public TipoSolicitudAdapter(TipoSolicitudAbs tipoSolicitudAbs) {
        this.tipoSolicitudAbs = tipoSolicitudAbs;
    }

    @Override
    public TipoSolicitud registrarTipoSolicitud(TipoSolicitud tipoSolicitud) {
        return this.tipoSolicitudAbs.registrarTipoSolicitudAbs(tipoSolicitud);
    }
}
