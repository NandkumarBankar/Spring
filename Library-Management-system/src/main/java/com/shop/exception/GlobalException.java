package com.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundExcception.class)
	public ResponseEntity<ErrorMessage> handleUserException(UserNotFoundExcception ex ,WebRequest req) {
	
		ErrorMessage em=new ErrorMessage(HttpStatus.NOT_FOUND ,ex.getMessage());
		
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
}
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleBookException(BookNotFoundException ex ,WebRequest req) {
		
		ErrorMessage em=new ErrorMessage(HttpStatus.NOT_FOUND ,ex.getMessage());
		
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);

}
	
}
