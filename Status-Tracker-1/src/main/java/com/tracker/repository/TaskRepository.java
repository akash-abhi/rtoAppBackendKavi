package com.tracker.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.TaskEntity;

@Repository
public interface TaskRepository extends MongoRepository<TaskEntity, Integer>{

	Optional<TaskEntity> findByTaskId(int taskId);

	Optional<TaskEntity> findByTaskNameIgnoreCase(String taskName);

}
