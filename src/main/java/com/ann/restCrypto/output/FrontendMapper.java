package com.ann.restCrypto.output;

import com.ann.restCrypto.output.dtos.*;
import com.ann.restCrypto.persistence.model.EthereumData;

public final class FrontendMapper {

    private FrontendMapper(){

    }

    public static EthereumDto toEthereumDto(EthereumData etherumBo){

        BitcoinDto bitcoinDto = getBitcoinDto(etherumBo);

        return new EthereumDto(etherumBo.getSequentialNumber(), etherumBo.getOwnWalletValueUSD(), etherumBo.getPriceUSD(), etherumBo.getCoinsInCirculation(),
                etherumBo.getMarketCapUSD()
                , etherumBo.getAmountOfTransactionsUSD(), etherumBo.getVolumen24hUSD(),
                etherumBo.getCountProjects(), etherumBo.getBuy() , etherumBo.getSell(), bitcoinDto, etherumBo.getDateStamp());
    }

    private static BitcoinDto getBitcoinDto(EthereumData ethereumData) {

        var bitcoinDto = ethereumData.getBitcoinData();
        return new BitcoinDto(bitcoinDto.getPriceUSD(), bitcoinDto.getAmountOfCoins(), bitcoinDto.getMarketCapUSD());
    }
}