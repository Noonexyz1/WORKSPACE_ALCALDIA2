package com.sicopi.infrastructure.persistence.db.map.funcionario;

import com.sicopi.domain.model.funcionario.FuncDependencia;
import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncDependenciaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FuncDependenciaMapper {
    FuncDependenciaMapper INSTANCE = Mappers.getMapper(FuncDependenciaMapper.class);

    FuncDependenciaEntity toFuncDependenciaEntity(FuncDependencia funcDependencia);
    FuncDependencia toFuncDependencia(FuncDependenciaEntity funcDependenciaEntity);
}
