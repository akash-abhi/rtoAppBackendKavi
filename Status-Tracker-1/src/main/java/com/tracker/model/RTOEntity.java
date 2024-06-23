package com.tracker.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.ArrayList;

import java.util.List;
//  fda
import jakarta.persistence.*;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
 
@Data
public class RTOEntity {
    
	@Id
	private int empId;
    private String empName;
   
    private List<RTOData> rtoStatus;
    
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
 
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public List<RTOData> getRtoStatus() {
		return rtoStatus;
	}
	public void setRtoStatus(List<RTOData> rtoStatus) {
		this.rtoStatus = rtoStatus;
	}
	
}