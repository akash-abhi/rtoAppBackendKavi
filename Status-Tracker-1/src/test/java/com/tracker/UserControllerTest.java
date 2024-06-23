package com.tracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.tracker.model.EmployeeEntity;
import com.tracker.model.TaskEntity;
import com.tracker.repository.TaskRepository;
import com.tracker.service.TaskServiceImpl;

public class UserControllerTest {
	
    @Mock
    private TaskRepository taskRepo;
 
    @InjectMocks
    private TaskServiceImpl taskService;
    
    @BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

    @Test
    void testGetAllTaskDetails() {
        LocalDate date = LocalDate.of(2023, 10, 10);
        LocalDate dueDate = LocalDate.of(2023, 10, 20);
        List<TaskEntity> mockTaskEntities = Arrays.asList(
                new TaskEntity(101, "Backend", "In Progress", date, dueDate, "Working on backend part for the use case"),
                new TaskEntity(102, "Backend", "In Progress", date, dueDate, "Working on backend part for the use case")
        );
        when(taskRepo.findAll()).thenReturn(mockTaskEntities);
        List<TaskEntity> result = taskService.getAllTasks();
        assertEquals(mockTaskEntities, result);
    }
    
    @Test
	void saveDetails_taskDoesNotExist() {
		TaskEntity newTask = new TaskEntity();
		newTask.setTaskId(2);
		when(taskRepo.existsById(anyInt())).thenReturn(false);
		String result = taskService.saveTask(newTask);
		assertEquals("Task 2 Added Successfully", result);
		Mockito.verify(taskRepo, Mockito.times(1)).save(newTask);
	}
	
    @Test
	void saveDetails_employeeExists() {
		TaskEntity existingTask = new TaskEntity();
		existingTask.setTaskId(1);
		when(taskRepo.existsById(anyInt())).thenReturn(true);
		String result = taskService.saveTask(existingTask);
		assertEquals("Task already exists. Please enter valid task id", result);
		Mockito.verify(taskRepo, Mockito.never()).save(existingTask);
	}

}
