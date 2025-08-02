package com.sicopi.application.adapter.fotocopia;

import com.sicopi.application.port.in.fotocopia.FotoFinalizadaService;
import com.sicopi.application.port.out.persistence.fotocopia.FotoFinalizadaAbs;
import com.sicopi.domain.model.fotocopia.FotoFinalizada;

public class FotoFinalizadaAdapter implements FotoFinalizadaService {

    private final FotoFinalizadaAbs fotoFinalizadaAbs;

    public FotoFinalizadaAdapter(FotoFinalizadaAbs fotoFinalizadaAbs) {
        this.fotoFinalizadaAbs = fotoFinalizadaAbs;
    }

    @Override
    public FotoFinalizada registrarFotoFinalizada(FotoFinalizada fotoFinalizada) {
        return this.fotoFinalizadaAbs.registrarFotoFinalizadaAbs(fotoFinalizada);
    }
}
