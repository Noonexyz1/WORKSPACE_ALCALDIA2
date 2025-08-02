package com.sicopi.infrastructure.persistence.db.entity.fotocopia;

import com.sicopi.infrastructure.persistence.db.entity.solicitud.SolicitudEntity;
import jakarta.persistence.*;
import lombok.*;

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

    private Boolean activo;

    @ManyToOne
    private SolicitudEntity solicitud;

    @OneToMany(mappedBy = "fotocopia")
    private List<FotoAutorizadaEntity> fotoAutorizadaEntityList;
    @OneToMany(mappedBy = "fotocopia")
    private List<FotoFinalizadaEntity> fotoFinalizadaEntityList;
    @OneToMany(mappedBy = "fotocopia")
    private List<DocumentoEntity> documentoEntityList;
}
