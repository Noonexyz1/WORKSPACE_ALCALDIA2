package com.sicopi.application.port.out.persistence.funcionario;

import com.sicopi.domain.model.funcionario.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CargoAbs {
    Cargo registrarCargoAbs(Cargo cargo);
    Page<Cargo> listaDeCargosAbs(Pageable pageable);
    void deshabilitarCargoAbs();
    void editarCargoAbs();
    Optional<Cargo> getCargoById(Long idCargo);
}

