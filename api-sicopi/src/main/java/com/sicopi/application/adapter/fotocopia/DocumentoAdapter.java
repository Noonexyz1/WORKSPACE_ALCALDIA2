package com.sicopi.application.adapter.fotocopia;

import com.sicopi.application.port.in.fotocopia.DocumentoService;
import com.sicopi.application.port.out.persistence.fotocopia.DocumentoAbs;
import com.sicopi.domain.model.fotocopia.Documento;

public class DocumentoAdapter implements DocumentoService {

    private final DocumentoAbs documentoAbs;

    public DocumentoAdapter(DocumentoAbs documentoAbs) {
        this.documentoAbs = documentoAbs;
    }

    @Override
    public Documento registrarDocumento(Documento documento) {
        return this.documentoAbs.registrarDocumentoAbs(documento);
    }
}
