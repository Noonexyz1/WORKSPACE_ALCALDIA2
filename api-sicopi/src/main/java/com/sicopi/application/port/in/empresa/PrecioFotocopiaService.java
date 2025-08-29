package com.sicopi.application.port.in.empresa;

import com.sicopi.domain.model.empresa.PrecioFotocopia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrecioFotocopiaService {
    PrecioFotocopia registrarPrecioFotocopia(PrecioFotocopia precioFotocopia);
    PrecioFotocopia editarPrecioFotocopia(Long idPrecioFotocopia, PrecioFotocopia precioFotocopia);
    Page<PrecioFotocopia> listaDePrecioFotocopia(Pageable pageable);
}
