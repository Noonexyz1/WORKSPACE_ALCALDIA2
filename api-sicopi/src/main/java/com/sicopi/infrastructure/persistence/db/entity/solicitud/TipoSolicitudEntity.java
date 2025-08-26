package com.sicopi.infrastructure.persistence.db.entity.solicitud;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tipo_solicitud")
public class TipoSolicitudEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean activo;


    @OneToMany(mappedBy = "tipoSolicitud")
    private List<SolicitudEntity> solicitudEntityList;

    private LocalDateTime fechaCreacion;

    @PrePersist
    public void iniciarValores() {
        this.activo = true;
        this.fechaCreacion = LocalDateTime.now();
    }

}
