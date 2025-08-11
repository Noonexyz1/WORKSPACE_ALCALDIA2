package com.sicopi.infrastructure.http.rest.controller.login;

import com.sicopi.application.port.in.login.LoginService;
import com.sicopi.domain.model.autenticacion.Usuario;
import com.sicopi.domain.model.autenticacion.UsuarioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/iniciarSesion")
    public UsuarioRol iniciarSesion(@RequestBody Usuario usuario) {
        return this.loginService.iniciarSesion(
                usuario.getUsername(),
                usuario.getPassword());
    }
}
