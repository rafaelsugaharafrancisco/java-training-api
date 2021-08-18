package br.com.training.model.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.training.model.User;

public class UserForm {
	
	@NotEmpty(message = "Campo name deve ser preenchido")
	@NotNull(message = "Campo name é obrigatório!")
	private String name;
	
	@NotEmpty(message = "Campo email deve ser preenchido")
	@NotNull(message = "Campo email é obrigatório!")
	@Email(message = "Campo email invalido! Deve conter o simbolo @")
	private String email;
	
	@NotEmpty(message = "Campo cpf deve ser preenchido")
	@NotNull(message = "Campo cpf é obrigatório!")
	@CPF(message = "Campo CPF é inválido!")
	private String cpf;
	
	@NotEmpty(message = "Campo birthDate deve ser preenchido")
	@NotNull(message = "Campo birthDate é obrigatório!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String birthDate;
	
	public User toUserCreate() {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setCpf(cpf);
		user.setBirthDate(user.new LocalDateSpringConverter().convert(birthDate));
		
		return user;
	}
	
	public User toUserUpdate(Long id) {
		User user = toUserCreate();
		user.setId(id);
		
		return user;
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

}
