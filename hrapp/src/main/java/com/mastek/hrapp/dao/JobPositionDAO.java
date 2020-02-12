package com.mastek.hrapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.JobPosition;
@Repository//mark the class as repository
public interface JobPositionDAO extends MongoRepository<JobPosition, Integer>{ //map the document and identifier with mongorepository

}
