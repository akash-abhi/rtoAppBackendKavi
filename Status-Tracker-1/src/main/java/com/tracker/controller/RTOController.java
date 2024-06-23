package com.tracker.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.exception.UserNotFoundException;
import com.tracker.model.RTOEntity;
import com.tracker.service.RTOService;
 

@RequestMapping("/status-tracker/user/rto")
@CrossOrigin(origins="*")
@RestController
public class RTOController {
	
	@Autowired
	private RTOService rtoService;
	
	@PostMapping("/createRTO")
    public void createRTOForEmployee(@RequestBody RTOEntity rtoEntity) {
         rtoService.createRTOForEmployee(rtoEntity);
         
         
    }
 
    @GetMapping("/getRTOByName/{empName}")
    public ResponseEntity<RTOEntity> getRTOByEmpName(@PathVariable String empName) throws UserNotFoundException{
        return rtoService.getRTOByEmpName(empName);	
        }
    
    @GetMapping("/get/allRTO")
	public List<RTOEntity> getAllRTODetails() {
		return rtoService.getAllRto();
	}
    
    @PutMapping("/update/rtoDetails/{empName}")  
    public RTOEntity updateRTOEntity(@PathVariable String empName, @RequestBody RTOEntity rtoEntity) throws UserNotFoundException {
		return rtoService.updateRTO(empName, rtoEntity);
	}
 
}