package com.sicopi.infrastructure.persistence.db.adapter.funcionario;

import com.sicopi.application.port.out.persistence.funcionario.CargoAbs;
import com.sicopi.domain.model.funcionario.Cargo;
import com.sicopi.infrastructure.persistence.db.entity.funcionario.CargoEntity;
import com.sicopi.infrastructure.persistence.db.map.funcionario.CargoMapper;
import com.sicopi.infrastructure.persistence.db.repository.funcionario.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class CargoAbsAdapter implements CargoAbs {

    @Autowired
    private CargoRepository cargoRepository;


    @Override
    public Cargo registrarCargoAbs(Cargo cargo) {
        if (cargo.getId() != null) {
            throw new RuntimeException("Para registar un nuevo cargo, el id debe ser nulo");
        }
        CargoEntity cargoEntity = this.cargoRepository
                .save(CargoMapper.INSTANCE.toCargoEntity(cargo));
        return CargoMapper.INSTANCE.toCargo(cargoEntity);
    }

    @Override
    public void deshabilitarCargoAbs() {
        this.cargoRepository.save(new CargoEntity());
    }

    @Override
    public void editarCargoAbs() {

    }

    @Override
    public Cargo getCargoById(Long idCargo) {
        return this.cargoRepository
                .findById(idCargo)
                .map(CargoMapper.INSTANCE::toCargo)
                .orElse(null);
    }

    @Override
    public Page<Cargo> listaDeCargosAbs(Pageable pageable) {
        return this.cargoRepository.findAll(pageable)
                .map(CargoMapper.INSTANCE::toCargo);
    }
}

