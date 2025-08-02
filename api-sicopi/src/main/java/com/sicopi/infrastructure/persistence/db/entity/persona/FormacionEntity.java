package com.sicopi.infrastructure.persistence.db.entity.persona;

import jakarta.persistence.*;
import lombok.*;

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

    // Para el manejo del contexto de JPA, si todos los id me vienen null entonces el
    // idFormacion null y su idPersona null
    // ejecutas estas estrategias cascada
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private PersonaEntity persona;
}
