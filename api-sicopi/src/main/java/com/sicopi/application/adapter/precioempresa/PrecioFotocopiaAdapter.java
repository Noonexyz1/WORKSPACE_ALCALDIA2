package com.sicopi.application.adapter.precioempresa;

import com.sicopi.application.port.in.empresa.PrecioFotocopiaService;
import com.sicopi.application.port.out.persistence.empresa.PrecioFotocopiaAbs;
import com.sicopi.domain.model.empresa.PrecioFotocopia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class PrecioFotocopiaAdapter implements PrecioFotocopiaService {

    private final PrecioFotocopiaAbs precioFotocopiaAbs;

    public PrecioFotocopiaAdapter(PrecioFotocopiaAbs precioFotocopiaAbs) {
        this.precioFotocopiaAbs = precioFotocopiaAbs;
    }

    @Override
    public PrecioFotocopia registrarPrecioFotocopia(PrecioFotocopia precioFotocopia) {
        return this.precioFotocopiaAbs.registrarPrecioFotocopiaAbs(precioFotocopia);
    }

    @Override
    public PrecioFotocopia editarPrecioFotocopia(Long idPrecioFotocopia, PrecioFotocopia precioFotocopia) {
        Optional<PrecioFotocopia> precFotoOpt = this.precioFotocopiaAbs
                .buscarPrecioFotocopiaById(idPrecioFotocopia);
        if (precFotoOpt.isEmpty()) {
            throw new RuntimeException("No existe este Precio Fotocopia con este id");
        }
        precioFotocopia.setId(precFotoOpt.get().getId());
        return this.precioFotocopiaAbs.registrarPrecioFotocopiaAbs(precioFotocopia);
    }

    @Override
    public Page<PrecioFotocopia> listaDePrecioFotocopia(Pageable pageable) {
        return this.precioFotocopiaAbs.listaDePrecioFotocopia(pageable);
    }
}
