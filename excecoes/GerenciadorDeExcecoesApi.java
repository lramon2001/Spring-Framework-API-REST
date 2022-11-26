package br.com.lucasramon.lrprojetos.api.excecoes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




@ControllerAdvice(annotations = RestController.class)
public class GerenciadorDeExcecoesApi extends ResponseEntityExceptionHandler {
    

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiErro> handleEntityNotFoundException(EntityNotFoundException exception){ 
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiErro apiErro = new ApiErro();
        apiErro.setErro(httpStatus.value());
        apiErro.setTimestamp(LocalDateTime.now());
        apiErro.setMensagem(exception.getLocalizedMessage());
        apiErro.setStatus(httpStatus.getReasonPhrase());

        return new ResponseEntity<>(apiErro,httpStatus);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
HttpHeaders headers, HttpStatus status, WebRequest request) {

    List<CampoErro> erros = new ArrayList<CampoErro>();

    exception.getBindingResult().getFieldErrors().forEach(fieldError->{
        CampoErro campoErro = new CampoErro();
        campoErro.setCampo(fieldError.getField());
        campoErro.setCampo(fieldError.getDefaultMessage());
        erros.add(campoErro);
    });

    ValicaoApiErro valicaoApiErro = new ValicaoApiErro();
    valicaoApiErro.setErro(status.value());
    valicaoApiErro.setTimestamp(LocalDateTime.now());
    valicaoApiErro.setMensagem("Houve erro de validação");
    valicaoApiErro.setErros(erros);

    return new ResponseEntity<>(valicaoApiErro,status);
    
    }
}
