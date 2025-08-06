package com.sicopi.infrastructure.persistence.db.entity.persona;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "formacion")
public class FormacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String abreviatura; // Ej: "Lic.", "Mg.", "Dr.", "Tec."
    private String formacion; // Ej: "Licenciatura en Ingeniería de Sistemas", "Máster en Marketing Digital"
    private Boolean activo = true;

    //Este campo es para la db unicamente
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // Para el manejo del contexto de JPA, si todos los id me vienen null entonces el
    // idFormacion null y su idPersona null
    // ejecutas estas estrategias cascada
    @ManyToOne
    private PersonaEntity persona;
}
