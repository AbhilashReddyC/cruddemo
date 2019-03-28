package com.luv2code.springboot.cruddemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.soringboot.crudedemo.entity.Employee;
import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
@Service

public class EmployServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;
	@Autowired
	public EmployServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO=theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theid) {
		return employeeDAO.findById(theid);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);

	}

}
