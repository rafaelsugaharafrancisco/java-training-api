package br.com.training.model.dto;

import java.time.LocalDate;

public class UserResponse {
	
	private Long id;
	private String name;
	private String email;
	private String cpf;
	private LocalDate birthDate;
	
//	public UserResponse(Long id, String name, String email, String cpf, LocalDate birthDate) {
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.cpf = cpf;
//		this.birthDate = birthDate;
//	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
