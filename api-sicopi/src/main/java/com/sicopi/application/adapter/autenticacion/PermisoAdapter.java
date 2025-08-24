package com.sicopi.application.adapter.autenticacion;

import com.sicopi.application.port.in.autenticacion.PermisoService;
import com.sicopi.application.port.out.persistence.autenticacion.PermisoAbs;
import com.sicopi.domain.model.autenticacion.Permiso;
import com.sicopi.domain.model.persona.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

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
        Optional<Permiso> permisoFind = this.permisoAbs.buscarPermisoById(idPermiso);
        if (permisoFind.isEmpty()) {
            throw new RuntimeException("No existe este permiso con este id");
        }
        permiso.setId(permisoFind.get().getId());
        return this.permisoAbs.registarPermisoAbs(permiso);
    }

    @Override
    public Page<Permiso> listaDePermisos(Pageable pageable) {
        return this.permisoAbs.listaDePermisosAbs(pageable);
    }

    @Override
    public void deshabilitarPermiso() {

    }
}
