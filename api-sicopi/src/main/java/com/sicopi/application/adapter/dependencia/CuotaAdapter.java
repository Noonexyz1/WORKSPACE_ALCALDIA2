package com.sicopi.application.adapter.dependencia;

import com.sicopi.application.port.in.dependencia.CuotaService;
import com.sicopi.application.port.out.persistence.dependencia.CuotaAbs;
import com.sicopi.domain.model.dependencia.Cuota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

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
        Optional<Cuota> cuotaEncontrado = this.cuotaAbs.findCuotaPorId(idCuota);
        if (cuotaEncontrado.isEmpty()) {
            throw new RuntimeException("No existe esta Cuota con este id");
        }
        cuota.setId(cuotaEncontrado.get().getId());
        cuota = this.cuotaAbs.editarCuotaAbs(cuota);
        return cuota;
    }

    @Override
    public void deshabilitarCuota(Long idCuota) {
        Optional<Cuota> cuotaEncontrado = this.cuotaAbs.findCuotaPorId(idCuota);
        if (cuotaEncontrado.isEmpty()) {
            throw new RuntimeException("No existe esta Cuota con este id");
        }
        cuotaEncontrado.get().setActivo(false);
        this.cuotaAbs.registrarCuotaAbs(cuotaEncontrado.get());
    }

    @Override
    public Page<Cuota> listaDeCuotas(Pageable pageable) {
        return this.cuotaAbs.listaDeCuotas(pageable);
    }
}

