package com.sicopi.infrastructure.persistence.db.adapter.funcionario;

import com.sicopi.application.port.out.persistence.funcionario.FuncCargoAbs;
import com.sicopi.domain.model.funcionario.FuncCargo;
import com.sicopi.infrastructure.persistence.db.entity.funcionario.CargoEntity;
import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncCargoEntity;
import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncionarioEntity;
import com.sicopi.infrastructure.persistence.db.map.funcionario.FuncCargoMapper;
import com.sicopi.infrastructure.persistence.db.repository.funcionario.CargoRepository;
import com.sicopi.infrastructure.persistence.db.repository.funcionario.FuncCargoRepository;
import com.sicopi.infrastructure.persistence.db.repository.funcionario.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class FuncCargoAbsAdapter implements FuncCargoAbs {

    @Autowired
    private FuncCargoRepository funcCargoRepository;
    @Autowired
    private CargoRepository cargoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;


    @Override
    @Transactional
    public FuncCargo registrarFuncionarioCargoAbs(FuncCargo funcCargo) {
        /*if (funcCargo.getId() != null) {
            throw new RuntimeException("el id debe ser null para registrar un nuevo funcionario");
        }

        if (funcCargo.getFuncionario() == null &&
                funcCargo.getCargo() == null) {
            throw new RuntimeException("El cargo y el funcionario no deben ser nulos");
        }

        CargoEntity cargoEntity = this.cargoRepository
                .findById(funcCargo.getCargo().getId())
                .orElse(null);

        FuncionarioEntity funcionarioEntity = this.funcionarioRepository
                .findById(funcCargo.getFuncionario().getId())
                .orElse(null);

        if (cargoEntity == null && funcionarioEntity == null) {
            throw new RuntimeException("El cargo y el funcionario debe existir");
        }*/

        FuncCargoEntity funcCargoEntity = FuncCargoMapper.INSTANCE.toFuncCargoEntity(funcCargo);
        this.funcCargoRepository.save(funcCargoEntity);
        return FuncCargoMapper.INSTANCE.toFuncCargo(funcCargoEntity);
    }

    @Override
    public void deshabilitarFuncionarioCargoAbs() {

    }

    @Override
    public Optional<FuncCargo> encontrarFunCargoPorId(Long idFuncCargo) {
        Optional<FuncCargoEntity> funcCargoEntity = this.funcCargoRepository
                .findById(idFuncCargo);
        return funcCargoEntity.map(FuncCargoMapper.INSTANCE::toFuncCargo);
    }

    @Override
    public Page<FuncCargo> listaDeFuncCargo(Pageable pageable) {
        Page<FuncCargoEntity> funcCargoEntities = this.funcCargoRepository
                .findAll(pageable);
        return funcCargoEntities.map(FuncCargoMapper.INSTANCE::toFuncCargo);
    }
}
