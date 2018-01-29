package com.codecool.filmsmanager.exeption;

import com.codecool.filmsmanager.error.ResponseError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import javax.validation.ConstraintDeclarationException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseError> handleIllegalArgumentException(IllegalArgumentException ex) {
        ResponseError error = new ResponseError("Wrong data", "Wrong input. Impossible to proceed");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
