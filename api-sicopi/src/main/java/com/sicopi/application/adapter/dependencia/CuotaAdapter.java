package com.sicopi.application.adapter.dependencia;

import com.sicopi.application.port.in.dependencia.CuotaService;
import com.sicopi.application.port.out.persistence.dependencia.CuotaAbs;
import com.sicopi.domain.model.dependencia.Cuota;

public class CuotaAdapter implements CuotaService {

    private final CuotaAbs cuotaAbs;

    public CuotaAdapter(CuotaAbs cuotaAbs) {
        this.cuotaAbs = cuotaAbs;
    }


    @Override
    public Cuota registrarCuota(Cuota cuota) {
        return this.cuotaAbs.registrarCuotaAbs(cuota);
    }

    @Override
    public Cuota editarCuota(Long idCuota, Cuota cuota) {
        Cuota cuotaEncontrado = this.cuotaAbs.findCuotaPorId(idCuota);
        if (cuotaEncontrado == null) {
            throw new RuntimeException("No existe esta Cuota con este id");
        }
        return cuotaEncontrado;
    }

    @Override
    public void deshabilitarCuota() {

    }
}

