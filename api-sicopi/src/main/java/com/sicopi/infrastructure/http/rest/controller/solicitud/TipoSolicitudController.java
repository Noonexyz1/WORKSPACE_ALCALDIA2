package com.sicopi.infrastructure.http.rest.controller.solicitud;

import com.sicopi.application.port.in.solicitud.TipoSolicitudService;
import com.sicopi.domain.model.solicitud.TipoSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/tipoSolicitud")
public class TipoSolicitudController {

    @Autowired
    private TipoSolicitudService tipoSolicitudService;

    @PostMapping("/registrarTipoSolicitud")
    public TipoSolicitud registrarTipoSolicitud(@RequestBody TipoSolicitud tipoSolicitud) {
        return this.tipoSolicitudService.registrarTipoSolicitud(tipoSolicitud);
    }
}
