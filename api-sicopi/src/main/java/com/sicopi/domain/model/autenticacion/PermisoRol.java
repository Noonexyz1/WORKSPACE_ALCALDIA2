package com.sicopi.domain.model.autenticacion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PermisoRol {
    private Long id;
    private Permiso permiso;
    private Rol rol;
    private Boolean activo;
}
