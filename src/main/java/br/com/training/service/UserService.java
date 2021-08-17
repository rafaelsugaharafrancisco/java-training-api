package br.com.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User save(User user) {
		return repository.save(user);
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

	public User update(String cpf, User user) {
		User userFinded = findByCpf(cpf);
		
		if (userFinded != null ) {
			if (user.getName() != null) {
				userFinded.setName(user.getName());
			}
			
			if (user.getEmail() != null) {
				userFinded.setEmail(user.getEmail());
			}
			
			if (user.getCpf() != null) {
				userFinded.setCpf(user.getCpf());
			}
			
			if (user.getBirthDate() != null) {
				userFinded.setBirthDate(user.getBirthDate());
			}
			
			return save(userFinded);
		}
		
		return null;
	}
	
	

}
