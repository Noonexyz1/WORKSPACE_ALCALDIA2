package com.sicopi.infrastructure.http.rest.enums;

public enum ApiBaseUrls {

    BASE_URLS("/api/v1.1");

    private final String valor;

    ApiBaseUrls(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
