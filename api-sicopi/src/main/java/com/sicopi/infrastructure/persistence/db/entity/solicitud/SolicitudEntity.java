package com.sicopi.infrastructure.persistence.db.entity.solicitud;

import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncionarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate fechaRealizacion;


    @ManyToOne
    private FuncionarioEntity solicitante;
    @ManyToOne
    private TipoSolicitudEntity tipoSolicitud;
}
