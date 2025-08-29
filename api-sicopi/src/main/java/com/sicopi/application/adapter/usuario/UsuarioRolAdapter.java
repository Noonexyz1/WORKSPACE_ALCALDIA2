package com.sicopi.application.adapter.usuario;

import com.sicopi.application.port.in.usuario.UsuarioRolService;
import com.sicopi.application.port.out.persistence.usuario.UsuarioRolAbs;
import com.sicopi.domain.model.usuario.UsuarioRol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class UsuarioRolAdapter implements UsuarioRolService {

    private final UsuarioRolAbs usuarioRolAbs;

    public UsuarioRolAdapter(UsuarioRolAbs usuarioRolAbs) {
        this.usuarioRolAbs = usuarioRolAbs;
    }


    @Override
    public UsuarioRol registrarUsuarioRol(UsuarioRol usuarioRol) {
        usuarioRol.setActivo(true);
        return this.usuarioRolAbs.registrarUsuarioRolAbs(usuarioRol);
    }

    @Override
    public void deshabilitarUsuarioRol(Long idUsuarioRol) {
        Optional<UsuarioRol> usuarioRol = this.usuarioRolAbs
                .encontrarUsuRolPorId(idUsuarioRol);
        if (usuarioRol.isEmpty()) {
            throw new RuntimeException("Usuario-rol con este id no existe");
        }
        usuarioRol.get().setActivo(false);
        this.usuarioRolAbs.registrarUsuarioRolAbs(usuarioRol.get());
    }

    @Override
    public void habilitarUsuarioRol(Long idUsuarioRol) {
        Optional<UsuarioRol> usuarioRol = this.usuarioRolAbs
                .encontrarUsuRolPorId(idUsuarioRol);
        if (usuarioRol.isEmpty()) {
            throw new RuntimeException("Usuario-rol con este id no existe");
        }
        usuarioRol.get().setActivo(true);
        this.usuarioRolAbs.registrarUsuarioRolAbs(usuarioRol.get());
    }

    @Override
    public Page<UsuarioRol> listaDeUsuarioRol(Pageable pageable) {
        return this.usuarioRolAbs.listaDeUsuarioRolAbs(pageable);
    }
}
