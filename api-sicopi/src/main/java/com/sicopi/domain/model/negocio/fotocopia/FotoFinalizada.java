package com.sicopi.domain.model.negocio.fotocopia;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FotoFinalizada {
    private Long id;
    private Fotocopia fotocopia;
}
