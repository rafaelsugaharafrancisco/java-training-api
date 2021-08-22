package br.com.training.validator.dto;

public class ErrorFormResponse {
	
	private String field;
	private String message;
	
	public ErrorFormResponse(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}

}
