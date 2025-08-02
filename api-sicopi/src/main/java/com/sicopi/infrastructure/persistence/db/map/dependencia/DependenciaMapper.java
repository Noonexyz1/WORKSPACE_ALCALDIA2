package com.sicopi.infrastructure.persistence.db.map.dependencia;

import com.sicopi.domain.model.dependencia.Dependencia;
import com.sicopi.infrastructure.persistence.db.entity.dependencia.DependenciaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Mapper
public interface DependenciaMapper {

    DependenciaMapper INSTANCE = Mappers.getMapper(DependenciaMapper.class);

    DependenciaEntity toDependenciaEntity(Dependencia dependencia);
    Dependencia toDependencia(DependenciaEntity dependenciaEntity);
}
