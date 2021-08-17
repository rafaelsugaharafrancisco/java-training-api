package br.com.training.model.dto;


import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.training.model.User;


public class UserForm {

	@NotEmpty
	@NotNull(message = "Campo name obrigatório")
	private String name;
	private String email;
	private String cpf;
	private LocalDate birthDate;
	
	public User toUser() {
		return new User(name, email, cpf, birthDate);
	}
	
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
