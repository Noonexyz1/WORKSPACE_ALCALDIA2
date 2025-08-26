package com.sicopi.application.port.out.persistence.fotocopia;

import com.sicopi.domain.model.fotocopia.Documento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DocumentoAbs {
    Documento registrarDocumentoAbs(Documento documento);
    Optional<Documento> buscarDocumentoPorId(Long idDocumento);
    Page<Documento> listaDeDocumentos(Pageable pageable);
}
