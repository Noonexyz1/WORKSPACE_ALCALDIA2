package com.sicopi.application.port.out.persistence.precioempresa;

import com.sicopi.domain.model.precioempresa.PrecioFotocopia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PrecioFotocopiaAbs {
    PrecioFotocopia registrarPrecioFotocopiaAbs(PrecioFotocopia precioFotocopia);
    Page<PrecioFotocopia> listaDePrecioFotocopia(Pageable pageable);
    Optional<PrecioFotocopia> buscarPrecioFotocopiaById(Long idPrecioFotocopia);
}
