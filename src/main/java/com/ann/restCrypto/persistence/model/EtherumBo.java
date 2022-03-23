package com.ann.restCrypto.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Document
public class EtherumBo implements Serializable {

    @Id
    private ObjectId id;
    private MarketCapBo marketCapBo;
    private RichListBo richListBo;
    private TransactionBo transactionBo;
    private Volume24HoursBo volumenTwentyFourHoursBo;
    private LocalDate dateStamp;
}
