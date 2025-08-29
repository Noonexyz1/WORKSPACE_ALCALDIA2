package com.sicopi.application.port.in.usuario;

import com.sicopi.domain.model.usuario.PermisoRol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PermisoRolService {
    PermisoRol registrarPermisoRol(PermisoRol permisoRol);
    void deshabilitarPermisoRol(Long idPermisoRol);
    Page<PermisoRol> listaDePermisoRol(Pageable pageable);
    void habilitarPermisoRol(Long idPermisoRol);
}
