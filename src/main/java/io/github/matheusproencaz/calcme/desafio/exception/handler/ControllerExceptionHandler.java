package io.github.matheusproencaz.calcme.desafio.exception.handler;

import io.github.matheusproencaz.calcme.desafio.exception.dto.StandardError;
import io.github.matheusproencaz.calcme.desafio.exception.dto.ValidationError;
import io.github.matheusproencaz.calcme.desafio.service.exception.EmailAlreadyExistsException;
import org.springframework.data.mongodb.core.MongoDataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    public ControllerExceptionHandler() {
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<StandardError> emailAlreadyExists(EmailAlreadyExistsException e, WebRequest request){
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Email já existe!" , e.getLocalizedMessage(), request.getContextPath());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValid(MethodArgumentNotValidException e, WebRequest request){

        ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de Validação!", e.getLocalizedMessage(), request.getContextPath());

        for(FieldError x : e.getBindingResult().getFieldErrors()) {
            err.addError(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }

    @ExceptionHandler(MongoDataIntegrityViolationException.class)
    public ResponseEntity<StandardError> MongoDataIntegrityViolation(MongoDataIntegrityViolationException e, WebRequest request) {
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro de Integridade de Dados!" , e.getLocalizedMessage(), request.getContextPath());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
}
