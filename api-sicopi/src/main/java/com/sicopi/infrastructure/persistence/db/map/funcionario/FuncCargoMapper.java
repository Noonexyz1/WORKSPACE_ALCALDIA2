package com.sicopi.infrastructure.persistence.db.map.funcionario;

import com.sicopi.domain.model.funcionario.FuncCargo;
import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncCargoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FuncCargoMapper {
    FuncCargoMapper INSTANCE = Mappers.getMapper(FuncCargoMapper.class);

    FuncCargoEntity toFuncCargoEntity(FuncCargo funcCargo);
    FuncCargo toFuncCargo(FuncCargoEntity funcCargoEntity);
}
