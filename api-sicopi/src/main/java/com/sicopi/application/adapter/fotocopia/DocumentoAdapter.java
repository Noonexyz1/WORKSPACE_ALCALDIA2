package com.sicopi.application.adapter.fotocopia;

import com.sicopi.application.port.in.fotocopia.DocumentoService;
import com.sicopi.application.port.out.persistence.fotocopia.DocumentoAbs;
import com.sicopi.application.port.out.persistence.fotocopia.FotocopiaAbs;
import com.sicopi.domain.model.fotocopia.Documento;
import com.sicopi.domain.model.fotocopia.Fotocopia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class DocumentoAdapter implements DocumentoService {

    private final DocumentoAbs documentoAbs;
    private final FotocopiaAbs fotocopiaAbs;

    public DocumentoAdapter(
            DocumentoAbs documentoAbs,
            FotocopiaAbs fotocopiaAbs) {

        this.documentoAbs = documentoAbs;
        this.fotocopiaAbs = fotocopiaAbs;
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


    //Implementar un patron observador para que este metodo se pueda disparar cuando un
    //evento se dispare, paso el id que es Long y pues no es un objeto
    @Override
    public void cambiarEstadoDeFotocopiaAFinalizado(Fotocopia fotocopia) {
        List<Documento> documentoList = this.documentoAbs
                .listaDeDocumentosByFotocopia(fotocopia);
        int size = documentoList.size();

        int sizeTrues = documentoList.stream()
                .filter(documento -> documento.getRetirosConcluidos() == true)
                .toList()
                .size();

        if (size == sizeTrues) {
            fotocopia.setFinalizado(true);
            this.fotocopiaAbs.registrarFotocopiaAbs(fotocopia);
        }
    }
}
