package com.sicopi.application.port.out.persistence.autenticacion;

import com.sicopi.domain.model.autenticacion.PermisoRol;

public interface PermisoRolAbs {
    PermisoRol registrarPermisoRolAbs(PermisoRol permisoRol);
    void deshabilitarPermisoRolAbs();
}
