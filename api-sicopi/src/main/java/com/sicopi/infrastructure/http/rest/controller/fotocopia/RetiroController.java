package com.sicopi.infrastructure.http.rest.controller.fotocopia;

import com.sicopi.application.port.in.fotocopia.RetiroService;
import com.sicopi.domain.model.fotocopia.Retiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/retiro")
public class RetiroController {

    @Autowired
    private RetiroService retiroService;

    @PostMapping("/registrarRetiro")
    public Retiro registrarRetiro(@RequestBody Retiro retiro) {
        return this.retiroService.registrarRetiro(retiro);
    }
}
