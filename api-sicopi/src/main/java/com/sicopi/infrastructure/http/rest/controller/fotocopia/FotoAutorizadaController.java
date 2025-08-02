package com.sicopi.infrastructure.http.rest.controller.fotocopia;

import com.sicopi.application.port.in.fotocopia.FotoAutorizadaService;
import com.sicopi.domain.model.fotocopia.FotoAutorizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/fotoAutorizada")
public class FotoAutorizadaController {

    @Autowired
    private FotoAutorizadaService fotoAutorizadaService;

    @PostMapping("/registrarFotoAutorizada")
    public FotoAutorizada registrarFotoAutorizada(@RequestBody FotoAutorizada fotoAutorizada) {
        return this.fotoAutorizadaService.registrarFotoAutorizada(fotoAutorizada);
    }
}
