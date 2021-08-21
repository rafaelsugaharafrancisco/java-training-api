package br.com.training.model.dto;


import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

public class UserForm {
	
	@NotBlank(message = "Campo name é obrigatório!")
	private String name;
	
	@NotBlank(message = "Campo email é obrigatório!")
	@Email(message = "Campo email invalido! Deve conter o simbolo @")
	private String email;
	
	@NotBlank(message = "Campo cpf é obrigatório!")
	@CPF(message = "CPF é inválido!")
	private String cpf;
	
//	@NotEmpty(message = "Campo birthDate deve ser preenchido")
//	@NotNull(message = "Campo birthDate é obrigatório!")
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
