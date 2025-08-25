package com.sicopi.infrastructure.http.rest.controller.solicitud;

import com.sicopi.application.port.in.solicitud.TipoSolicitudService;
import com.sicopi.domain.model.solicitud.TipoSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/tipoSolicitud")
public class TipoSolicitudController {

    @Autowired
    private TipoSolicitudService tipoSolicitudService;

    @PostMapping("/registrarTipoSolicitud")
    public TipoSolicitud registrarTipoSolicitud(@RequestBody TipoSolicitud tipoSolicitud) {
        return this.tipoSolicitudService.registrarTipoSolicitud(tipoSolicitud);
    }

    @PutMapping("/editarTipoSolicitud/{idTipoSolicitud}")
    public TipoSolicitud editarTipoSolicitud(
            @PathVariable Long idTipoSolicitud,
            @RequestBody TipoSolicitud tipoSolicitud
    ) {
        return this.tipoSolicitudService.editarTipoSolicitud(idTipoSolicitud, tipoSolicitud);
    }

    @PutMapping("/deshabilitarTipoSolicitud/{idTipoSolicitud}")
    public void deshabilitarTipoSolicitud(@PathVariable Long idTipoSolicitud) {
        this.tipoSolicitudService.deshabilitarTipoSolicitud(idTipoSolicitud);
    }

    @PutMapping("/habilitarTipoSolicitud/{idTipoSolicitud}")
    public void habilitarTipoSolicitud(@PathVariable Long idTipoSolicitud) {
        this.tipoSolicitudService.habilitarTipoSolicitud(idTipoSolicitud);
    }

    @GetMapping("/listaDeTipoSolicitud")
    public Page<TipoSolicitud> listaDeTipoSolicitud(Pageable pageable) {
        return this.tipoSolicitudService.listaDeTipoSolicitud(pageable);
    }
}
