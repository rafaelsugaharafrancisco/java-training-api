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
		
		UserResponse response = new UserResponse();
		response.setId(user.getId());
		response.setName(user.getName());
		response.setEmail(user.getEmail());
		response.setCpf(user.getCpf());
		response.setBirthDate(user.getBirthDate());
		
		return response;
	}
	
	public User findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	public void delete(String cpf) {
		User userFinded = findByCpf(cpf);
		
		if (userFinded != null) {
			repository.delete(userFinded);
		}
	}

	public UserResponse update(String cpf, UserForm form) {			
		User user = findByCpf(cpf);
		if (user != null) {
			user.setName(form.getName());
			user.setEmail(form.getEmail());
			user.setCpf(form.getCpf());
			user.setBirthDate(form.getBirthDate());
			
			repository.save(user);
		}
		UserResponse response = new UserResponse();
		response.setId(user.getId());
		response.setName(user.getName());
		response.setEmail(user.getEmail());
		response.setCpf(user.getCpf());
		response.setBirthDate(user.getBirthDate());
		
		return response;
	}
	
	

}
