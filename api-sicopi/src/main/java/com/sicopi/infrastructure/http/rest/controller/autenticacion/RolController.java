package com.sicopi.infrastructure.http.rest.controller.autenticacion;

import com.sicopi.application.port.in.autenticacion.RolService;
import com.sicopi.domain.model.autenticacion.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/rol")
public class RolController {

    @Autowired
    private RolService rolService;


    @PostMapping("/registarRol")
    public Rol registarRol(@RequestBody Rol rol) {
        return this.rolService.registarRol(rol);
    }

    @GetMapping("/listaDeRoles")
    public Page<Rol> listaDeRoles(Pageable pageable) {
        return this.rolService.listaDeRoles(pageable);
    }

    /*@PutMapping("/editarRol/{idRol}")
    public Rol editarRol(@PathVariable Long idRol, @RequestBody Rol rol) {
        return null;
    }*/

    /*public void deshabilitarRol() {

    }*/
}
