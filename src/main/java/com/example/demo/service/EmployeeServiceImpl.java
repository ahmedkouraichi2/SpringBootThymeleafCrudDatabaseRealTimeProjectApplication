package com.example.demo.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Optional;


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

	  @Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeRepository.save(employee);
		
	}


	public Employee getEmployeeById(Long id){
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null ;
		if(optional.isPresent()) {
			employee = optional.get();
			
		 }else {
			 		throw new RuntimeException("employee is not found ::" + id); 
		       }
		return  null ;
		
		
		
	
		
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		
		this.employeeRepository.deleteById(id);
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize) {
	 Pageable pageable = (Pageable) PageRequest.of(pageNo - 1, pageSize);
	 return this.employeeRepository.findAll(pageable);
	}
	
	
	
}


