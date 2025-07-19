package com.sicopi.domain.model.autenticacion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Permiso {
    private Long id;
    private String nombre;
    private String descripcion;
}
