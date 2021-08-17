package br.com.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.training.model.User;
import br.com.training.model.dto.UserForm;
import br.com.training.model.dto.UserResponse;
import br.com.training.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserResponse save(UserForm form) {
		User user = repository.save(form.toUser());
		
		return toUserResponse(user);
	}
	
	public UserResponse findByCpf(String cpf) {
		return toUserResponse(repository.findByCpf(cpf));
	}

	public void delete(String cpf) {
		
		if (repository.findByCpf(cpf) != null) {
			repository.delete(repository.findByCpf(cpf));
		}
	}

	public UserResponse update(String cpf, UserForm form) {			
		User user = repository.findByCpf(cpf);
		if (user != null) {
			user.setName(form.getName());
			user.setEmail(form.getEmail());
			user.setCpf(form.getCpf());
			user.setBirthDate(form.getBirthDate());
			
			repository.save(user);
		}
		
		return toUserResponse(user);
	}
	
	private UserResponse toUserResponse(User user) {
		UserResponse response = new UserResponse();
		response.setId(user.getId());
		response.setName(user.getName());
		response.setEmail(user.getEmail());
		response.setCpf(user.getCpf());
		response.setBirthDate(user.getBirthDate());
		
		return response;
	}

}
