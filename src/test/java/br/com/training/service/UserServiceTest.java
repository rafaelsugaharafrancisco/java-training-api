package br.com.training.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.training.dto.UserForm;
import br.com.training.exceptions.UserNotFoundException;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class UserServiceTest {
	
	@Autowired
	private UserService service;
	
	@BeforeAll
	public void criaUser() {
		UserForm form = new UserForm();
		form.setName("Rafael");
		form.setEmail("rafa.s.francisco@gmail.com");
		form.setCpf("123456");
		form.setBirthDate(LocalDate.of(2021, 07, 16));
		
		service.save(form);
	}
	
	@Test
	public void lancaExceptionQuandoCpfEemailDuplicado() {
		UserForm form = new UserForm();
		form.setName("Rafael");
		form.setEmail("rafa.s.francisco@gmail.com");
		form.setCpf("123456");
		form.setBirthDate(LocalDate.of(2021, 07, 16));
		
		service.save(form);
		
		UserForm form1 = new UserForm();
		form1.setName("Rafael");
		form1.setEmail("rafa.s.francisco@gmail.com");
		form1.setCpf("123456");
		form1.setBirthDate(LocalDate.of(2021, 07, 16));
		
		assertThrows(DataIntegrityViolationException.class, () -> service.save(form1));
		
	}
	
	@Test
	public void lancaExceptionQuandoCpfDuplicado() {
		UserForm form = new UserForm();
		form.setName("Roberto");
		form.setEmail("rafael@gmail.com");
		form.setCpf("123456");
		form.setBirthDate(LocalDate.of(2021, 07, 16));
		
		assertThrows(DataIntegrityViolationException.class, () -> service.save(form));
		
	}
	
	@Test
	public void lancaExceptionQuandoEmailDuplicado() {
		UserForm form = new UserForm();
		form.setName("Jose");
		form.setEmail("rafa.s.francisco@gmail.com");
		form.setCpf("1234567");
		form.setBirthDate(LocalDate.of(2021, 07, 16));
		
		assertThrows(DataIntegrityViolationException.class, () -> service.save(form));
		
	}
	
	@Test
	public void lancaExceptionQuandoUserNaoEncontradoAoAtualizar() {	
		UserForm form = new UserForm();
		form.setName("Rafael");
		form.setEmail("rafa.s.francisco@gmail.com");
		form.setCpf("123456");
		form.setBirthDate(LocalDate.of(1984, 07, 16));
		
		assertThrows(UserNotFoundException.class, () -> service.update("1",form));	
	}
	
	@Test
	public void lancaExceptionSeUserNaoExisteAoPesquisar() {
		assertThrows(UserNotFoundException.class, () -> service.findByCpf("1"));
	}
	
	@Test
	public void lancaExceptionSeUserNaoExisteAoDeletar() {		
		assertThrows(UserNotFoundException.class, () -> service.delete("1"));
	}
	
	@Test
	public void naoRetornaNuloQuandoCriaUser() {
		UserForm form = new UserForm();
		form.setName("Jose");
		form.setEmail("jose@gmail.com");
		form.setCpf("1234567");
		form.setBirthDate(LocalDate.now());
		
		assertNotNull(service.save(form));
	}
	
	@Test
	public void naoRetornaNuloSeUserExiste() {
		assertNotNull(service.findByCpf("123456"));
	}
	
	@Test
	public void naoRetornaNuloQuandoAtualizaUser() {
		
		UserForm form = new UserForm();
		form.setName("Rafael");
		form.setEmail("rafa.s.francisco@gmail.com");
		form.setCpf("123456");
		form.setBirthDate(LocalDate.of(1984, 07, 16));
		
		assertNotNull(service.update("123456",form));	
	}
	
	@Test
	public void sucessoAoDeletar() {
		
		service.delete("123456");
		assertTrue(true);
	}
	
}
