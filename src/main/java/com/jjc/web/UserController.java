package com.jjc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjc.entity.User;
import com.jjc.exception.RecordNotFoundException;
import com.jjc.service.UserService;

@RestController
@RequestMapping("/employees")
public class UserController {
	@Autowired
	UserService service;

	@GetMapping
	public ResponseEntity<List<User>> getAllEmployees() {
		List<User> list = service.getAllEmployees();

		return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getEmployeeById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		User entity = service.getEmployeeById(id);

		return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> createOrUpdateEmployee(User employee)
			throws RecordNotFoundException {
		User updated = service.createOrUpdateEmployee(employee);
		return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		service.deleteEmployeeById(id);
		return HttpStatus.FORBIDDEN;
	}

}