package com.tracker.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
	
	private int empId;
	private String empName;
	private String emailId;
	private String role;
	private String baselocation;
	private List<TaskEntity > tasks = new ArrayList<>();
	
	public EmployeeDTO(int i, String string, String string2, String string3, String string4,List<TaskEntity > tasks) {
		// TODO Auto-generated constructor stub
	}
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
	public String getBaselocation() {
		return baselocation;
	}
	public void setBaselocation(String baselocation) {
		this.baselocation = baselocation;
	}
	public List<TaskEntity> getTasks() {
		return tasks;
	}
	public void setTasks(List<TaskEntity> tasks) {
		this.tasks = tasks;
	}
	
	

	
}