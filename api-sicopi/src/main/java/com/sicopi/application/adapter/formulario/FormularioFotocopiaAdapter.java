package com.sicopi.application.adapter.formulario;

import com.sicopi.application.port.in.formulario.FormularioFotocopiaService;
import com.sicopi.application.port.out.persistence.empresa.PrecioFotocopiaAbs;
import com.sicopi.application.port.out.persistence.fotocopia.DocumentoAbs;
import com.sicopi.application.port.out.persistence.fotocopia.FotocopiaAbs;
import com.sicopi.application.port.out.persistence.funcionario.FuncionarioAbs;
import com.sicopi.application.port.out.persistence.solicitud.SolicitudAbs;
import com.sicopi.application.port.out.persistence.solicitud.TipoSolicitudAbs;
import com.sicopi.domain.model.empresa.PrecioFotocopia;
import com.sicopi.domain.model.fotocopia.Documento;
import com.sicopi.domain.model.fotocopia.Fotocopia;
import com.sicopi.domain.model.funcionario.Funcionario;
import com.sicopi.domain.model.solicitud.Solicitud;
import com.sicopi.domain.model.solicitud.TipoSolicitud;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public class FormularioFotocopiaAdapter implements FormularioFotocopiaService {

    private final FuncionarioAbs funcionarioAbs;
    private final SolicitudAbs solicitudAbs;
    private final TipoSolicitudAbs tipoSolicitudAbs;
    private final FotocopiaAbs fotocopiaAbs;
    private final DocumentoAbs documentoAbs;
    private final PrecioFotocopiaAbs precioFotocopiaAbs;

    public FormularioFotocopiaAdapter(
            FuncionarioAbs funcionarioAbs,
            SolicitudAbs solicitudAbs,
            TipoSolicitudAbs tipoSolicitudAbs,
            FotocopiaAbs fotocopiaAbs,
            DocumentoAbs documentoAbs,
            PrecioFotocopiaAbs precioFotocopiaAbs) {

        this.funcionarioAbs = funcionarioAbs;
        this.solicitudAbs = solicitudAbs;
        this.tipoSolicitudAbs = tipoSolicitudAbs;
        this.fotocopiaAbs = fotocopiaAbs;
        this.documentoAbs = documentoAbs;
        this.precioFotocopiaAbs = precioFotocopiaAbs;
    }


    @Override
    public void registrarFormularioFotocopia(
            Long idPersona,
            Long idTipoDeSolicitud,
            Solicitud solicitud,
            Fotocopia fotocopia,
            List<Documento> documentoList) {

        //Buscamo el funcionario correspontiende a este idPersona
        if (idPersona == null || idPersona == 0) {
            throw new RuntimeException("Id de persona vacia");
        }
        Optional<Funcionario> funcionarioFinded = this.funcionarioAbs
                .encontrarFuncionarioByIdPersona(idPersona);
        if (funcionarioFinded.isEmpty())
            throw new RuntimeException("Este id de persona no es funcionario o esta inactivo");



        //Registramos solicitud
        Optional<TipoSolicitud> tipoSolicitudFinded = this.tipoSolicitudAbs
                .encontrarTipoSolicitudById(idTipoDeSolicitud);

        if (tipoSolicitudFinded.isEmpty())
            throw new RuntimeException("Este id de tipo solicitud no existe");

        solicitud.setSolicitante(funcionarioFinded.get());
        solicitud.setTipoSolicitud(tipoSolicitudFinded.get());
        Solicitud solicitudSaved = this.solicitudAbs.registrarSolicitudAbs(solicitud);



        //Registramos fotocopia
        fotocopia.setSolicitud(solicitudSaved);
        Fotocopia fotocopiaSaved = this.fotocopiaAbs.registrarFotocopiaAbs(fotocopia);



        //Registramos documentos
        documentoList.forEach(documento -> {
            if (documento == null)
                throw new RuntimeException("Este documento no debe ser vacio");

             Optional<PrecioFotocopia> precioFotocopiaFinded = this.precioFotocopiaAbs
                     .buscarPrecioFotocopiaByCampos(
                             documento.getPrecioFotocopia().getAnverRever(),
                             documento.getPrecioFotocopia().getColor(),
                             documento.getPrecioFotocopia().getTamano()
                     );

            if (precioFotocopiaFinded.isEmpty())
                throw new RuntimeException("Este precio fotocopia no existe");

            documento.setPrecioDocu(
                    documento.getNroCopias() * documento.getNroPaginas() * precioFotocopiaFinded.get().getPrecioRef()
            );
            documento.setFotocopia(fotocopiaSaved);
            documento.setPrecioFotocopia(precioFotocopiaFinded.get());
            this.documentoAbs.registrarDocumentoAbs(documento);
        });



        //Actualizamos la fotocopia
        List<Documento> documentoListFinded = this.documentoAbs
                .listaDeDocumentosByFotocopia(fotocopiaSaved);
        if (documentoListFinded.isEmpty()) {
            throw new RuntimeException("No hay documentos asignados esta fotocopia");
        }

        Double precioTotal = documentoListFinded.stream().mapToDouble(Documento::getPrecioDocu).sum();
        Long copiaTotal = documentoListFinded.stream().mapToLong(Documento::getNroCopias).sum();
        Long paginaTotal = documentoListFinded.stream().mapToLong(Documento::getNroPaginas).sum();

        fotocopiaSaved.setPrecioTotal(precioTotal);
        fotocopiaSaved.setCopiaTotal(copiaTotal);
        fotocopiaSaved.setPaginaTotal(paginaTotal);

        this.fotocopiaAbs.registrarFotocopiaAbs(fotocopiaSaved);
    }
}
