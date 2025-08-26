package com.sicopi.application.port.in.fotocopia;

import com.sicopi.domain.model.fotocopia.Documento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DocumentoService {
    Documento registrarDocumento(Documento documento);
    Documento editarDocumento(Long idDocumento, Documento documento);
    Page<Documento> listaDeDocumentos(Pageable pageable);
    Optional<Documento> buscarDocumento(Long idDocumento);
}
