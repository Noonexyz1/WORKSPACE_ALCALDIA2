package com.sicopi.application.adapter.formulario;

import com.sicopi.application.port.in.formulario.FormularioRetiroService;
import com.sicopi.application.port.out.persistence.fotocopia.DocumentoAbs;
import com.sicopi.application.port.out.persistence.fotocopia.FotocopiaAbs;
import com.sicopi.application.port.out.persistence.fotocopia.RetiroAbs;
import com.sicopi.domain.model.fotocopia.Documento;
import com.sicopi.domain.model.fotocopia.Retiro;

import java.util.List;
import java.util.Optional;

public class FormularioRetiroAdapter implements FormularioRetiroService {

    private final RetiroAbs retiroAbs;
    private final DocumentoAbs documentoAbs;
    private final FotocopiaAbs fotocopiaAbs;

    public FormularioRetiroAdapter(
            RetiroAbs retiroAbs,
            DocumentoAbs documentoAbs,
            FotocopiaAbs fotocopiaAbs) {

        this.retiroAbs = retiroAbs;
        this.documentoAbs = documentoAbs;
        this.fotocopiaAbs = fotocopiaAbs;
    }

    @Override
    public void registrarFormularioRetiro(List<Retiro> retiroList) {
        retiroList.forEach(retiro -> {

            if (retiro.getNumeroRetiro() == null || retiro.getNumeroRetiro() == 0)
                throw new RuntimeException("Numero de retiro invalido");

            if (retiro.getDocumento() == null ||
                    retiro.getDocumento().getId() == null ||
                    retiro.getDocumento().getId() == 0) {
                throw new RuntimeException("Id de documento invalido");
            }

            Optional<Documento> documentoFinded = this.documentoAbs
                    .buscarDocumentoPorId(retiro.getDocumento().getId());

            if (documentoFinded.isEmpty())
                throw new RuntimeException("Este id de documento no existe");

            retiro.setDocumento(documentoFinded.get());



            //Cuanto el usuario seleccione un documento que quiera retirar,
            //pues al hacer click en el boton de "retirar documento"
            //Angular hara una peticion de el ultimo retiro de ese documento y lo traera al frente
            //una vez en el frente pues este tendra los datos de sumatorarias, catnidadres disponibles etc
            //y si no hya un retiro de ese documento, entonces le enviara el total con SUMATORIAS en 0 pero
            //con los totales pues disponibles o aprobados



            //Aqui debo establecer nuevos datos para el retiro
            //Establecemos el precio parcial
            retiro.setPrecioParcial(retiro.getNumeroRetiro() *
                    documentoFinded.get().getPrecioFotocopia().getPrecioRef() *
                    documentoFinded.get().getNroPaginas());

            //Para las notas de pedido
            Double precioSumaParcial = retiro.getPrecioSumaParcial() +
                    (retiro.getNumeroRetiro() *
                            documentoFinded.get().getPrecioFotocopia().getPrecioRef() *
                            documentoFinded.get().getNroPaginas());
            retiro.setPrecioSumaParcial(precioSumaParcial);

            //para el precio total del documento
            //retiro.setPrecioTotal(documentoFinded.get().getPrecioDocu());

            //para establecer la sumatoria de cantidad de retirados
            retiro.setSumNumeroRetiro(retiro.getNumeroRetiro()  +
                    retiro.getSumNumeroRetiro());



            //Para la gestion de credito
            retiro.setTotalDisponible(retiro.getTotalDisponible() - retiro.getNumeroRetiro());
            //retiro.setTotalUsado(retiro.getTotalUsado());

            if (documentoFinded.get().getRetirosConcluidos())
                throw new RuntimeException("Este documento ya ha sido concluido");

            if (retiro.getTotalDisponible() < 0)
                throw new RuntimeException("El numero de retiro supera el numero del disponible aprobado para este documento");


            this.retiroAbs.registrarRetiroAbs(retiro);

            documentoFinded.get().setRetirosConcluidos(retiro.getTotalDisponible() == 0);
            this.documentoAbs.registrarDocumentoAbs(documentoFinded.get());


            //Oh quiza no necesite un patron observer
            //mejor probamos por cada documento
            List<Documento> documentoList = this.documentoAbs
                    .listaDeDocumentosByFotocopia(documentoFinded.get().getFotocopia());
            int size = documentoList.size();

            int sizeTrues = documentoList.stream()
                    .filter(documento -> documento.getRetirosConcluidos() == true)
                    .toList()
                    .size();

            if (size == sizeTrues) {
                documentoFinded.get().getFotocopia().setFinalizado(true);
                this.fotocopiaAbs.registrarFotocopiaAbs(documentoFinded.get().getFotocopia());
            }


        });
    }
}
