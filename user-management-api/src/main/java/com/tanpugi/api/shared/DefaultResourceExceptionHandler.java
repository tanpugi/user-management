package com.tanpugi.api.shared;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tanpugi.cqrs.shared.DefaultServiceException;

@ControllerAdvice
@Component
public class DefaultResourceExceptionHandler {

	@ExceptionHandler({DataIntegrityViolationException.class, DataAccessException.class})
	@ResponseBody
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Something went wrong in the server.")
	public DefaultResponse handleServerExceptions(Exception ex) {
		DefaultResponse response = new DefaultResponse();
		response.setSuccess(false);
		response.setMessage("Something went wrong in the server.");
		return response;
	}

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DefaultResponse handle(MethodArgumentNotValidException exception) {
		DefaultResponse response = new DefaultResponse();
		response.setSuccess(false);
		response.setMessage("Some of the data in your request is not valid(argument)");
		return response;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DefaultResponse handle(HttpMessageConversionException exception) {
		DefaultResponse response = new DefaultResponse();
		response.setSuccess(false);
		response.setMessage("Request is not readable.");
		return response;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DefaultResponse handle(ConstraintViolationException exception) {
		DefaultResponse response = new DefaultResponse();
		response.setSuccess(false);
		response.setMessage("Some of the data in your request is not valid(constraint)");
		return response;
    }
    
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public DefaultResponse handle(DefaultServiceException exception) {
		DefaultResponse response = new DefaultResponse();
		response.setSuccess(false);
		response.setMessage(exception.getMessage());
		return response;
    }
}
