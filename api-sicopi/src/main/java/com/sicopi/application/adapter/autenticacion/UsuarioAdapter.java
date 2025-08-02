package com.sicopi.application.adapter.autenticacion;

import com.sicopi.application.port.in.autenticacion.UsuarioService;
import com.sicopi.application.port.out.persistence.autenticacion.UsuarioAbs;
import com.sicopi.domain.model.autenticacion.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UsuarioAdapter implements UsuarioService {

    private final UsuarioAbs usuarioAbs;

    public UsuarioAdapter(UsuarioAbs usuarioAbs) {
        this.usuarioAbs = usuarioAbs;
    }


    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return this.usuarioAbs.registrarUsuarioAbs(usuario);
    }

    @Override
    public void deshabilitarUsuario() {

    }

    @Override
    public Page<Usuario> listaDeUsuarios(Pageable pageable) {
        return this.usuarioAbs.listaDeUsuariosAbs(pageable);
    }
}
