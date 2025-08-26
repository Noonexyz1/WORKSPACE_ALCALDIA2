package com.sicopi.application.adapter.fotocopia;

import com.sicopi.application.port.in.fotocopia.DocumentoService;
import com.sicopi.application.port.out.persistence.fotocopia.DocumentoAbs;
import com.sicopi.domain.model.fotocopia.Documento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class DocumentoAdapter implements DocumentoService {

    private final DocumentoAbs documentoAbs;

    public DocumentoAdapter(DocumentoAbs documentoAbs) {
        this.documentoAbs = documentoAbs;
    }

    @Override
    public Documento registrarDocumento(Documento documento) {
        return this.documentoAbs.registrarDocumentoAbs(documento);
    }

    @Override
    public Documento editarDocumento(Long idDocumento, Documento documento) {
        Optional<Documento> docuOption = this.documentoAbs
                .buscarDocumentoPorId(idDocumento);
        if (docuOption.isEmpty()) {
            throw new RuntimeException("No existe este documento por id");
        }
        documento.setId(docuOption.get().getId());
        return this.documentoAbs.registrarDocumentoAbs(documento);
    }

    @Override
    public Page<Documento> listaDeDocumentos(Pageable pageable) {
        return this.documentoAbs.listaDeDocumentos(pageable);
    }

    @Override
    public Optional<Documento> buscarDocumento(Long idDocumento) {
        return this.documentoAbs.buscarDocumentoPorId(idDocumento);
    }
}
