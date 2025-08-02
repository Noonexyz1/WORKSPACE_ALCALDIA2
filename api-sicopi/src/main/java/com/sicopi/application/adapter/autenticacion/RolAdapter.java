package com.sicopi.application.adapter.autenticacion;

import com.sicopi.application.port.in.autenticacion.RolService;
import com.sicopi.application.port.out.persistence.autenticacion.RolAbs;
import com.sicopi.domain.model.autenticacion.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class RolAdapter implements RolService {

    private final RolAbs rolAbs;

    public RolAdapter(RolAbs rolAbs) {
        this.rolAbs = rolAbs;
    }


    @Override
    public Rol registarRol(Rol rol) {
        return this.rolAbs.registarRolAbs(rol);
    }

    @Override
    public Rol editarRol(Long idRol, Rol rol) {
        return null;
    }

    @Override
    public Page<Rol> listaDeRoles(Pageable pageable) {
        return this.rolAbs.listaDeRolesAbs(pageable);
    }

    @Override
    public void deshabilitarRol() {

    }
}
