package com.sicopi.application.port.in.usuario;

import com.sicopi.domain.model.usuario.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RolService {
    Rol registarRol(Rol rol);
    Rol editarRol(Long idRol, Rol rol);
    Page<Rol> listaDeRoles(Pageable pageable);
    void deshabilitarRol(Long idRol);
    void habilitarRol(Long idRol);
}
