package br.com.training.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;

public class FirstStepInMockito {
	
	@Test
	public void FirstStep() {
		UserRepository mock = Mockito.mock(UserRepository.class);
		List<User> users = mock.findAll();
		assertTrue(users.isEmpty());
	}
}
// mock simula as dependencias. Faz o papel de "dublê".