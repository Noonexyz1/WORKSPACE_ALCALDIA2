package com.sicopi.application.adapter.login;

import com.sicopi.application.port.in.login.LoginService;
import com.sicopi.application.port.out.persistence.autenticacion.UsuarioAbs;
import com.sicopi.application.port.out.persistence.autenticacion.UsuarioRolAbs;
import com.sicopi.domain.model.autenticacion.Usuario;
import com.sicopi.domain.model.autenticacion.UsuarioRol;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginAdapter implements LoginService {

    private final UsuarioRolAbs usuarioRolAbs;
    private final UsuarioAbs usuarioAbs;

    @Override
    public UsuarioRol iniciarSesion(String username, String password) {
        Usuario usuario = this.usuarioAbs.encontrarUsuarioPorUsername(username);
        if (usuario == null) throw new RuntimeException("Este usuario con username no existe");
        //Aqui Hacemos la parte de la autenticacion
        usuario.setPassword(null);

        UsuarioRol usuarioRol = this.usuarioRolAbs.encontrarPorIdUsuario(usuario.getId());
        if (usuarioRol == null) throw new RuntimeException("Usuario-rol no existe");
        usuarioRol.getUsuario().setPassword(null);

        return usuarioRol;
    }
}
