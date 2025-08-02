package com.sicopi.application.port.in.dependencia;

import com.sicopi.domain.model.dependencia.Cuota;

public interface CuotaService {
    Cuota registrarCuota(Cuota cuota);
    Cuota editarCuota(Long idCuota, Cuota cuota);
    void deshabilitarCuota();
}

