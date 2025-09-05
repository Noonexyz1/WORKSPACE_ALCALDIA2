package com.sicopi.infrastructure.http.rest.error.controller;

import com.sicopi.infrastructure.http.rest.error.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ExceptionDTO> handlerException(RuntimeException exception) {
        
        //Formamos el dto para responder
        ExceptionDTO build = new ExceptionDTO();
        build.setMensaje(exception.getMessage());

        //Respondemos el mensaje de error al cliente
        return new ResponseEntity<>(build, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
