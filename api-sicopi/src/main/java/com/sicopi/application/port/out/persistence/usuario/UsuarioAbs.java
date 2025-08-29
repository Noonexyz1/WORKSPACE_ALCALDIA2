package com.sicopi.application.port.out.persistence.usuario;

import com.sicopi.domain.model.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UsuarioAbs {
    //Casos de uso, segun historias de usuario CREAR ROLES, EDITARLOS, PERMISOS
    Usuario registrarUsuarioAbs(Usuario usuario);
    Page<Usuario> listaDeUsuariosAbs(Pageable pageable);
    Optional<Usuario> encontrarUsuarioPorId(Long idUsuario);
}
