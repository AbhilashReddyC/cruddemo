package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.soringboot.crudedemo.entity.Employee;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	//define field for entitymanger
	private EntityManager entityManager;
	
	//define steupconstruction injector
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	
	public List<Employee> findAll() {
		//get current hiberanate session
		Session currentSession = entityManager.unwrap(Session.class);
		//create query
		Query<Employee> theQuery =currentSession.createQuery("from employee", Employee.class);
		//excute query and get result list
		List<Employee> employees = theQuery.getResultList();
		//return the list
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		//get the current session
		Session currentSession = entityManager.unwrap(Session.class);
		//get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		//return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
	// get currrent session
		Session currentSession = entityManager.unwrap(Session.class);
		//save Employee
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		//get current session
	Session currentSession = entityManager.unwrap(Session.class);
	//delete object with primary key
	Query theQuery = currentSession.createQuery("deleter from Employee where id =:employeeId");
	theQuery.setParameter("employeeId", theId);
	theQuery.executeUpdate();
	
	
	
	
		
	}

}
