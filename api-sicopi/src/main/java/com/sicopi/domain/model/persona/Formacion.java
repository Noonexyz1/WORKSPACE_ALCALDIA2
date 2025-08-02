package com.sicopi.domain.model.persona;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Formacion {
    private Long id;
    private String abreviatura; // Ej: "Lic.", "Mg.", "Dr.", "Tec."
    private String formacion; // Ej: "Licenciatura, Ingeniería"

    private Persona persona;
}
