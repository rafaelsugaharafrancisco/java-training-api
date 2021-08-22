package br.com.training.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.training.exceptions.UserNotFoundException;
import br.com.training.model.User;
import br.com.training.model.dto.UserForm;
import br.com.training.model.dto.UserResponse;
import br.com.training.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional
	public UserResponse save(UserForm form) {

		User user = repository.save(new User(form.getName(), form.getEmail(), form.getCpf(), form.getBirthDate()));
		
		return new UserResponse(user);
	}
	
	public UserResponse findByCpf(String cpf) {
		if (repository.findByCpf(cpf) == null) {
			throw new UserNotFoundException();
		}
		return new UserResponse((repository.findByCpf(cpf)));
	}

	@Transactional
	public void delete(String cpf) {

		if (repository.findByCpf(cpf) == null) {
			throw new UserNotFoundException();
		}
		
		repository.delete(repository.findByCpf(cpf));
	}

	@Transactional
	public UserResponse update(String cpf, UserForm form) {			
		User user = repository.findByCpf(cpf);
		
		if (user == null) {
			throw new UserNotFoundException();
		}
		user.setName(form.getName());
		user.setEmail(form.getEmail());
		user.setCpf(form.getCpf());
		user.setBirthDate(form.getBirthDate());	
		
		
		return new UserResponse(user);
	}

}
