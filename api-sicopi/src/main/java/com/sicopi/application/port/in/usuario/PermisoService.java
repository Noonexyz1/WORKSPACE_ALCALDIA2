package com.sicopi.application.port.in.usuario;

import com.sicopi.domain.model.usuario.Permiso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PermisoService {
    Permiso registarPermiso(Permiso permiso);
    Permiso editarPermiso(Long idPermiso, Permiso permiso);
    Page<Permiso> listaDePermisos(Pageable pageable);
}
