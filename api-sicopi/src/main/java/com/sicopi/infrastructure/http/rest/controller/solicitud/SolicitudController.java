package com.sicopi.infrastructure.http.rest.controller.solicitud;

import com.sicopi.application.port.in.solicitud.SolicitudService;
import com.sicopi.domain.model.solicitud.Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/solicitud")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;


    @PostMapping("/registrarSolicitud")
    public Solicitud registrarSolicitud(@RequestBody Solicitud solicitud) {
        return this.solicitudService.registrarSolicitud(solicitud);
    }

}
