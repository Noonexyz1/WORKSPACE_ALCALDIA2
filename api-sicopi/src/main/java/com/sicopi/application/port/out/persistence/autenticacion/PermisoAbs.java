package com.sicopi.application.port.out.persistence.autenticacion;

import com.sicopi.domain.model.autenticacion.Permiso;
import com.sicopi.domain.model.persona.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PermisoAbs {
    Permiso registarPermisoAbs(Permiso permiso);
    Page<Permiso> listaDePermisosAbs(Pageable pageable);
    Optional<Permiso> buscarPermisoById(Long idPermiso);
}
