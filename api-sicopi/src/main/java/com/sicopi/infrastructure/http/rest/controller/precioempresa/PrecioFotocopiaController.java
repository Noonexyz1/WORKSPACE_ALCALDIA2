package com.sicopi.infrastructure.http.rest.controller.precioempresa;

import com.sicopi.application.port.in.precioempresa.PrecioFotocopiaService;
import com.sicopi.domain.model.precioempresa.PrecioFotocopia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/precioFotocopia")
public class PrecioFotocopiaController {

    @Autowired
    private PrecioFotocopiaService precioFotocopiaService;

    @PostMapping("/registrarPrecioFotocopia")
    public PrecioFotocopia registrarPrecioFotocopia(@RequestBody PrecioFotocopia precioFotocopia) {
        return this.precioFotocopiaService.registrarPrecioFotocopia(precioFotocopia);
    }

    @PutMapping("/editarPrecioFotocopia/{idPrecioFotocopia}")
    public PrecioFotocopia editarPrecioFotocopia(
            @PathVariable Long idPrecioFotocopia,
            @RequestBody PrecioFotocopia precioFotocopia
    ) {
        return this.precioFotocopiaService
                .editarPrecioFotocopia(idPrecioFotocopia, precioFotocopia);
    }

    @GetMapping("/listaDeDocumentos")
    public Page<PrecioFotocopia> listaDePrecioFotocopia(Pageable pageable) {
        return this.precioFotocopiaService.listaDePrecioFotocopia(pageable);
    }
}
