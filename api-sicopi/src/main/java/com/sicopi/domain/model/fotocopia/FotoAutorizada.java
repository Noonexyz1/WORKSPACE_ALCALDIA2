package com.sicopi.domain.model.fotocopia;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FotoAutorizada {
    private Long id;
    private Fotocopia fotocopia;
}
