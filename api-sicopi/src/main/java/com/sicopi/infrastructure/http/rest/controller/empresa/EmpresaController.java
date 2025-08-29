package com.sicopi.infrastructure.http.rest.controller.empresa;

import com.sicopi.application.port.in.empresa.EmpresaService;
import com.sicopi.domain.model.empresa.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/registrarEmpresa")
    public Empresa registrarEmpresa(@RequestBody Empresa empresa) {
        return this.empresaService.registrarEmpresa(empresa);
    }

    @PutMapping("/editarEmpresa/{idEmpresa}")
    public Empresa editarEmpresa(
            @PathVariable Long idEmpresa,
            @RequestBody Empresa empresa
    ) {
        return this.empresaService.editarEmpresa(idEmpresa, empresa);
    }

    @GetMapping("/listaDeEmpresas")
    public Page<Empresa> listaDeEmpresas(Pageable pageable) {
        return this.empresaService.listaDeEmpresas(pageable);
    }
}
