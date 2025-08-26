package com.sicopi.infrastructure.persistence.db.entity.fotocopia;

import com.sicopi.infrastructure.persistence.db.entity.solicitud.SolicitudEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "fotocopia")
public class FotocopiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Aqui debe ir toda la informacion total de la solicitud-de-fotocopia
    private Double precioTotal;
    private Long copiaTotal;
    private Long paginaTotal;

    private Boolean pendiente;
    private Boolean autorizado;
    private Boolean finalizado;

    @ManyToOne
    private SolicitudEntity solicitud;

    @OneToMany(mappedBy = "fotocopia")
    private List<DocumentoEntity> documentoEntityList;


    private LocalDateTime fechaCreacion;

    @PrePersist
    public void iniciarValores() {
        this.pendiente = true;
        this.autorizado = false;
        this.finalizado = false;
        this.fechaCreacion = LocalDateTime.now();
    }
}
