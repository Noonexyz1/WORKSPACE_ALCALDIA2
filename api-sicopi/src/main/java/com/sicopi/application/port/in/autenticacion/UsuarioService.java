package com.sicopi.application.port.in.autenticacion;

import com.sicopi.domain.model.autenticacion.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {
    //Casos de uso, segun historias de usuario CREAR ROLES, EDITARLOS, PERMISOS
    Usuario registrarUsuario(Usuario usuario);
    //void editarUsuario();
    void deshabilitarUsuario(); //Esto es a nivel de sistema, no podra iniciar sesion
    Page<Usuario> listaDeUsuarios(Pageable pageable);
}
