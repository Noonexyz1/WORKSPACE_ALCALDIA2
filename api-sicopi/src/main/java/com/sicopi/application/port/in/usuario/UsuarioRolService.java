package com.sicopi.application.port.in.usuario;

import com.sicopi.domain.model.usuario.UsuarioRol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioRolService {
    UsuarioRol registrarUsuarioRol(UsuarioRol usuarioRol);
    void deshabilitarUsuarioRol(Long idUsuarioRol);
    Page<UsuarioRol> listaDeUsuarioRol(Pageable pageable);
    void habilitarUsuarioRol(Long idUsuarioRol);
}
