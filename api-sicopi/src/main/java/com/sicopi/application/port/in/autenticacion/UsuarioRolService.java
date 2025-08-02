package com.sicopi.application.port.in.autenticacion;

import com.sicopi.domain.model.autenticacion.UsuarioRol;

public interface UsuarioRolService {
    UsuarioRol registrarUsuarioRol(UsuarioRol usuarioRol);
    void deshabilitarUsuarioRol();
}
