package com.sicopi.application.port.in.autenticacion;

import com.sicopi.domain.model.autenticacion.PermisoRol;

public interface PermisoRolService {
    PermisoRol registrarPermisoRol(PermisoRol permisoRol);
    void deshabilitarPermisoRol();
}
