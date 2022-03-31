package com.ann.restCrypto.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class BitcoinData {

    private Integer priceUSD;
    private Integer amountOfCoins;
    private Integer marketCapUSD;
}