package com.sicopi.application.adapter.solicitud;

import com.sicopi.application.port.in.solicitud.TipoSolicitudService;
import com.sicopi.application.port.out.persistence.solicitud.TipoSolicitudAbs;
import com.sicopi.domain.model.solicitud.TipoSolicitud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class TipoSolicitudAdapter implements TipoSolicitudService {

    private final TipoSolicitudAbs tipoSolicitudAbs;

    public TipoSolicitudAdapter(TipoSolicitudAbs tipoSolicitudAbs) {
        this.tipoSolicitudAbs = tipoSolicitudAbs;
    }

    @Override
    public TipoSolicitud registrarTipoSolicitud(TipoSolicitud tipoSolicitud) {
        tipoSolicitud.setActivo(true);
        return this.tipoSolicitudAbs.registrarTipoSolicitudAbs(tipoSolicitud);
    }

    @Override
    public TipoSolicitud editarTipoSolicitud(Long idTipoSolicitud, TipoSolicitud tipoSolicitud) {
        Optional<TipoSolicitud> tipoSolicitudFinded = this.tipoSolicitudAbs
                .encontrarTipoSolicitudById(idTipoSolicitud);
        if (tipoSolicitudFinded.isEmpty()) {
            throw new RuntimeException("No existe este id de tipo-solicitud");
        }
        tipoSolicitud.setId(tipoSolicitudFinded.get().getId());
        return this.tipoSolicitudAbs.registrarTipoSolicitudAbs(tipoSolicitud);
    }

    @Override
    public void deshabilitarTipoSolicitud(Long idTipoSolicitud) {
        Optional<TipoSolicitud> tipoSolicitudFinded = this.tipoSolicitudAbs
                .encontrarTipoSolicitudById(idTipoSolicitud);
        if (tipoSolicitudFinded.isEmpty()) {
            throw new RuntimeException("No existe este id de tipo-solicitud");
        }
        tipoSolicitudFinded.get().setActivo(false);
        this.tipoSolicitudAbs.registrarTipoSolicitudAbs(tipoSolicitudFinded.get());
    }

    @Override
    public void habilitarTipoSolicitud(Long idTipoSolicitud) {
        Optional<TipoSolicitud> tipoSolicitudFinded = this.tipoSolicitudAbs
                .encontrarTipoSolicitudById(idTipoSolicitud);
        if (tipoSolicitudFinded.isEmpty()) {
            throw new RuntimeException("No existe este id de tipo-solicitud");
        }
        tipoSolicitudFinded.get().setActivo(true);
        this.tipoSolicitudAbs.registrarTipoSolicitudAbs(tipoSolicitudFinded.get());
    }

    @Override
    public Page<TipoSolicitud> listaDeTipoSolicitud(Pageable pageable) {
        return this.tipoSolicitudAbs.listaDeTipoSolicitud(pageable);
    }
}
