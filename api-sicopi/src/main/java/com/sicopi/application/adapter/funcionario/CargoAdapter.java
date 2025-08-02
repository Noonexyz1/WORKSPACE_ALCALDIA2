package com.sicopi.application.adapter.funcionario;

import com.sicopi.application.port.in.funcionario.CargoService;
import com.sicopi.application.port.out.persistence.funcionario.CargoAbs;
import com.sicopi.domain.model.funcionario.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
        Cargo cargoEncontrado = this.cargoAbs.getCargoById(idCargo);
        if (cargoEncontrado == null) {
            throw new RuntimeException("El cargo con este Id no existe");
        }
        cargo.setId(cargoEncontrado.getId());
        return this.cargoAbs.registrarCargoAbs(cargo);
    }

    @Override
    public Page<Cargo> listaDeCargos(Pageable pageable) {
        return this.cargoAbs.listaDeCargosAbs(pageable);
    }

    @Override
    public void deshabilitarCargo() {

    }
}

