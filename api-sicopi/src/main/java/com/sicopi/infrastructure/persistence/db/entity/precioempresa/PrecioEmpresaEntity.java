package com.sicopi.infrastructure.persistence.db.entity.precioempresa;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "precio_empresa")
public class PrecioEmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean activo;


    @ManyToOne
    private EmpresaEntity empresa;
    @ManyToOne
    private PrecioFotocopiaEntity precioFotocopia;


    private LocalDateTime fechaCreacion;

    @PrePersist
    public void iniciarValores() {
        this.activo = true;
        this.fechaCreacion = LocalDateTime.now();
    }
}
