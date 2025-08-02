package com.sicopi.application.port.in.autenticacion;

import com.sicopi.domain.model.autenticacion.Permiso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PermisoService {
    Permiso registarPermiso(Permiso permiso);
    Permiso editarPermiso(Long idPermiso, Permiso permiso);
    Page<Permiso> listaDePermisos(Pageable pageable);
    void deshabilitarPermiso();
}
