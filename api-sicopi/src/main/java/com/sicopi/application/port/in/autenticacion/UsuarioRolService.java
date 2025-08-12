package com.sicopi.application.port.in.autenticacion;

import com.sicopi.domain.model.autenticacion.UsuarioRol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioRolService {
    UsuarioRol registrarUsuarioRol(UsuarioRol usuarioRol);
    void deshabilitarUsuarioRol();
    Page<UsuarioRol> listaDeUsuarioRol(Pageable pageable);
}
