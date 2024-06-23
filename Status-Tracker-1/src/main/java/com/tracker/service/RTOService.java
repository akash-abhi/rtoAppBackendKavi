package com.tracker.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

 
 
import com.tracker.exception.UserNotFoundException;
import com.tracker.model.RTOEntity;
 
@Service
public interface RTOService {
	
	public ResponseEntity<RTOEntity> createRTOForEmployee(RTOEntity rtoEntity);
	
	List<RTOEntity> getAllRto();
 
	ResponseEntity<RTOEntity> getRTOByEmpName(String empName) throws UserNotFoundException;
 
	public RTOEntity updateRTO(String empName, RTOEntity rtoEntity) throws UserNotFoundException;
 
}