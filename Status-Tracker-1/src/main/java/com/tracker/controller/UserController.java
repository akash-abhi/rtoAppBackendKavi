package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.exception.TaskNotFoundException;
import com.tracker.model.TaskEntity;
import com.tracker.service.TaskService;




@CrossOrigin(origins="*")
@RequestMapping("/status-tracker/user")
@RestController
public class UserController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/get/allTaskss")
	public String getAllTaskDetailss() {
		return "For you";
		
	}
	
	@GetMapping("/get/allTasks")
	public List<TaskEntity> getAllTaskDetails() {
		return taskService.getAllTasks();
	}

    @PostMapping("/add/taskDetails")
    public TaskEntity saveTasks( @RequestBody TaskEntity task){
         taskService.saveTask(task);
         return task;
    }
    
    @GetMapping("/get/task/name/{taskName}")
    public ResponseEntity<TaskEntity> getTask(@PathVariable String taskName) throws TaskNotFoundException{
        return taskService.getTaskByTaskName(taskName);	
        }
    
    @PutMapping("/update/taskDetails/{taskName}")  
    public TaskEntity updateTaskEntity(@PathVariable String taskName, @RequestBody TaskEntity taskEntity) throws TaskNotFoundException {
		return taskService.updateTask(taskName, taskEntity);
	}
    
    @DeleteMapping("/delete/task/{taskName}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String taskName) throws TaskNotFoundException{ 
    	return ResponseEntity.ok(taskService.deleteTask(taskName)); 
    	}
}
