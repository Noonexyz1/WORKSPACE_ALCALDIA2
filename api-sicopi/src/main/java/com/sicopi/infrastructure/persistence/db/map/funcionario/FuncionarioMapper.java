package com.sicopi.infrastructure.persistence.db.map.funcionario;

import com.sicopi.domain.model.funcionario.Funcionario;
import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncionarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FuncionarioMapper {
    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    FuncionarioEntity toFuncionarioEntity(Funcionario funcionario);
    Funcionario toFuncionario(FuncionarioEntity funcionarioEntity);
}
