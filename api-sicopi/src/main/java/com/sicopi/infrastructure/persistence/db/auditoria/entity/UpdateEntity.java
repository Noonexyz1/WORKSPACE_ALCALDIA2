package com.sicopi.infrastructure.persistence.db.auditoria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "update_auditoria")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  // Escucha eventos de JPA
public class UpdateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreTablaAfectada;

    private Long idRegistroAfectado;

    @CreatedDate
    private LocalDateTime fechaOperacion;

    @CreatedBy
    private Long idAutor;
}
