package com.jjc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjc.entity.UsersEntity;
import com.jjc.exception.RecordNotFoundException;
import com.jjc.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository repository;

	public List<UsersEntity> getAllEmployees() {
		List<UsersEntity> employeeList = repository.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<UsersEntity>();
		}
	}

	public UsersEntity getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<UsersEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public UsersEntity createOrUpdateEmployee(UsersEntity entity) throws RecordNotFoundException {
		return repository.save(entity);
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<UsersEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
	
	public UsersEntity findByName(String name) {
		return repository.findByName(name);
	}
}