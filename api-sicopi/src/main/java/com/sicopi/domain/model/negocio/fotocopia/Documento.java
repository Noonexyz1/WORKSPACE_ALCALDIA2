package com.sicopi.domain.model.negocio.fotocopia;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Documento {
    private Long id;
    private Double precioDocu;
    private Long nroCopias;
    private Long nroPaginas;
    private String nombreDocumento;

    private Fotocopia fotocopia;
    private PrecioFotocopia precioFotocopia;
}
