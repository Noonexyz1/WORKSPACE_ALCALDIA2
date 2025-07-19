package com.sicopi.domain.model.autenticacion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rol {
    private Long id; // ID único del rol
    private String nombre; // Ej: "ROLE_ADMIN", "ROLE_USER", "ROLE_MANAGER"
    private String descripcion; // Opcional: una descripción más detallada del rol
}
