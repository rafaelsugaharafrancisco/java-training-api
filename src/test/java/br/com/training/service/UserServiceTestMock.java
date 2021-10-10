package br.com.training.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.training.dto.UserForm;
import br.com.training.exceptions.UserNotFoundException;
import br.com.training.model.User;
import br.com.training.repository.UserRepository;

public class UserServiceTestMock {
	
	private UserService service;
	
	@Mock
	private UserRepository repository;
	
	@BeforeEach
	public void initMock() {
		MockitoAnnotations.openMocks(this);
		service = new UserService(repository);
	}
	
	@Test
	public void throwNotFoundException() {
		assertThrows(UserNotFoundException.class, () -> service.findByCpf("3"));
	}
	
	@Test
	public void saveUser() {
		UserForm form = new UserForm();
		form.setName("Fulano");
		form.setEmail("fulano@gmail.com");
		form.setCpf("123456789");
		form.setBirthDate(LocalDate.of(1984, 7, 16));
		
		User user = new User(form.getName(), form.getEmail(), form.getCpf(), form.getBirthDate());

		Mockito.when(repository.save(user)).thenReturn(user);
		
		service.save(form);
		
		Mockito.verify(repository).save(user);
	}
}
