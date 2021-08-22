package br.com.training.validator.dto;

public class ErrorOtherResponse {
	
	private String message;
	
	public ErrorOtherResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
