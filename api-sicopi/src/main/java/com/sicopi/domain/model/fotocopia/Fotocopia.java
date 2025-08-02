package com.sicopi.domain.model.fotocopia;

import com.sicopi.domain.model.solicitud.Solicitud;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fotocopia {
    private Long id;

    //Aqui debe ir toda la informacion total de la solicitud-de-fotocopia
    private Double precioTotal;
    private Long copiaTotal;
    private Long paginaTotal;

    private Boolean activo;

    private Solicitud solicitud;
}
