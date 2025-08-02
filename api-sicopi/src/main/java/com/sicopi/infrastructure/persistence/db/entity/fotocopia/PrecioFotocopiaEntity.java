package com.sicopi.infrastructure.persistence.db.entity.fotocopia;

import jakarta.persistence.*;
import lombok.*;

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
}
