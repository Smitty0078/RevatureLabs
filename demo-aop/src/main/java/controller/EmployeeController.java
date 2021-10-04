package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.EmployeeService;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping
	public String getEmployees() {
		//service.create();
		return "employees";
	}
	
	
}
