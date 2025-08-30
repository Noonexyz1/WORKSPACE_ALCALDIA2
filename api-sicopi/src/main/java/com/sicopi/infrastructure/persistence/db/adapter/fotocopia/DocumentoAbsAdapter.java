package com.sicopi.infrastructure.persistence.db.adapter.fotocopia;

import com.sicopi.application.port.out.persistence.fotocopia.DocumentoAbs;
import com.sicopi.domain.model.fotocopia.Documento;
import com.sicopi.domain.model.fotocopia.Fotocopia;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.DocumentoEntity;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.FotocopiaEntity;
import com.sicopi.infrastructure.persistence.db.entity.empresa.PrecioFotocopiaEntity;
import com.sicopi.infrastructure.persistence.db.map.fotocopia.DocumentoMapper;
import com.sicopi.infrastructure.persistence.db.map.fotocopia.FotocopiaMapper;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.DocumentoRepository;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.FotocopiaRepository;
import com.sicopi.infrastructure.persistence.db.repository.empresa.PrecioFotocopiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DocumentoAbsAdapter implements DocumentoAbs {

    @Autowired
    private DocumentoRepository documentoRepository;
    @Autowired
    private FotocopiaRepository fotocopiaRepository;
    @Autowired
    private PrecioFotocopiaRepository precioFotocopiaRepository;

    @Override
    public Documento registrarDocumentoAbs(Documento documento) {
        FotocopiaEntity fotocopiaEntity = this.fotocopiaRepository
                .findById(documento.getFotocopia().getId()).orElse(null);

        PrecioFotocopiaEntity precioFotocopiaEntity = this.precioFotocopiaRepository
                .findById(documento.getPrecioFotocopia().getId()).orElse(null);

        DocumentoEntity documentoEntity = DocumentoMapper.INSTANCE.toDocumentoEntity(documento);
        documentoEntity.setFotocopia(fotocopiaEntity);
        documentoEntity.setPrecioFotocopia(precioFotocopiaEntity);
        this.documentoRepository.save(documentoEntity);
        return DocumentoMapper.INSTANCE.toDocumento(documentoEntity);
    }

    @Override
    public Optional<Documento> buscarDocumentoPorId(Long idDocumento) {
        Optional<DocumentoEntity> byId = this.documentoRepository.findById(idDocumento);
        return byId.map(DocumentoMapper.INSTANCE::toDocumento);
    }

    @Override
    public Page<Documento> listaDeDocumentos(Pageable pageable) {
        Page<DocumentoEntity> all = this.documentoRepository.findAll(pageable);
        return all.map(DocumentoMapper.INSTANCE::toDocumento);
    }

    @Override
    public List<Documento> listaDeDocumentosByFotocopia(Fotocopia fotocopiaSaved) {
        FotocopiaEntity fotocopiaEntity = FotocopiaMapper.INSTANCE.toFotocopiaEntity(fotocopiaSaved);
        List<DocumentoEntity> allByIdFotocopia = this.documentoRepository.findAllByFotocopia(fotocopiaEntity);
        return allByIdFotocopia.stream().map(DocumentoMapper.INSTANCE::toDocumento).toList();
    }
}
