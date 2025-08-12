package com.sicopi.application.port.in.autenticacion;

import com.sicopi.domain.model.autenticacion.PermisoRol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PermisoRolService {
    PermisoRol registrarPermisoRol(PermisoRol permisoRol);
    void deshabilitarPermisoRol();
    Page<PermisoRol> listaDePermisoRol(Pageable pageable);
}
