package com.sicopi.infrastructure.persistence.db.map.funcionario;

import com.sicopi.domain.model.funcionario.Cargo;
import com.sicopi.infrastructure.persistence.db.entity.funcionario.CargoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Mapper
public interface CargoMapper {
    CargoMapper INSTANCE = Mappers.getMapper(CargoMapper.class);

    CargoEntity toCargoEntity(Cargo cargo);
    Cargo toCargo(CargoEntity cargoEntity);
}

