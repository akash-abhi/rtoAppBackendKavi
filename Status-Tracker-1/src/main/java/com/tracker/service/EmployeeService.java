package com.tracker.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.tracker.exception.UserNotFoundException;
import com.tracker.model.EmployeeDTO;
import com.tracker.model.EmployeeEntity;

@Service
public interface EmployeeService { 
	
	public String loginUser(int empId, String password);

	public List<EmployeeEntity> getAllDetails();
	
	public String saveDetails(EmployeeEntity employee);

	public ResponseEntity<EmployeeDTO> getUserByEmpId(int empId) throws UserNotFoundException;

	public ResponseEntity<EmployeeDTO> getUserByName(String empName) throws UserNotFoundException;
	
	public String deleteEmployee(int empId) throws UserNotFoundException;

	EmployeeEntity updateEmployee(int empId, EmployeeEntity EmployeeEntityRequest) throws UserNotFoundException;


}
