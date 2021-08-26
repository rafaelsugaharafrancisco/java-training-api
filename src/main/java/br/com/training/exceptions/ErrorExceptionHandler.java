package br.com.training.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.training.exceptions.dto.ErrorFormResponse;
import br.com.training.exceptions.dto.ErrorOtherResponse;
import br.com.training.exceptions.dto.UserNotFoundResponse;

@RestControllerAdvice
public class ErrorExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public List<ErrorFormResponse> errorForm(MethodArgumentNotValidException exception) {
		List<ErrorFormResponse> errosDeFormulario = new ArrayList<ErrorFormResponse>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		for (FieldError erro : fieldErrors) {
			errosDeFormulario.add(new ErrorFormResponse(erro.getField(), erro.getDefaultMessage()));
		}
		
		return errosDeFormulario;
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ErrorOtherResponse duplicated() {
		return new ErrorOtherResponse("Field(s) name and/or email is/are duplicated!");
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public UserNotFoundResponse userNotFound(UserNotFoundException exception) {
		return new UserNotFoundResponse(exception.getMessage());
	}
	
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ErrorOtherResponse methodNotAllowed(HttpRequestMethodNotSupportedException exception) {
		return new ErrorOtherResponse(exception.getMessage());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RuntimeException.class)
	public ErrorOtherResponse othersErrors(RuntimeException exception) {
		return new ErrorOtherResponse(exception.getMessage());
	}

}
