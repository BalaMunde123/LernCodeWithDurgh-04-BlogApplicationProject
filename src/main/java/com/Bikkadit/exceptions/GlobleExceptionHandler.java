package com.Bikkadit.exceptions;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Bikkadit.payload.ApiResponce;

@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce> ResorceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponce api = new ApiResponce(message, false);
		return new ResponseEntity<ApiResponce>(api, HttpStatus.NOT_FOUND);
		
	}
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String,String>> handllerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
	Map<String, String> resp=new HashMap<>();
	ex.getBindingResult().getAllErrors().forEach((error)->{
     String fieldname = ((FieldError)error).getField();
	String Message = error.getDefaultMessage();
	
	resp.put(fieldname, Message);
	});
	
	
	return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	
	
}
}
