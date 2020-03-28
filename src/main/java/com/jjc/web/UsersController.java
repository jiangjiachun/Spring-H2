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

import com.jjc.entity.UsersEntity;
import com.jjc.exception.RecordNotFoundException;
import com.jjc.service.UsersService;

@RestController
@RequestMapping("/employees")
public class UsersController {
	@Autowired
	UsersService service;

	@GetMapping
	public ResponseEntity<List<UsersEntity>> getAllEmployees() {
		List<UsersEntity> list = service.getAllEmployees();

		return new ResponseEntity<List<UsersEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsersEntity> getEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
		UsersEntity entity = service.getEmployeeById(id);

		return new ResponseEntity<UsersEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UsersEntity> createOrUpdateEmployee(UsersEntity employee)
			throws RecordNotFoundException {
		UsersEntity updated = service.createOrUpdateEmployee(employee);
		return new ResponseEntity<UsersEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteEmployeeById(id);
		return HttpStatus.FORBIDDEN;
	}

}