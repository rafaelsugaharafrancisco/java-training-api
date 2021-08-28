package br.com.training.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.training.dto.UserForm;
import br.com.training.dto.UserResponse;
import br.com.training.service.UserService;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserResponse createUser(@RequestBody @Valid UserForm form) {

		return service.save(form);
	}

	@GetMapping (value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
    public UserResponse getUser (@PathVariable String cpf){
        return service.findByCpf(cpf);
    }
	
	@DeleteMapping(value = "/{cpf}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable String cpf) {
		service.delete(cpf);
	}
	
	@PutMapping(value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public UserResponse updateUser(@PathVariable String cpf, @Valid @RequestBody UserForm form) {
		return service.update(cpf, form);
	}

}
