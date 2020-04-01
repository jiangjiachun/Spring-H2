package com.jjc.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jjc.entity.User;
import com.jjc.exception.RecordNotFoundException;
import com.jjc.service.UsersService;


@Controller
@RequestMapping("/")
public class UsersMvcController {
	@Autowired
	private UsersService usersService;

	@RequestMapping
	public String getAllEmployees(Model model) {
		List<User> list = usersService.getAllEmployees();

		model.addAttribute("employees", list);
		return "list-employees";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Integer> id) 
							throws RecordNotFoundException {
		if (id.isPresent()) {
			User entity = usersService.getEmployeeById(id.get());
			model.addAttribute("employee", entity);
		} else {
			model.addAttribute("employee", new User());
		}
		return "add-edit-employee";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Integer id) 
							throws RecordNotFoundException {
		usersService.deleteEmployeeById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
	public String createOrUpdateEmployee(User users) throws RecordNotFoundException 
	{
		usersService.createOrUpdateEmployee(users);
		return "redirect:/";
	}
}
