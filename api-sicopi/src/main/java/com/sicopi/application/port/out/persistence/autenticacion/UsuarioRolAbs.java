package com.sicopi.application.port.out.persistence.autenticacion;

import com.sicopi.domain.model.autenticacion.UsuarioRol;

public interface UsuarioRolAbs {
    UsuarioRol registrarUsuarioRolAbs(UsuarioRol usuarioRol);
    void deshabilitarUsuarioRolAbs();
    UsuarioRol encontrarPorIdUsuario(Long idUsuario);
}
