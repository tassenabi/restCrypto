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
public class EthereumData implements Serializable {

    @Id
    private ObjectId id;
    private Integer sequentialNumber;
    private Integer ownWalletValueUSD;
    private Integer priceUSD;
    private Integer CoinsInCirculation;
    private Integer marketCapUSD;
    private Integer amountOfTransactionsUSD;
    private Integer volumen24hUSD;
    private Integer countProjects;
    private Integer buy;
    private Integer sell;
    private BitcoinData bitcoinData;
    private LocalDate dateStamp;
}


