package com.sicopi.application.port.in.dependencia;

import com.sicopi.domain.model.dependencia.Cuota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CuotaService {
    Cuota registrarCuota(Cuota cuota);
    Cuota editarCuota(Long idCuota, Cuota cuota);
    void deshabilitarCuota(Long idCuota);
    Page<Cuota> listaDeCuotas(Pageable pageable);
}

