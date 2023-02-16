package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	  @Autowired
	    private EmployeeRepository employeeRepository;
	
	  
	  @Override
		public List<Employee> getAllEmployees() {
			// TODO Auto-generated method stub
			return  employeeRepository.findAll();

	}


	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeRepository.save(employee);
		
	}
	

	  

		
	}


