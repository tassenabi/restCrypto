package com.ann.restCrypto.persistence.repositories;

import com.ann.restCrypto.persistence.model.EthereumData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EthereumRepository extends MongoRepository<EthereumData, ObjectId> {

    List<EthereumData> findAllByDateStampIsAfter(LocalDate until);

    Optional<EthereumData> findByDateStamp(LocalDate date);

}