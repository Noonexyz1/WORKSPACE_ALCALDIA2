package com.sicopi.application.adapter.solicitud;

import com.sicopi.application.port.in.solicitud.SolicitudService;
import com.sicopi.application.port.out.persistence.solicitud.SolicitudAbs;
import com.sicopi.application.port.out.persistence.solicitud.TipoSolicitudAbs;
import com.sicopi.domain.model.solicitud.Solicitud;
import com.sicopi.domain.model.solicitud.TipoSolicitud;

import java.util.Optional;

public class SolicitudAdapter implements SolicitudService {

    private final SolicitudAbs solicitudAbs;
    private final TipoSolicitudAbs tipoSolicitudAbs;

    public SolicitudAdapter(
            SolicitudAbs solicitudAbs,
            TipoSolicitudAbs tipoSolicitudAbs
    ) {
        this.solicitudAbs = solicitudAbs;
        this.tipoSolicitudAbs = tipoSolicitudAbs;
    }


    @Override
    public Solicitud registrarSolicitud(Solicitud solicitud) {
        if (solicitud.getTipoSolicitud() == null ||
                solicitud.getTipoSolicitud().getId() == null) {

            throw new RuntimeException("El tipo de solicitud no debe ser vacio");
        }

        Optional<TipoSolicitud> tipoSolicitudFinded = this.tipoSolicitudAbs
                .encontrarTipoSolicitudById(solicitud.getTipoSolicitud().getId());

        if (tipoSolicitudFinded.isEmpty()) {
            throw new RuntimeException("No existe este id de tipo de solicitud");
        }

        solicitud.setTipoSolicitud(tipoSolicitudFinded.get());
        return this.solicitudAbs.registrarSolicitudAbs(solicitud);
    }

}
