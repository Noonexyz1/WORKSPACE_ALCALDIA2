package com.sicopi.domain.model.funcionario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dependencia {
    private Long id; // Identificador único de la unidad de trabajo
    private String nombre; // Ej: "Secretaría Municipal de Planificación", "Dirección de Obras Públicas", "Unidad de Catastro"
    private String sigla; // Ej: "SMP", "DOM", "UCAT" (abreviatura o sigla de la unidad)
    private Double presupuesto; // Monto Monetario asignado de gasto
    private String descripcion; // Breve descripción de las funciones principales de la unidad
    private Boolean activo; // Indica si la unidad está operativa actualmente
}
