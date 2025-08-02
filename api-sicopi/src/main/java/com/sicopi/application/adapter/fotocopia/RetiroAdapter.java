package com.sicopi.application.adapter.fotocopia;

import com.sicopi.application.port.in.fotocopia.RetiroService;
import com.sicopi.application.port.out.persistence.fotocopia.RetiroAbs;
import com.sicopi.domain.model.fotocopia.Retiro;

public class RetiroAdapter implements RetiroService {

    private final RetiroAbs retiroAbs;

    public RetiroAdapter(RetiroAbs retiroAbs) {
        this.retiroAbs = retiroAbs;
    }

    @Override
    public Retiro registrarRetiro(Retiro retiro) {
        return this.retiroAbs.registrarRetiroAbs(retiro);
    }
}
