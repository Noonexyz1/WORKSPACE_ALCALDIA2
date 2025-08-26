package com.sicopi.domain.model.solicitud;

import com.sicopi.domain.model.funcionario.Funcionario;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class Solicitud {
    private Long id;
    private String cite;
    private String descripcion;
    private LocalDateTime fechaCreacion;

    private Funcionario solicitante;
    private TipoSolicitud tipoSolicitud;
}
