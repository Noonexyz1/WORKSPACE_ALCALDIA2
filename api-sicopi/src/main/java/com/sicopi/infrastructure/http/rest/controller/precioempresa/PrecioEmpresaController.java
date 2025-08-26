package com.sicopi.infrastructure.http.rest.controller.precioempresa;

import com.sicopi.application.port.in.precioempresa.PrecioEmpresaService;
import com.sicopi.domain.model.precioempresa.PrecioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/precioEmpresa")
public class PrecioEmpresaController {

    @Autowired
    private PrecioEmpresaService precioEmpresaService;

    @PostMapping("/registrarPrecioEmpresa")
    public PrecioEmpresa registrarPrecioEmpresa(@RequestBody PrecioEmpresa precioEmpresa) {
        return this.precioEmpresaService.registrarPrecioEmpresa(precioEmpresa);
    }

    @GetMapping("/listaDePrecioEmpresa")
    public Page<PrecioEmpresa> listaDePrecioEmpresa(Pageable pageable) {
        return this.precioEmpresaService.listaDePrecioEmpresa(pageable);
    }

    @PutMapping("/habilitarPrecioEmpresa/{idPrecioEmpresa}")
    public void habilitarPrecioEmpresa(@PathVariable Long idPrecioEmpresa) {
        this.precioEmpresaService.habilitarPrecioEmpresa(idPrecioEmpresa);
    }

    @PutMapping("/deshabilitarPrecioEmpresa/{idPrecioEmpresa}")
    public void deshabilitarPrecioEmpresa(@PathVariable Long idPrecioEmpresa) {
        this.precioEmpresaService.deshabilitarPrecioEmpresa(idPrecioEmpresa);
    }
}
