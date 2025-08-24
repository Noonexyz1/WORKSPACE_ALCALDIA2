package com.sicopi.application.adapter.autenticacion;

import com.sicopi.application.port.in.autenticacion.RolService;
import com.sicopi.application.port.out.persistence.autenticacion.RolAbs;
import com.sicopi.domain.model.autenticacion.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class RolAdapter implements RolService {

    private final RolAbs rolAbs;

    public RolAdapter(RolAbs rolAbs) {
        this.rolAbs = rolAbs;
    }


    @Override
    public Rol registarRol(Rol rol) {
        rol.setActivo(true);
        return this.rolAbs.registarRolAbs(rol);
    }

    @Override
    public Rol editarRol(Long idRol, Rol rol) {
        Optional<Rol> rolFind = this.rolAbs.encontrarRolById(idRol);
        if (rolFind.isEmpty()) {
            throw new RuntimeException("Rol con este ID no existe");
        }
        rol.setId(rolFind.get().getId());
        return this.rolAbs.registarRolAbs(rol);
    }

    @Override
    public Page<Rol> listaDeRoles(Pageable pageable) {
        return this.rolAbs.listaDeRolesAbs(pageable);
    }

    @Override
    public void deshabilitarRol(Long idRol) {
        Optional<Rol> rolFind = this.rolAbs.encontrarRolById(idRol);
        if (rolFind.isEmpty()) {
            throw new RuntimeException("Rol con este ID no existe");
        }
        rolFind.get().setActivo(false);
        this.rolAbs.registarRolAbs(rolFind.get());
    }

    @Override
    public void habilitarRol(Long idRol) {
        Optional<Rol> rolFind = this.rolAbs.encontrarRolById(idRol);
        if (rolFind.isEmpty()) {
            throw new RuntimeException("Rol con este ID no existe");
        }
        rolFind.get().setActivo(true);
        this.rolAbs.registarRolAbs(rolFind.get());
    }
}
