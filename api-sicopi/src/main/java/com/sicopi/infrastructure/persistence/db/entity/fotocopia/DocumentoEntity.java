package com.sicopi.infrastructure.persistence.db.entity.fotocopia;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "documento")
public class DocumentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double precioDocu;
    private Long nroCopias;
    private Long nroPaginas;
    private String nombreDocumento;

    @ManyToOne
    private FotocopiaEntity fotocopia;
    @ManyToOne
    private PrecioFotocopiaEntity precioFotocopia;

    @OneToMany(mappedBy = "documento")
    private List<RetiroEntity> retiroEntityList;
}
