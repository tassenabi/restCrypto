package com.ann.restCrypto.output;

import com.ann.restCrypto.output.dtos.*;
import com.ann.restCrypto.persistence.model.EtherumBo;

public final class FrontendMapper {

    private FrontendMapper(){

    }

    public static EthereumDto toEthereumDto(EtherumBo etherumBo){

        MarketCapDto marketCapDto = getMarketCapDto(etherumBo);
        RichListDto richListDto = getRichListDto(etherumBo);
        TransactionDto transactionDto = getTransactionDto(etherumBo);
        Volume24HoursDto volume24HoursDto = getVolume24HoursDto(etherumBo);

        return new EthereumDto(marketCapDto, richListDto,
                transactionDto, volume24HoursDto);
    }

    private static Volume24HoursDto getVolume24HoursDto(EtherumBo etherumBo) {
        var volume24HoursBo = etherumBo.getVolumenTwentyFourHoursBo();
        return new Volume24HoursDto(volume24HoursBo.getVolume24HoursEUR());
    }

    private static TransactionDto getTransactionDto(EtherumBo etherumBo) {
        var transactionBo = etherumBo.getTransactionBo();
        return new TransactionDto(transactionBo.getTransactionVolumeEUR(), transactionBo.getTransactionVolumeAmount());
    }

    private static RichListDto getRichListDto(EtherumBo etherumBo) {
        var richListBo = etherumBo.getRichListBo();
        return new RichListDto(richListBo.getDateStamp());
    }

    private static MarketCapDto getMarketCapDto(EtherumBo etherumBo) {
        var marketCapBo = etherumBo.getMarketCapBo();
        return new MarketCapDto(marketCapBo.getMarketCapValue());
    }
}