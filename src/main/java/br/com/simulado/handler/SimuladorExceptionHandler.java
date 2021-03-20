package br.com.simulado.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.NotFoundException;

@ControllerAdvice
public class SimuladorExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { NotFoundException.class, IllegalArgumentException.class })
	public ResponseEntity<Object> handleNotFoundException(Exception e, WebRequest request) {
		MensagemErro mensagemErro = new MensagemErro(e.getMessage());
		return new ResponseEntity<>(mensagemErro, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value= {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerException(Exception e, WebRequest request){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
