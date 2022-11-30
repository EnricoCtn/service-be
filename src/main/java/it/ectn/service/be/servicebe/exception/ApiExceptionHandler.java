package it.ectn.service.be.servicebe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import it.ectn.service.be.servicebe.contract.ErrorItem;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ApiException.class)
	public final ResponseEntity<ErrorItem> handleApiException(ApiException apiException){
		return new ResponseEntity<>(apiException.getError(),apiException.getHttpStatus());
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorItem> handleGenericException(ApiException apiException){
		return new ResponseEntity<>(new ErrorItem("500","Errore Generico"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
}
