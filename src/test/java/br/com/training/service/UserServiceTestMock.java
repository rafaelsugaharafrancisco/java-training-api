package br.com.training.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.training.exceptions.UserNotFoundException;
import br.com.training.repository.UserRepository;

public class UserServiceTestMock {
	
	private UserService service;
	
	@Mock
	private UserRepository repository;
	
	@BeforeEach
	public void initMock() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void throwNotFoundException() {
		service = new UserService(repository);
		assertThrows(UserNotFoundException.class, () -> service.findByCpf("3"));
	}
}
