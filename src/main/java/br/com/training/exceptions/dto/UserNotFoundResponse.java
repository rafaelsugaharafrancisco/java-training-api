package br.com.training.exceptions.dto;

public class UserNotFoundResponse {
	 
	private String message;
	
	public UserNotFoundResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}	
}