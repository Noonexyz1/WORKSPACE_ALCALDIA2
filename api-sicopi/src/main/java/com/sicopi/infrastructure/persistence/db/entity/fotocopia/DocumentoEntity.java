package com.sicopi.infrastructure.persistence.db.entity.fotocopia;

import com.sicopi.infrastructure.persistence.db.entity.empresa.PrecioFotocopiaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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

    private Boolean retirosConcluidos;

    @ManyToOne
    private FotocopiaEntity fotocopia;
    @ManyToOne
    private PrecioFotocopiaEntity precioFotocopia;

    @OneToMany(mappedBy = "documento")
    private List<RetiroEntity> retiroEntityList;


    private LocalDateTime fechaCreacion;

    @PrePersist
    public void iniciarValores() {
        this.retirosConcluidos = false;
        this.fechaCreacion = LocalDateTime.now();
    }
}
