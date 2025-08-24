package com.sicopi.application.port.out.persistence.autenticacion;

import com.sicopi.domain.model.autenticacion.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RolAbs {
    Rol registarRolAbs(Rol rol);
    Rol editarRolAbs(Long idRol, Rol rol);
    Page<Rol> listaDeRolesAbs(Pageable pageable);
    void deshabilitarRolAbs();
    Optional<Rol> encontrarRolById(Long idRol);
}
