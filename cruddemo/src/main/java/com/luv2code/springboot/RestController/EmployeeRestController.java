package com.luv2code.springboot.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.soringboot.crudedemo.entity.Employee;
import com.luv2code.springboot.cruddemo.Service.EmployeeService;

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
	// add mapping for get employee id
		
		@GetMapping("/employees/{employeeId}")
		public Employee getEmployee(@PathVariable int employeeId) {
			Employee theEmployee = employService.findById(employeeId);
			if(theEmployee==null) {
				throw new RuntimeException("Employee id not found-"  + employeeId);
			}
			return theEmployee;
		}
		//post Api call
		@PostMapping("/employees")
		public Employee addEmployee(@RequestBody Employee theEmployee) {
			theEmployee.setId(0);
			employService.save(theEmployee);
			return theEmployee;
		}
		//put Api call
		@PutMapping("/employees")
		public Employee updateEmployee(@RequestBody Employee theEmployee) {
			employService.save(theEmployee);
			return theEmployee;
		}
		//delete ApI call
		@DeleteMapping("/employees/{employeeId}")
		 public String deleteEmployee(@PathVariable int employeeId) {
		   Employee tempEmployee = employService.findById(employeeId);
			if(tempEmployee==null) {
				throw new RuntimeException("Employee id not found-"  + employeeId);
		}
			employService.deleteById(employeeId);
			return "deleted employee id-" + employeeId;
	}
}
