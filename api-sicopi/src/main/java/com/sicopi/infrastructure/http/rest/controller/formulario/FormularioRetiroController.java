package com.sicopi.infrastructure.http.rest.controller.formulario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/formularioRetiro")
public class FormularioRetiroController {

    /*@Autowired
    private FormularioRetiroService formularioRetiroService;

    @Transactional
    @PostMapping("/registrarFormularioRetiro")
    public void registrarFormularioRetiro(@RequestBody RetiroDTO funcionarioDTO) {
        this.formularioRetiroService.registrarFormularioRetiro(
            //TODO, registrar nuevos retitos de un determinado documento de muchos de una soli de fotocopia
        );
    }*/

}
