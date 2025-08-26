package com.sicopi.application.port.in.precioempresa;

import com.sicopi.domain.model.precioempresa.PrecioFotocopia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrecioFotocopiaService {
    PrecioFotocopia registrarPrecioFotocopia(PrecioFotocopia precioFotocopia);
    PrecioFotocopia editarPrecioFotocopia(Long idPrecioFotocopia, PrecioFotocopia precioFotocopia);
    Page<PrecioFotocopia> listaDePrecioFotocopia(Pageable pageable);
}
