package com.jjc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjc.entity.User;
import com.jjc.exception.RecordNotFoundException;
import com.jjc.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository repository;

	public List<User> getAllEmployees() {
		List<User> employeeList = repository.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<User>();
		}
	}

	public User getEmployeeById(Integer id) throws RecordNotFoundException {
		Optional<User> employee = repository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public User createOrUpdateEmployee(User entity) throws RecordNotFoundException {
		return repository.save(entity);
	}

	public void deleteEmployeeById(Integer id) throws RecordNotFoundException {
		Optional<User> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
	
	public User findByName(String name) {
		return repository.findByName(name);
	}
}