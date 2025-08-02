package com.sicopi.application.adapter.autenticacion;

import com.sicopi.application.port.in.autenticacion.PermisoRolService;
import com.sicopi.application.port.out.persistence.autenticacion.PermisoRolAbs;
import com.sicopi.domain.model.autenticacion.PermisoRol;

public class PermisoRolAdapter implements PermisoRolService {

    private final PermisoRolAbs permisoRolAbs;

    public PermisoRolAdapter(PermisoRolAbs permisoRolAbs) {
        this.permisoRolAbs = permisoRolAbs;
    }


    @Override
    public PermisoRol registrarPermisoRol(PermisoRol permisoRol) {
        return this.permisoRolAbs.registrarPermisoRolAbs(permisoRol);
    }

    @Override
    public void deshabilitarPermisoRol() {

    }
}
