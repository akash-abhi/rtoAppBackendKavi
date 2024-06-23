package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.exception.UserNotFoundException;
import com.tracker.model.EmployeeDTO;
import com.tracker.model.EmployeeEntity;
import com.tracker.service.EmployeeService;

import org.modelmapper.ModelMapper;


@RequestMapping("/status-tracker/admin")
@RestController
public class AdminController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	public EmployeeService employeeService;
	
	@GetMapping("/get/all")
	public List<EmployeeEntity> getAllEmployees() {
		return employeeService.getAllDetails();
	}

    @PostMapping("/add/userDetails")
    public String saveDetails( @RequestBody EmployeeEntity employee){
        return employeeService.saveDetails(employee);
    }
    
    
    
    @GetMapping("/get/id/{empId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "empId") int empId) throws UserNotFoundException{
		return employeeService.getUserByEmpId(empId);
	}
    
    @GetMapping("/get/name/{empName}")
    public ResponseEntity<EmployeeDTO> getUser(@PathVariable String empName) throws UserNotFoundException{
    	return employeeService.getUserByName(empName);
    }
    
    @PutMapping("/update/userDetails/{empId}")  
    public ResponseEntity<EmployeeDTO> updateEmployeeEntity(@PathVariable int empId, @RequestBody EmployeeDTO EmployeeDTO) throws UserNotFoundException {

		// convert DTO to Entity
		EmployeeEntity EmployeeEntityRequest = modelMapper.map(EmployeeDTO, EmployeeEntity.class);

		EmployeeEntity EmployeeEntity = employeeService.updateEmployee(empId, EmployeeEntityRequest);

		// entity to DTO
		EmployeeDTO EmployeeEntityResponse = modelMapper.map(EmployeeEntity, EmployeeDTO.class);

		return ResponseEntity.ok().body(EmployeeEntityResponse);
	}
    
    @DeleteMapping("/delete/employee/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empId) throws UserNotFoundException{ 
    	return ResponseEntity.ok(employeeService.deleteEmployee(empId)); 
    	}
}
