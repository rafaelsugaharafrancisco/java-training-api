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

		User user = repository.save(form.toUserCreate());
		
		return new UserResponse(user);
	}
	
	public UserResponse findByCpf(String cpf) {
		return new UserResponse((repository.findByCpf(cpf)));
	}

	public void delete(String cpf) {
		
		if (repository.findByCpf(cpf) != null) {
			repository.delete(repository.findByCpf(cpf));
		}
	}

	public UserResponse update(String cpf, UserForm form) {			
		User user = repository.findByCpf(cpf);
		if (user != null) {
			
			repository.save(form.toUserUpdate(user.getId()));
		}
		
		return new UserResponse(user);
	}

}
