package com.sicopi.infrastructure.http.rest.dto;

import com.sicopi.domain.model.fotocopia.Documento;
import com.sicopi.domain.model.fotocopia.Fotocopia;
import com.sicopi.domain.model.solicitud.Solicitud;
import lombok.Data;

import java.util.List;

@Data
public class FotocopiaDTO {
    private Long idPersona;
    private Long idTipoDeSolicitud;

    //el funcionario de la solu=icutud, el sistema lo debe autor buscar con el idPersona
    private Solicitud solicitud;
    private Fotocopia fotocopia;

    //el precio de los docuemtnos el sistema lo debe auto calcular
    private List<Documento> documentoList;
}
