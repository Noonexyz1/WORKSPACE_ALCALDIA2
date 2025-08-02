package com.sicopi.infrastructure.persistence.db.entity.dependencia;

import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncDependenciaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "dependencia")
public class DependenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único de la unidad de trabajo
    private String nombre; // Ej: "Secretaría Municipal de Planificación", "Dirección de Obras Públicas", "Unidad de Catastro"
    private String sigla; // Ej: "SMP", "DOM", "UCAT" (abreviatura o sigla de la unidad)
    private String descripcion; // Breve descripción de las funciones principales de la unidad
    private Boolean activo; // Indica si la unidad está operativa actualmente

    @OneToMany(mappedBy = "dependencia")
    private List<FuncDependenciaEntity> funcDependenciaEntityList;
    @OneToMany(mappedBy = "dependencia")
    private List<CuotaEntity> cuotaEntityList;
}
