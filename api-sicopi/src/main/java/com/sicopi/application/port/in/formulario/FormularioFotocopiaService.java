package com.sicopi.application.port.in.formulario;

import com.sicopi.domain.model.fotocopia.Documento;
import com.sicopi.domain.model.fotocopia.Fotocopia;
import com.sicopi.domain.model.solicitud.Solicitud;

import java.util.List;

public interface FormularioFotocopiaService {
    void registrarFormularioFotocopia(
            Long idPersona,
            Long idTipoDeSolicitud, Solicitud solicitud,
            Fotocopia fotocopia,
            List<Documento> documentoList
    );
}
