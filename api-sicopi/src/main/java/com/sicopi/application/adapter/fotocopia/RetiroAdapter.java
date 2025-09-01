package com.sicopi.application.adapter.fotocopia;

import com.sicopi.application.port.in.fotocopia.RetiroService;
import com.sicopi.application.port.out.persistence.fotocopia.DocumentoAbs;
import com.sicopi.application.port.out.persistence.fotocopia.RetiroAbs;
import com.sicopi.domain.model.fotocopia.Documento;
import com.sicopi.domain.model.fotocopia.Retiro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class RetiroAdapter implements RetiroService {

    private final RetiroAbs retiroAbs;
    private final DocumentoAbs documentoAbs;

    public RetiroAdapter(
            RetiroAbs retiroAbs,
            DocumentoAbs documentoAbs
    ) {
        this.retiroAbs = retiroAbs;
        this.documentoAbs = documentoAbs;
    }

    @Override
    public Retiro registrarRetiro(Retiro retiro) {
        return this.retiroAbs.registrarRetiroAbs(retiro);
    }

    @Override
    public Retiro editarRetiro(Long idRetiro, Retiro retiro) {
        Optional<Retiro> retiroOpt = this.retiroAbs.buscarRetiroPorId(idRetiro);
        if (retiroOpt.isEmpty()) {
            throw new RuntimeException("No existe Retiro con este id");
        }
        retiro.setId(retiroOpt.get().getId());
        return this.retiroAbs.registrarRetiroAbs(retiro);
    }

    @Override
    public Page<Retiro> listaDeRetiros(Pageable pageable) {
        return this.retiroAbs.listaDeRetiros(pageable);
    }

    @Override
    public Optional<Retiro> buscarRetiro(Long idRetiro) {
        return this.retiroAbs.buscarRetiroPorId(idRetiro);
    }

    @Override
    public Optional<Retiro> buscarUltimoRetiroPorIdDocumento(Long idDocumento) {
        Optional<Retiro> retiroFinded = this.retiroAbs
                .buscarUltimoRetiroPorIdDocumento(idDocumento);

        Optional<Documento> documentoFinded = this.documentoAbs
                .buscarDocumentoPorId(idDocumento);

        if (documentoFinded.isEmpty())
            throw new RuntimeException("No existe este documento con este id");

        if (retiroFinded.isEmpty()) {
            Retiro retiro = Retiro.builder()
                    .precioParcial(0D)
                    .precioSumaParcial(0D)
                    //.precioTotal(documentoFinded.get().getPrecioDocu())
                    .sumNumeroRetiro(0L)
                    //.totalCopias(documentoFinded.get().getNroCopias())
                    .totalDisponible(documentoFinded.get().getNroCopias())
                    .documento(documentoFinded.get())
                    .build();

            return Optional.of(retiro);
        }

        if (documentoFinded.get().getRetirosConcluidos()) {
            throw new RuntimeException("Este documento ya termino la cantidad permitida de retiros");
        }

        return retiroFinded;
    }
}
