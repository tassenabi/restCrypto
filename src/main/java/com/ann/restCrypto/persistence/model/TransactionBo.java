package com.ann.restCrypto.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class TransactionBo {

    private Double transactionVolumeEUR;
    private Integer transactionVolumeAmount;

}
