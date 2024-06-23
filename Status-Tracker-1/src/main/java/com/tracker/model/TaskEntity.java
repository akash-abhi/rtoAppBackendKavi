package com.tracker.model;


import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
	
	@Id
	private int taskId;
	
	private String taskName;
	
	private String taskStatus;
	
    @Column(name = "date")
	private LocalDate createdDate;
	
    @Column(name = "date")
	private LocalDate lastUpdatedDate;
    
	private String taskDescription;
	
	
	public TaskEntity(int taskId, String taskName, String taskStatus, LocalDate createdDate, LocalDate lastUpdatedDate,
			String taskDescription) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskStatus = taskStatus;
		this.createdDate = createdDate;
		this.lastUpdatedDate = lastUpdatedDate;
		this.taskDescription = taskDescription;
	}
	
	public TaskEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}	

}
