package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.EmployeeEntity;
import com.tracker.repository.EmployeeRepository;
import com.tracker.service.EmployeeService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/status-tracker")
public class LoginController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepository employeeRepo;

	
//	@PostMapping("/login/{empID}")
//    public String login(@RequestParam int empId, @RequestParam String password){
//        return employeeService.loginUser(empId,password);
//    }
	
	
	
	@PostMapping("/login")
    public EmployeeEntity login(@RequestBody EmployeeEntity user){
		 List<EmployeeEntity> allUsers = employeeRepo.findAll();
	        for(EmployeeEntity currentUser: allUsers) {
	            if (currentUser.getEmpId()==(user.getEmpId()) ){
	                if (currentUser.getPassword().equals(user.getPassword())) {
	                	return currentUser;
	                }
	                return user;
	            } 
	        }
	        return user; 
    }

}
