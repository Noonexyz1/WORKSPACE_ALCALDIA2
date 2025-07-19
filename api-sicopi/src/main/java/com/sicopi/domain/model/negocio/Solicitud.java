package com.sicopi.domain.model.negocio;

import com.sicopi.domain.model.funcionario.Funcionario;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Solicitud {
    private Long id;
    private String cite;
    private String descripcion;
    private LocalDate fechaRealizacion;
    private Funcionario solicitante;
    private TipoSolicitud tipoSolicitud;
}
