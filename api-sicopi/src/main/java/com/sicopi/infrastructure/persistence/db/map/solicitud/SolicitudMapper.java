package com.sicopi.infrastructure.persistence.db.map.solicitud;

import com.sicopi.domain.model.solicitud.Solicitud;
import com.sicopi.infrastructure.persistence.db.entity.solicitud.SolicitudEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SolicitudMapper {

    SolicitudMapper INSTANCE = Mappers.getMapper(SolicitudMapper.class);

    SolicitudEntity toSolicitudEntity(Solicitud solicitud);
    Solicitud toSolicitud(SolicitudEntity solicitudEntity);
}
