package com.sicopi.application.port.in.login;

import com.sicopi.domain.model.autenticacion.UsuarioRol;

public interface LoginService {
    UsuarioRol iniciarSesion(String username, String password);
}
