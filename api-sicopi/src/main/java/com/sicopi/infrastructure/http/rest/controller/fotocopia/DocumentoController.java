package com.sicopi.infrastructure.http.rest.controller.fotocopia;

import com.sicopi.application.port.in.fotocopia.DocumentoService;
import com.sicopi.domain.model.fotocopia.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping("/registrarDocumento")
    public Documento registrarDocumento(@RequestBody Documento documento) {
        return this.documentoService.registrarDocumento(documento);
    }

    @PutMapping("/editarDocumento/{idDocumento}")
    public Documento editarDocumento(Long idDocumento, Documento documento) {
        return this.documentoService.editarDocumento(idDocumento, documento);
    }

    @GetMapping("/listaDeDocumentos")
    public Page<Documento> listaDeDocumentos(Pageable pageable) {
        return this.documentoService.listaDeDocumentos(pageable);
    }

    @GetMapping("/buscarDocumento/{idDocumento}")
    public Documento buscarDocumento(@PathVariable Long idDocumento) {
        return this.documentoService.buscarDocumento(idDocumento).get();
    }
}
