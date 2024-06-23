package com.tracker.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tracker.exception.UserNotFoundException;
import com.tracker.model.EmployeeDTO;
import com.tracker.model.EmployeeEntity;
import com.tracker.repository.EmployeeRepository;

import org.modelmapper.ModelMapper;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public String loginUser(int empId, String password) {	
		if (!employeeRepo.existsById(empId)) {
			return "Userid or Password is Invalid.";
		} else {
			Optional<EmployeeEntity> employee = employeeRepo.findByEmpId(empId);
			if (employee != null && employee.get().getPassword().equals(password)) {
				return "User is successfully logged in";
			} else {
				return "User Id or Password is Invalid.";
			}
		}
	}

	@Override
	public String saveDetails(EmployeeEntity employees) {
		if (employeeRepo.existsById(employees.getEmpId())) {
			return "User already exists. Please enter valid employee id";
		} else {
			employeeRepo.save(employees);
			return "User " + employees.getEmpId() + " Added Successfully";
		}
	}
	

	@Override
	public List<EmployeeEntity> getAllDetails() {
		List<EmployeeEntity> employeeEntities = employeeRepo.findAll();
		return  employeeEntities;
	}
	
//	@Override
//	public List<EmployeeDTO> getAllDetails() {
//		List<EmployeeEntity> employeeEntities = employeeRepo.findAll();
//		return employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
//				.collect(Collectors.toList());
//	}
	
	@Override
	public ResponseEntity<EmployeeDTO> getUserByEmpId(int empId) throws UserNotFoundException {
		Optional<EmployeeEntity> result = employeeRepo.findById(empId);
		if (result.isPresent()) {
			EmployeeEntity employeeEntity = result.get();
			EmployeeDTO employeeDTO = modelMapper.map(employeeEntity, EmployeeDTO.class);
			return ResponseEntity.ok(employeeDTO);
		} 
			throw new UserNotFoundException("User " + empId + " not found");
		
	}

	@Override
	public ResponseEntity<EmployeeDTO> getUserByName(String empName) throws UserNotFoundException{
		Optional<EmployeeEntity> result = employeeRepo.findByEmpNameIgnoreCase(empName);
		if (result.isPresent()) {
			EmployeeEntity employeeEntity = result.get();
			EmployeeDTO employeeDTO = modelMapper.map(employeeEntity, EmployeeDTO.class);
			return ResponseEntity.ok(employeeDTO);
		} else {
			throw new UserNotFoundException("Employee with name " + empName + " not found");
		}
	}
	

	@Override
	public EmployeeEntity updateEmployee(int empId, EmployeeEntity employeeEntityRequest) throws UserNotFoundException {
		EmployeeEntity employeeEntity = employeeRepo.findByEmpId(empId)
				.orElseThrow(() -> new UserNotFoundException("Employee with id " + empId + " not found"));

		employeeEntity.setEmpName(employeeEntityRequest.getEmpName());
		employeeEntity.setEmailId(employeeEntityRequest.getEmailId());
		employeeEntity.setRole(employeeEntityRequest.getRole());
		employeeEntity.setBaselocation(employeeEntityRequest.getBaselocation());
		return employeeRepo.save(employeeEntity);
	}

	
	@Override
	public String deleteEmployee(int empId) {
        try {
            EmployeeEntity employeeEntity = employeeRepo.findByEmpId(empId)
                    .orElseThrow(() -> new UserNotFoundException("Employee with id " + empId + " not found"));
            
            employeeRepo.delete(employeeEntity);
            return "Employee " + empId + " deleted successfully";
        } catch (UserNotFoundException e) {
            return "Employee with id " + empId + " not found";
        }

    }

}

