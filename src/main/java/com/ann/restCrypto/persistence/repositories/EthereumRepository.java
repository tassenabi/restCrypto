package com.ann.restCrypto.persistence.repositories;

import com.ann.restCrypto.persistence.model.EtherumBo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EthereumRepository extends MongoRepository<EtherumBo, ObjectId> {

    List<EtherumBo> findAllByDateStampBetween(LocalDate from, LocalDate to);

    List<EtherumBo> findAllByDateStamp(LocalDate date);

    Optional<EtherumBo> findBy(ObjectId objectId);
}