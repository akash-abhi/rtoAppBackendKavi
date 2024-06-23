package com.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tracker.controller.AdminController;
import com.tracker.exception.UserNotFoundException;
import com.tracker.model.EmployeeDTO;
import com.tracker.model.EmployeeEntity;
import com.tracker.repository.EmployeeRepository;
import com.tracker.service.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

public class AdminControllerTest {
	
	@InjectMocks
	private AdminController adminController;

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	@Mock
    private ModelMapper modelMapper;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void saveDetails_employeeExists() {
		EmployeeEntity existingEmployee = new EmployeeEntity();
		existingEmployee.setEmpId(1);
		when(employeeRepository.existsById(anyInt())).thenReturn(true);
		String result = employeeService.saveDetails(existingEmployee);
		assertEquals("User already exists. Please enter valid employee id", result);
		Mockito.verify(employeeRepository, Mockito.never()).save(existingEmployee);
	}

	@Test
	void saveDetails_employeeDoesNotExist() {
		EmployeeEntity newEmployee = new EmployeeEntity();
		newEmployee.setEmpId(2);
		when(employeeRepository.existsById(anyInt())).thenReturn(false);
		String result = employeeService.saveDetails(newEmployee);
		assertEquals("User 2 Added Successfully", result);
		Mockito.verify(employeeRepository, Mockito.times(1)).save(newEmployee);
	}
	
//	@Test
//    public void testDeleteEmployeeException() throws UserNotFoundException{
//        int empId = 1;
//        Mockito.doThrow(new UserNotFoundException("Employee with id " + empId + " not found")).when(employeeService).deleteEmployee(empId);
//        ResponseEntity<String> responseEntity = adminController.deleteEmployee(empId);
//        // Assert that the response is NOT FOUND (HTTP 404) and contains the error message
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Employee with id 1 not found", responseEntity.getBody());
//    }
	
//	@Test
//    public void testDeleteEmployeeException() throws UserNotFoundException {
//        int empId = 1;
//        doThrow(new UserNotFoundException("Employee with id " + empId + " not found"))
//                .when(employeeService).deleteEmployee(anyInt());
//        // Call the method that triggers the exception
//        ResponseEntity<String> responseEntity = adminController.deleteEmployee(empId);
//        // Assert that the response is NOT FOUND (HTTP 404) and contains the error message
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Employee with id 1 not found", responseEntity.getBody());
//    }
}