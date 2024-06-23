package com.tracker.model;

import java.util.ArrayList;


import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data; 
import lombok.Getter;


@Getter
@Data
@Entity
public class EmployeeEntity {
	
	
	
	@Id
	private Integer empId;
	
	private String empName;
	
	private String emailId;
	
	private String role;
	
	private String onshorePOC;
	
	private String offshorePOC;
	
	private String baselocation;
	
	private String password;
	
	
	private List<TaskEntity> tasks = new ArrayList<>();

	public EmployeeEntity(Integer int1, String string2, String string3, 
			String string4, String string5, String string6,
			String string7, String string8) {
		// TODO Auto-generated constructor stub
	}

	public EmployeeEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getOnshorePOC() {
		return onshorePOC;
	}

	public void setOnshorePOC(String onshorePOC) {
		this.onshorePOC = onshorePOC;
	}

	public String getOffshorePOC() {
		return offshorePOC;
	}

	public void setOffshorePOC(String offshorePOC) {
		this.offshorePOC = offshorePOC;
	}

	public String getBaselocation() {
		return baselocation;
	}

	public void setBaselocation(String baselocation) {
		this.baselocation = baselocation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TaskEntity> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskEntity> tasks) {
		this.tasks = tasks;
	}

	
}