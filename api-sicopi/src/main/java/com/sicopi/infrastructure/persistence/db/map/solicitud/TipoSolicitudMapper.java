package com.sicopi.infrastructure.persistence.db.map.solicitud;

import com.sicopi.domain.model.solicitud.TipoSolicitud;
import com.sicopi.infrastructure.persistence.db.entity.solicitud.TipoSolicitudEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TipoSolicitudMapper {

    TipoSolicitudMapper INSTANCE = Mappers.getMapper(TipoSolicitudMapper.class);

    TipoSolicitudEntity toTipoSolicitudEntity(TipoSolicitud tipoSolicitud);
    TipoSolicitud toTipoSolicitud(TipoSolicitudEntity tipoSolicitudEntity);
}
