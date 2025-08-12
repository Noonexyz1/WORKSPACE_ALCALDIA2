package com.sicopi.infrastructure.http.rest.controller.autenticacion;

import com.sicopi.application.port.in.autenticacion.UsuarioRolService;
import com.sicopi.domain.model.autenticacion.UsuarioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/usuarioRol")
public class UsuarioRolController {

    @Autowired
    private UsuarioRolService usuarioRolService;


    @PostMapping("/registrarUsuarioRol")
    public UsuarioRol registrarUsuarioRol(@RequestBody UsuarioRol usuarioRol) {
        return this.usuarioRolService.registrarUsuarioRol(usuarioRol);
    }

    @GetMapping("/listaDeUsuarioRol")
    public Page<UsuarioRol> listaDeUsuarioRol(Pageable pageable) {
        return this.usuarioRolService.listaDeUsuarioRol(pageable);
    }
}
