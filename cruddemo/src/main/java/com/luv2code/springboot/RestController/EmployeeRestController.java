package com.luv2code.springboot.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.soringboot.crudedemo.entity.Employee;
import com.luv2code.springboot.cruddemo.Service.EmployeeService;
import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employService;

	//inject employee dao(const injection)
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employService= theEmployeeService;
	}
	//expose employess return to list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employService.findAll();
	}
}
