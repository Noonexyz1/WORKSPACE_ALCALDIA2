package com.sicopi.application.port.out.persistence.dependencia;

import com.sicopi.domain.model.dependencia.Cuota;

public interface CuotaAbs {
    Cuota registrarCuotaAbs(Cuota cuota);
    Cuota editarCuotaAbs(Cuota cuota);
    void deshabilitarCuotaAbs();
    Cuota findCuotaPorId(Long idCuota);
}

