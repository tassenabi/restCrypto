package com.ann.restCrypto.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class ErrorRecord {

    @Id
    private ObjectId errorId;
    private String payload;
    private String error;
}
