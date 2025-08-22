package com.sicopi.application.port.out.persistence.dependencia;

import com.sicopi.domain.model.dependencia.Cuota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CuotaAbs {
    Cuota registrarCuotaAbs(Cuota cuota);
    Cuota editarCuotaAbs(Cuota cuota);
    void deshabilitarCuotaAbs();
    Optional<Cuota> findCuotaPorId(Long idCuota);
    Page<Cuota> listaDeCuotas(Pageable pageable);
}

