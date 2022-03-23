package com.ann.restCrypto.persistence.repositories;

import com.ann.restCrypto.persistence.model.ErrorRecord;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorRecordRepository extends MongoRepository<ErrorRecord, ObjectId> {
}