package com.sicopi.infrastructure.http.rest.controller.formulario;

import com.sicopi.application.port.in.formulario.FormularioRetiroService;
import com.sicopi.domain.model.fotocopia.Retiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1.1/formularioRetiro")
public class FormularioRetiroController {

    @Autowired
    private FormularioRetiroService formularioRetiroService;

    @Transactional
    @PostMapping("/registrarFormularioRetiro")
    public void registrarFormularioRetiro(@RequestBody List<Retiro> retiroList) {
        this.formularioRetiroService.registrarFormularioRetiro(retiroList);
    }
}
