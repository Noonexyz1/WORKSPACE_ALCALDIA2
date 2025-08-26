package com.sicopi.application.port.out.persistence.precioempresa;

import com.sicopi.domain.model.precioempresa.PrecioEmpresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PrecioEmpresaAbs {
    PrecioEmpresa registrarPrecioEmpresa(PrecioEmpresa precioEmpresa);
    Page<PrecioEmpresa> listaDePrecioEmpresa(Pageable pageable);
    Optional<PrecioEmpresa> buscarPrecioEmpresaPorId(Long idPrecioEmpresa);
}
