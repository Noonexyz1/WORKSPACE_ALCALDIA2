package com.sicopi.domain.model.fotocopia;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Retiro {
    private Long id;
    //cantidad Retiro actual del usuario del documento
    private Long numeroRetiro;

    private Double precioParcial;


    //ESTO ES PARA LAS NOTAS DE PEDIDO
    //Estos dos atributos es para ir sumando el precio parcial por cada retiro
    private Double precioSumaParcial;
    //Precio total documento, si el precioSumaParcial es igual al precioTotal del documento,
    // entonces se terminan los retiros para este documento
    //private Double precioTotal;


    private Long sumNumeroRetiro;


    //ESTO ES PARA LA GESTION DE CREDITOS
    //Esto es por cada Documento osea totalCopiasDocuento
    //private Long totalCopias;
    private Long totalDisponible;

    private Documento documento;
}
