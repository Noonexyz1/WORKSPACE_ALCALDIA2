package com.sicopi.domain.model.precioempresa;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PrecioEmpresa {
    private Long id;
    private Boolean activo;

    private Empresa empresa;
    private PrecioFotocopia precioFotocopia;
}
