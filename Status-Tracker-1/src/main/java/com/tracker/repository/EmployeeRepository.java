package com.tracker.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.EmployeeEntity;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeEntity, Integer>{
	
//	EmployeeEntity save(EmployeeEntity employee);

	Optional<EmployeeEntity> findByEmpNameIgnoreCase(String empName);

	Optional<EmployeeEntity> findByEmpId(int empId);




}
