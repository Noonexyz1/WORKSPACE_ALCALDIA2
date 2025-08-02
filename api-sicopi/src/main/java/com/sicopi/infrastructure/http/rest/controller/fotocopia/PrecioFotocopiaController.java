package com.sicopi.infrastructure.http.rest.controller.fotocopia;

import com.sicopi.application.port.in.fotocopia.PrecioFotocopiaService;
import com.sicopi.domain.model.fotocopia.PrecioFotocopia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/precioFotocopia")
public class PrecioFotocopiaController {

    @Autowired
    private PrecioFotocopiaService precioFotocopiaService;

    @PostMapping("/registrarPrecioFotocopia")
    public PrecioFotocopia registrarPrecioFotocopia(@RequestBody PrecioFotocopia precioFotocopia) {
        return this.precioFotocopiaService.registrarPrecioFotocopia(precioFotocopia);
    }
}
