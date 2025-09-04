package com.sicopi.application.adapter.usuario;

import com.sicopi.application.port.in.usuario.UsuarioService;
import com.sicopi.application.port.out.persistence.usuario.UsuarioAbs;
import com.sicopi.domain.model.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class UsuarioAdapter implements UsuarioService {

    private final UsuarioAbs usuarioAbs;

    public UsuarioAdapter(UsuarioAbs usuarioAbs) {
        this.usuarioAbs = usuarioAbs;
    }


    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setActivo(true);
        return this.usuarioAbs.registrarUsuarioAbs(usuario);
    }

    @Override
    public void deshabilitarUsuario(Long idUsuario) {
        Optional<Usuario> usuario = this.usuarioAbs.encontrarUsuarioPorId(idUsuario);
        if (usuario.isEmpty()) {
            throw new RuntimeException("Usuario con este id no existe");
        }
        usuario.get().setActivo(false);
        this.usuarioAbs.registrarUsuarioAbs(usuario.get());
    }

    @Override
    public void habilitarUsuario(Long idUsuario) {
        Optional<Usuario> usuario = this.usuarioAbs.encontrarUsuarioPorId(idUsuario);
        if (usuario.isEmpty()) {
            throw new RuntimeException("Usuario con este id no existe");
        }
        usuario.get().setActivo(true);
        this.usuarioAbs.registrarUsuarioAbs(usuario.get());
    }

    @Override
    public Optional<Usuario> encontrarUsuarioPorId(Long idUsuario) {
        return this.usuarioAbs.encontrarUsuarioPorId(idUsuario);
    }

    @Override
    public Page<Usuario> listaDeUsuarios(Pageable pageable) {
        return this.usuarioAbs.listaDeUsuariosAbs(pageable);
    }
}
