package com.sicopi.application.adapter.autenticacion;

import com.sicopi.application.port.in.autenticacion.PermisoService;
import com.sicopi.application.port.out.persistence.autenticacion.PermisoAbs;
import com.sicopi.domain.model.autenticacion.Permiso;
import com.sicopi.domain.model.persona.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PermisoAdapter implements PermisoService {

    private final PermisoAbs permisoAbs;

    public PermisoAdapter(PermisoAbs permisoAbs) {
        this.permisoAbs = permisoAbs;
    }


    @Override
    public Permiso registarPermiso(Permiso permiso) {
        return this.permisoAbs.registarPermisoAbs(permiso);
    }

    @Override
    public Permiso editarPermiso(Long idPermiso, Permiso permiso) {
        return null;
    }

    @Override
    public Page<Permiso> listaDePermisos(Pageable pageable) {
        return this.permisoAbs.listaDePermisosAbs(pageable);
    }

    @Override
    public void deshabilitarPermiso() {

    }
}
