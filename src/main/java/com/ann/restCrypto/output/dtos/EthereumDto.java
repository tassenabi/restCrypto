package com.ann.restCrypto.output.dtos;

import java.time.LocalDate;

public record EthereumDto(Integer sequentialNumber,
        Integer ownWalletValueUSD,
        Integer pricePerEtherUSD,
        Integer coinsInCirculation,
        Integer marketCapUSD,
        Integer amountOfTransactionsUSD,
        Integer volumen24hUSD,
        Integer countProjects,
        Integer buy,
        Integer sell,
        BitcoinDto bitcoinData,
        LocalDate dateStamp) {
}