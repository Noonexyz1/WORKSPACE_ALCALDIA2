package com.sicopi.infrastructure.http.rest.controller.fotocopia;

import com.sicopi.application.port.in.fotocopia.DocumentoService;
import com.sicopi.domain.model.fotocopia.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping("/registrarDocumento")
    public Documento registrarDocumento(@RequestBody Documento documento) {
        return this.documentoService.registrarDocumento(documento);
    }
}
