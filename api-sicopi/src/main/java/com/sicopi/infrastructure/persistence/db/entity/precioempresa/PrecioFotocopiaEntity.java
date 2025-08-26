package com.sicopi.infrastructure.persistence.db.entity.precioempresa;

import com.sicopi.infrastructure.persistence.db.entity.fotocopia.DocumentoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "precio_fotocopia")
public class PrecioFotocopiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;
    private Double precioRef;
    private String anverRever;
    private String color;
    private String tamano;

    @OneToMany(mappedBy = "precioFotocopia")
    private List<DocumentoEntity> documentoEntityList;
    @OneToMany(mappedBy = "precioFotocopia")
    private List<PrecioEmpresaEntity> precioEmpresaEntityList;


    private LocalDateTime fechaCreacion;

    @PrePersist
    public void iniciarValores() {
        this.activo = true;
        this.fechaCreacion = LocalDateTime.now();
    }
}
