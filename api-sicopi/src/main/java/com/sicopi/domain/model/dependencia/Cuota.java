package com.sicopi.domain.model.dependencia;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cuota {
    private Long id;
    private Double montoMaximo;
    private Boolean activo;

    private Dependencia dependencia;
}
