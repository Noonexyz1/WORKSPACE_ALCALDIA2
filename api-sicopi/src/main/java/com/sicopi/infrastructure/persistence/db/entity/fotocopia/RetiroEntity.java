package com.sicopi.infrastructure.persistence.db.entity.fotocopia;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "retiro")
public class RetiroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double precioParcial;
    private Double precioSumaParcial;
    //private Double precioTotal;
    private Long numeroRetiro;
    private Long sumNumeroRetiro;
    //private Long totalCopias;
    private Long totalDisponible;


    @ManyToOne
    private DocumentoEntity documento;


    private LocalDateTime fechaCreacion;

    @PrePersist
    public void iniciarValores() {
        this.fechaCreacion = LocalDateTime.now();
    }
}
