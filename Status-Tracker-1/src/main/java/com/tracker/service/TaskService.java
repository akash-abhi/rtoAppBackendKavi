package com.tracker.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tracker.exception.TaskNotFoundException;
import com.tracker.model.TaskEntity;

@Service
public interface TaskService {
	
    public List<TaskEntity> getAllTasks();
	
	public String saveTask(TaskEntity task);

	public ResponseEntity<TaskEntity> getTaskByTaskName(String taskName) throws TaskNotFoundException;

	public String deleteTask(String taskName);
	
	TaskEntity updateTask(String taskName, TaskEntity taskEntity) throws TaskNotFoundException;


}
