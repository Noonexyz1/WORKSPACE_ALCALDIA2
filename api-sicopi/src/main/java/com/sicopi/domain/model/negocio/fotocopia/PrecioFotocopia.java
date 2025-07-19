package com.sicopi.domain.model.negocio.fotocopia;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrecioFotocopia {
    private Long id;
    private Boolean activo;
    private Double precioRef;
    private String anverRever;
    private String color;
    private String tamano;
}
