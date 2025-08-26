package com.sicopi.domain.model.precioempresa;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Empresa {
    private Long id;
    private String nombre;
    private String descripcion;
    private String nit;
    private String direccion;
    private String email;
    private Long telefono;
    private Boolean activo;
    private LocalDateTime fechaRegistro;
}
