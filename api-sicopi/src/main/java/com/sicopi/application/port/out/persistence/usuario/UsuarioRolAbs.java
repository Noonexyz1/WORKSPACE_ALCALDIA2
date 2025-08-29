package com.sicopi.application.port.out.persistence.usuario;

import com.sicopi.domain.model.usuario.UsuarioRol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UsuarioRolAbs {
    UsuarioRol registrarUsuarioRolAbs(UsuarioRol usuarioRol);
    Page<UsuarioRol> listaDeUsuarioRolAbs(Pageable pageable);
    Optional<UsuarioRol> encontrarUsuRolPorId(Long idUsuarioRol);
}
