package com.sicopi.application.adapter.fotocopia;

import com.sicopi.application.port.in.fotocopia.FotocopiaService;
import com.sicopi.application.port.out.persistence.fotocopia.FotocopiaAbs;
import com.sicopi.domain.model.fotocopia.Fotocopia;

public class FotocopiaAdapter implements FotocopiaService {

    private final FotocopiaAbs fotocopiaAbs;

    public FotocopiaAdapter(FotocopiaAbs fotocopiaAbs) {
        this.fotocopiaAbs = fotocopiaAbs;
    }

    @Override
    public Fotocopia registrarFotocopia(Fotocopia fotocopia) {
        return this.fotocopiaAbs.registrarFotocopiaAbs(fotocopia);
    }
}
