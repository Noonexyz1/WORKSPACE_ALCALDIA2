package com.sicopi.infrastructure.persistence.db.entity.solicitud;

import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncionarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "solicitud")
public class SolicitudEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cite;
    private String descripcion;


    @ManyToOne
    private FuncionarioEntity solicitante;
    @ManyToOne
    private TipoSolicitudEntity tipoSolicitud;



    private LocalDateTime fechaCreacion;

    @PrePersist
    public void iniciarValores() {
        this.fechaCreacion = LocalDateTime.now();
    }
}
