package com.luv2code.springboot.cruddemo.Service;

import java.util.List;

import com.luv2code.soringboot.crudedemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theid);

	public void save(Employee theEmployee);

	public void deleteById(int theId);

}
