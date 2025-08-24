package com.sicopi.application.adapter.funcionario;

import com.sicopi.application.port.in.funcionario.CargoService;
import com.sicopi.application.port.out.persistence.funcionario.CargoAbs;
import com.sicopi.domain.model.funcionario.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class CargoAdapter implements CargoService {

    private final CargoAbs cargoAbs;

    public CargoAdapter(CargoAbs cargoAbs) {
        this.cargoAbs = cargoAbs;
    }


    @Override
    public Cargo registrarCargo(Cargo cargo) {
        return this.cargoAbs.registrarCargoAbs(cargo);
    }

    @Override
    public Cargo editarCargo(Long idCargo, Cargo cargo) {
        Optional<Cargo> cargoEncontrado = this.cargoAbs.getCargoById(idCargo);
        if (cargoEncontrado.isEmpty()) {
            throw new RuntimeException("El cargo con este Id no existe");
        }
        cargo.setId(cargoEncontrado.get().getId());
        return this.cargoAbs.registrarCargoAbs(cargo);
    }

    @Override
    public Page<Cargo> listaDeCargos(Pageable pageable) {
        return this.cargoAbs.listaDeCargosAbs(pageable);
    }
}

