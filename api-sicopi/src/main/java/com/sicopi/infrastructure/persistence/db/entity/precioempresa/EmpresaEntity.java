package com.sicopi.infrastructure.persistence.db.entity.precioempresa;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "empresa")
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String nit;
    private String direccion;
    private String email;
    private Long telefono;

    private Boolean activo;


    @OneToMany(mappedBy = "empresa")
    private List<PrecioEmpresaEntity> precioEmpresaEntityList;


    private LocalDateTime fechaCreacion;

    @PrePersist
    public void iniciarValores() {
        this.activo = true;
        this.fechaCreacion = LocalDateTime.now();
    }
}
