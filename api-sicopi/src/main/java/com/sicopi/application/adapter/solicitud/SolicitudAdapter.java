package com.sicopi.application.adapter.solicitud;

import com.sicopi.application.port.in.solicitud.SolicitudService;
import com.sicopi.application.port.out.persistence.solicitud.SolicitudAbs;
import com.sicopi.domain.model.solicitud.Solicitud;

public class SolicitudAdapter implements SolicitudService {

    private final SolicitudAbs solicitudAbs;

    public SolicitudAdapter(SolicitudAbs solicitudAbs) {
        this.solicitudAbs = solicitudAbs;
    }


    @Override
    public Solicitud registrarSolicitud(Solicitud solicitud) {
        return this.solicitudAbs.registrarSolicitudAbs(solicitud);
    }

}
