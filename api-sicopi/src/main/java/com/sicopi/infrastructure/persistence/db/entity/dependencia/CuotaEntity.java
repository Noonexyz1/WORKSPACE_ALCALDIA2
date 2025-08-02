package com.sicopi.infrastructure.persistence.db.entity.dependencia;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cuota")
public class CuotaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double montoMaximo;
    private Boolean activo;

    @ManyToOne
    private DependenciaEntity dependencia;
}
