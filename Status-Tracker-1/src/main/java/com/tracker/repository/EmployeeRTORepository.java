package com.tracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tracker.model.UserRtoEntity;

public interface EmployeeRTORepository extends MongoRepository<UserRtoEntity,Integer>{
	

}
