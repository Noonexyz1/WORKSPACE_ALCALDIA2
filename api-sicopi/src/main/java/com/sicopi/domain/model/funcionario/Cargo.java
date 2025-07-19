package com.sicopi.domain.model.funcionario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cargo {
    private Long id; // Identificador único del cargo
    private String nombre; // Ej: "Jefe de Departamento", "Técnico de Catastro I", "Asistente Administrativo"
    private String descripcion; // Breve descripción de las responsabilidades principales del cargo
}
