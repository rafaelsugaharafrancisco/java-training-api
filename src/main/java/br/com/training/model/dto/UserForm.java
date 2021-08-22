package br.com.training.model.dto;


import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

public class UserForm {
	
	@NotBlank(message = "Field name is required!")
	private String name;
	
	@NotBlank(message = "Field email is required!")
	@Email(message = "Fiedl email is invalid!")
	private String email;
	
	@NotBlank(message = "Field cpf is required!")
	@CPF(message = "CPF é inválido!")
	private String cpf;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
