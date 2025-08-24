package com.sicopi.application.port.out.persistence.autenticacion;

import com.sicopi.domain.model.autenticacion.PermisoRol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PermisoRolAbs {
    PermisoRol registrarPermisoRolAbs(PermisoRol permisoRol);
    Page<PermisoRol> listaDePermisoRolAbs(Pageable pageable);
    Optional<PermisoRol> encontrarPerRolById(Long idPermisoRol);
}
