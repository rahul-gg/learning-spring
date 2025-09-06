package com.spring_advanced.spring_advanced.repository;

import com.spring_advanced.spring_advanced.Journal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends MongoRepository<Journal, ObjectId > {
}
