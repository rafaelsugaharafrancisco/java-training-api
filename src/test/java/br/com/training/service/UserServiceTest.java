package br.com.training.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class UserServiceTest {
	
	@Autowired
	private UserRepository repository;
	
	@BeforeAll
	public void criaUserValido() {
		User user = new User("Rafael", "rafa.s.francisco@gmail.com", "123456", LocalDate.of(2021, 07, 16));
		
		assertNotNull(repository.save(user));
	}
	
	@Test
	public void pesquisaSeUserExiste() {
		assertNotNull(repository.findByCpf("123456"));
	}
	
	@Test
	public void pesquisaSeUserNaoExiste() {
		assertNull(repository.findByCpf("1"));
	}
	
	@Test
	public void atualizaUser() {
		
		User user = repository.findByCpf("123456");
		user.setBirthDate(LocalDate.of(1984, 07, 16));
		
		assertNotNull(repository.save(user));
		
	}
 
}
