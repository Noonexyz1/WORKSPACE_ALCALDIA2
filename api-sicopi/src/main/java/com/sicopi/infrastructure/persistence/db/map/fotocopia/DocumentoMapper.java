package com.sicopi.infrastructure.persistence.db.map.fotocopia;

import com.sicopi.domain.model.fotocopia.Documento;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.DocumentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocumentoMapper {

    DocumentoMapper INSTANCE = Mappers.getMapper(DocumentoMapper.class);

    DocumentoEntity toDocumentoEntity(Documento documento);
    Documento toDocumento(DocumentoEntity documentoEntity);
}
