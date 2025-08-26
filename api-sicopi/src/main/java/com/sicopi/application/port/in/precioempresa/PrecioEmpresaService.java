package com.sicopi.application.port.in.precioempresa;

import com.sicopi.domain.model.precioempresa.PrecioEmpresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrecioEmpresaService {
    PrecioEmpresa registrarPrecioEmpresa(PrecioEmpresa precioEmpresa);
    Page<PrecioEmpresa> listaDePrecioEmpresa(Pageable pageable);
    void habilitarPrecioEmpresa(Long idPrecioEmpresa);
    void deshabilitarPrecioEmpresa(Long idPrecioEmpresa);
}
