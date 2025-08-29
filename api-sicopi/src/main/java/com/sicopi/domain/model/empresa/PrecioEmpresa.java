package com.sicopi.domain.model.empresa;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrecioEmpresa {
    private Long id;
    private Boolean activo;

    private Empresa empresa;
    private PrecioFotocopia precioFotocopia;
}
