package com.ann.restCrypto.output;

import com.ann.restCrypto.util.EtherumFactory;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FrontendMapperTest {

    @Test
    void can_map_to_EthereumDto(){

        //given
        var ethereumData = EtherumFactory.createEthereumBo(new ObjectId());

        //when
        var ethereumDto = FrontendMapper.toEthereumDto(ethereumData);

        //then
        assertThat(ethereumData.getSequentialNumber()).isEqualTo(ethereumDto.sequentialNumber());
        assertThat(ethereumData.getPriceUSD()).isEqualTo(ethereumDto.pricePerEtherUSD());
        assertThat(ethereumData.getCoinsInCirculation()).isEqualTo(ethereumDto.coinsInCirculation());
        assertThat(ethereumData.getMarketCapUSD()).isEqualTo(ethereumDto.marketCapUSD());
        assertThat(ethereumData.getAmountOfTransactionsUSD()).isEqualTo(ethereumDto.amountOfTransactionsUSD());
        assertThat(ethereumData.getVolumen24hUSD()).isEqualTo(ethereumDto.volumen24hUSD());
        assertThat(ethereumData.getCountProjects()).isEqualTo(ethereumDto.countProjects());
        assertThat(ethereumData.getBuy()).isEqualTo(ethereumDto.buy());
        assertThat(ethereumData.getSell()).isEqualTo(ethereumDto.sell());
        assertThat(ethereumData.getDateStamp()).isEqualTo(ethereumDto.dateStamp());

        assertThat(ethereumData.getBitcoinData().getAmountOfCoins()).isEqualTo(ethereumDto.bitcoinData().amountOfCoins());
        assertThat(ethereumData.getBitcoinData().getMarketCapUSD()).isEqualTo(ethereumDto.bitcoinData().marketCapUSD());
        assertThat(ethereumData.getBitcoinData().getPriceUSD()).isEqualTo(ethereumDto.bitcoinData().priceUSD());
    }
}