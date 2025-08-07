package com.sicopi.application.port.out.persistence.autenticacion;

import com.sicopi.domain.model.autenticacion.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioAbs {
    //Casos de uso, segun historias de usuario CREAR ROLES, EDITARLOS, PERMISOS
    Usuario registrarUsuarioAbs(Usuario usuario);
    //void editarUsuario();
    void deshabilitarUsuarioAbs(); //Esto es a nivel de sistema, no podra iniciar sesion
    Page<Usuario> listaDeUsuariosAbs(Pageable pageable);
    Usuario encontrarUsuarioPorUsername(String username);
}
