package com.sicopi.infrastructure.http.rest.controller.fotocopia;

import com.sicopi.application.port.in.fotocopia.FotoFinalizadaService;
import com.sicopi.domain.model.fotocopia.FotoFinalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/fotoFinalizada")
public class FotoFinalizadaController {

    @Autowired
    private FotoFinalizadaService fotoFinalizadaService;

    @PostMapping("/registrarFotoFinalizada")
    public FotoFinalizada registrarFotoFinalizada(@RequestBody FotoFinalizada fotoFinalizada) {
        return this.fotoFinalizadaService.registrarFotoFinalizada(fotoFinalizada);
    }
}
