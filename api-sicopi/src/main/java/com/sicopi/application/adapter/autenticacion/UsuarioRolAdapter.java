package com.sicopi.application.adapter.autenticacion;

import com.sicopi.application.port.in.autenticacion.UsuarioRolService;
import com.sicopi.application.port.out.persistence.autenticacion.UsuarioRolAbs;
import com.sicopi.domain.model.autenticacion.UsuarioRol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UsuarioRolAdapter implements UsuarioRolService {

    private final UsuarioRolAbs usuarioRolAbs;

    public UsuarioRolAdapter(UsuarioRolAbs usuarioRolAbs) {
        this.usuarioRolAbs = usuarioRolAbs;
    }


    @Override
    public UsuarioRol registrarUsuarioRol(UsuarioRol usuarioRol) {
        return this.usuarioRolAbs.registrarUsuarioRolAbs(usuarioRol);
    }

    @Override
    public void deshabilitarUsuarioRol() {

    }

    @Override
    public Page<UsuarioRol> listaDeUsuarioRol(Pageable pageable) {
        return this.usuarioRolAbs.listaDeUsuarioRolAbs(pageable);
    }
}
