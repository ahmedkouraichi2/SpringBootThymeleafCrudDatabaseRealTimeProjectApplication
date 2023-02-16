package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	

    @Autowired
    private EmployeeServiceImpl  employeeService;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }
    
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
    	//create model attribute to bind from data 
    	Employee employee = new Employee();
    	model.addAttribute("employee",employee);
    	return "new_employee" ;
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

}
