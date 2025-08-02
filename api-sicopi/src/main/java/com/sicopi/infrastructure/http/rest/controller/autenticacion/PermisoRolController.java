package com.sicopi.infrastructure.http.rest.controller.autenticacion;

import com.sicopi.application.port.in.autenticacion.PermisoRolService;
import com.sicopi.domain.model.autenticacion.PermisoRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/permisoRol")
public class PermisoRolController {

    @Autowired
    private PermisoRolService permisoRolService;


    @PostMapping("/registrarPermisoRol")
    public PermisoRol registrarPermisoRol(@RequestBody PermisoRol permisoRol) {
        return this.permisoRolService.registrarPermisoRol(permisoRol);
    }

    /*public void deshabilitarPermisoRol() {

    }*/
}
