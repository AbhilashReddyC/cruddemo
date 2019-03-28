package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.soringboot.crudedemo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	
	public Employee findById(int theid);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	

}
