package com.ann.restCrypto.output;

import com.ann.restCrypto.util.EtherumFactory;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FrontendMapperTest {

    @Test
    void can_map_to_EthereumDto(){

        //given
        var ethereumBo = EtherumFactory.createEthereumBo(new ObjectId());

        //when
        var ethereumDto = FrontendMapper.toEthereumDto(ethereumBo);

        //then
        assertThat(ethereumBo.getMarketCapBo().getMarketCapValue()).isEqualTo(ethereumDto.marketCapDto().marketCapValue());
        assertThat(ethereumBo.getRichListBo().getDateStamp()).isEqualTo(ethereumDto.richListDto().dateStamp());
        assertThat(ethereumBo.getTransactionBo().getTransactionVolumeEUR()).isEqualTo(ethereumDto.transactionDto().transactionVolumeEUR());
        assertThat(ethereumBo.getTransactionBo().getTransactionVolumeAmount()).isEqualTo(ethereumDto.transactionDto().transactionVolumeAmount());
        assertThat(ethereumBo.getVolumenTwentyFourHoursBo().getVolume24HoursEUR()).isEqualTo(ethereumDto.volume24HoursDto().volume24HoursEUR());

    }
}