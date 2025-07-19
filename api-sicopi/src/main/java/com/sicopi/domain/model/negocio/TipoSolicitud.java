package com.sicopi.domain.model.negocio;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoSolicitud {
    private Long id;
    private String nombre;
    private String descripcion;
}
