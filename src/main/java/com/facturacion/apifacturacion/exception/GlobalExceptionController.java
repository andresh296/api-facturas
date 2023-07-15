package com.facturacion.apifacturacion.exception;

import com.facturacion.apifacturacion.web.ResponseError;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handleValidateExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            errors.put(fieldName, message);
        });

        return ResponseError.createResponse(HttpStatus.BAD_REQUEST, "Peticion erronea", errors);
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JDBCConnectionException.class)
    public ResponseEntity<ResponseError> handleDBExceptions(JDBCConnectionException ex) {

        return ResponseError.createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error en la DB", "Error en la conexion a la DB");
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseError> handleResourceNotFoundExceptions(ResourceNotFoundException ex) {

        return ResponseError.createResponse(HttpStatus.NOT_FOUND, "No se encontro el recurso", ex.getMessage());
    }
}
