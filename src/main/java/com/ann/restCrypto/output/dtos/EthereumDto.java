package com.ann.restCrypto.output.dtos;

public record EthereumDto(MarketCapDto marketCapDto, RichListDto richListDto,
                          TransactionDto transactionDto, Volume24HoursDto volume24HoursDto) {
}