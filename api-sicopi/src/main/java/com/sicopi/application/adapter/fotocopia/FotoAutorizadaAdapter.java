package com.sicopi.application.adapter.fotocopia;

import com.sicopi.application.port.in.fotocopia.FotoAutorizadaService;
import com.sicopi.application.port.out.persistence.fotocopia.FotoAutorizadaAbs;
import com.sicopi.domain.model.fotocopia.FotoAutorizada;

public class FotoAutorizadaAdapter implements FotoAutorizadaService {

    private final FotoAutorizadaAbs fotoAutorizadaAbs;

    public FotoAutorizadaAdapter(FotoAutorizadaAbs fotoAutorizadaAbs) {
        this.fotoAutorizadaAbs = fotoAutorizadaAbs;
    }

    @Override
    public FotoAutorizada registrarFotoAutorizada(FotoAutorizada fotoAutorizada) {
        return this.fotoAutorizadaAbs.registrarFotoAutorizadaAbs(fotoAutorizada);
    }
}
