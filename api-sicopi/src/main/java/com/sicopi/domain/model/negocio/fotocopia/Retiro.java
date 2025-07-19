package com.sicopi.domain.model.negocio.fotocopia;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Retiro {
    private Long id;
    private Double precioParcial;
    private Double precioSumaParcial;
    private Double precioTotal;
    private Long numeroRetiro;
    private Long sumNumeroRetiro;
    private Long totalCopias;
    private Long totalDisponible;
    private Long totalUsado;

    private Documento documento;
}
