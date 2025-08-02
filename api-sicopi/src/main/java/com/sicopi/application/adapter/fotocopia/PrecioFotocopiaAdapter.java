package com.sicopi.application.adapter.fotocopia;

import com.sicopi.application.port.in.fotocopia.PrecioFotocopiaService;
import com.sicopi.application.port.out.persistence.fotocopia.PrecioFotocopiaAbs;
import com.sicopi.domain.model.fotocopia.PrecioFotocopia;

public class PrecioFotocopiaAdapter implements PrecioFotocopiaService {

    private final PrecioFotocopiaAbs precioFotocopiaAbs;

    public PrecioFotocopiaAdapter(PrecioFotocopiaAbs precioFotocopiaAbs) {
        this.precioFotocopiaAbs = precioFotocopiaAbs;
    }

    @Override
    public PrecioFotocopia registrarPrecioFotocopia(PrecioFotocopia precioFotocopia) {
        return this.precioFotocopiaAbs.registrarPrecioFotocopiaAbs(precioFotocopia);
    }
}
