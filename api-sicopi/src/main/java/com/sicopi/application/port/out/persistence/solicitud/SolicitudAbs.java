package com.sicopi.application.port.out.persistence.solicitud;

import com.sicopi.domain.model.solicitud.Solicitud;

public interface SolicitudAbs {
    Solicitud registrarSolicitudAbs(Solicitud solicitud);
}
