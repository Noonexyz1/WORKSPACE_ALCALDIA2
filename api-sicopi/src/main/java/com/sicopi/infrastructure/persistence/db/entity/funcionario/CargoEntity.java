package com.sicopi.infrastructure.persistence.db.entity.funcionario;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cargo")
public class CargoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del cargo
    private String nombre; // Ej: "Jefe de Departamento", "Técnico de Catastro I", "Asistente Administrativo"
    private String descripcion; // Breve descripción de las responsabilidades principales del cargo

    @OneToMany(mappedBy = "cargo")
    private List<FuncCargoEntity> funcCargoEntityList;
}
