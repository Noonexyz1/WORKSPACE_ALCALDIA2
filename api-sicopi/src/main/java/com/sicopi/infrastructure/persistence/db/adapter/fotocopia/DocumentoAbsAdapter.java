package com.sicopi.infrastructure.persistence.db.adapter.fotocopia;

import com.sicopi.application.port.out.persistence.fotocopia.DocumentoAbs;
import com.sicopi.domain.model.fotocopia.Documento;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.DocumentoEntity;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.FotocopiaEntity;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.PrecioFotocopiaEntity;
import com.sicopi.infrastructure.persistence.db.map.fotocopia.DocumentoMapper;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.DocumentoRepository;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.FotocopiaRepository;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.PrecioFotocopiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
