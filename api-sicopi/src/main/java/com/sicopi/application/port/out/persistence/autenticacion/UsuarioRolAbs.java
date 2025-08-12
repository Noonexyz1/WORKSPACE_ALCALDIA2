package com.sicopi.application.port.out.persistence.autenticacion;

import com.sicopi.domain.model.autenticacion.UsuarioRol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioRolAbs {
    UsuarioRol registrarUsuarioRolAbs(UsuarioRol usuarioRol);
    void deshabilitarUsuarioRolAbs();
    UsuarioRol encontrarPorIdUsuario(Long idUsuario);
    Page<UsuarioRol> listaDeUsuarioRolAbs(Pageable pageable);
}
