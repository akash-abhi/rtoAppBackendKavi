package com.tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tracker.exception.TaskNotFoundException;
import com.tracker.model.TaskEntity;
import com.tracker.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Override
	public String saveTask(TaskEntity task) {
		if (taskRepo.existsById(task.getTaskId())) {
			return "Task already exists. Please enter valid task id";
		} else {
			taskRepo.save(task);
			return "Task " + task.getTaskId() + " Added Successfully";
		}
	}

	@Override
	public List<TaskEntity> getAllTasks() {
		return taskRepo.findAll();
	}
	
	@Override
	public ResponseEntity<TaskEntity> getTaskByTaskName(String taskName) throws TaskNotFoundException{
		Optional<TaskEntity> result = taskRepo.findByTaskNameIgnoreCase(taskName);
		if (result.isPresent()) {
			TaskEntity taskEntity = result.get();
			return ResponseEntity.ok(taskEntity);
		} else {
			throw new TaskNotFoundException("Task " + taskName + " not found");
		}
	}



	@Override
	public String deleteTask(String taskName) {
        try {
            TaskEntity taskEntity = taskRepo.findByTaskNameIgnoreCase(taskName)
                    .orElseThrow(() -> new TaskNotFoundException("Task with name " + taskName + " not found"));
            
            taskRepo.delete(taskEntity);
            return "Task " + taskName + " deleted successfully";
        } catch (TaskNotFoundException e) {
            return "Task " + taskName + " not found";
        }

    }

	@Override
	public TaskEntity updateTask(String taskName, TaskEntity taskEntityRequest) throws TaskNotFoundException {
		TaskEntity taskEntity = taskRepo.findByTaskNameIgnoreCase(taskName)
					.orElseThrow(() -> new TaskNotFoundException("Task not found"));
		
		taskEntity.setTaskName(taskEntityRequest.getTaskName());
		taskEntity.setTaskStatus(taskEntityRequest.getTaskStatus());
		taskEntity.setCreatedDate(taskEntityRequest.getCreatedDate());
		taskEntity.setLastUpdatedDate(taskEntityRequest.getLastUpdatedDate());
		taskEntity.setTaskDescription(taskEntityRequest.getTaskDescription());
		return taskRepo.save(taskEntity);
		}
	}



