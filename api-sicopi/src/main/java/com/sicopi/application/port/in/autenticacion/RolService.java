package com.sicopi.application.port.in.autenticacion;

import com.sicopi.domain.model.autenticacion.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RolService {
    Rol registarRol(Rol rol);
    Rol editarRol(Long idRol, Rol rol);
    Page<Rol> listaDeRoles(Pageable pageable);
    void deshabilitarRol();
}
