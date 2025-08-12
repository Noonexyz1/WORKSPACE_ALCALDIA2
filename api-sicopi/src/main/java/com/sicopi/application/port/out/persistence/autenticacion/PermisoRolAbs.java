package com.sicopi.application.port.out.persistence.autenticacion;

import com.sicopi.domain.model.autenticacion.PermisoRol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PermisoRolAbs {
    PermisoRol registrarPermisoRolAbs(PermisoRol permisoRol);
    void deshabilitarPermisoRolAbs();
    Page<PermisoRol> listaDePermisoRolAbs(Pageable pageable);
}
