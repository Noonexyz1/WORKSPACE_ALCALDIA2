package com.sicopi.application.port.in.funcionario;

import com.sicopi.domain.model.funcionario.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CargoService {
    Cargo registrarCargo(Cargo cargo);
    Cargo editarCargo(Long idCargo, Cargo cargo);
    Page<Cargo> listaDeCargos(Pageable pageable);
    void deshabilitarCargo();
}

