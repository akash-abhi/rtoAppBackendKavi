package com.tracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.EmployeeEntity;
import com.tracker.model.RTOEntity;
@Repository
public interface RTORepository extends MongoRepository<RTOEntity, Integer>{
	
	RTOEntity findByEmpId(int empId);
 
	Optional<RTOEntity> findByEmpNameIgnoreCase(String empName);
 
}