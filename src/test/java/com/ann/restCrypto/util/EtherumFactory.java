package com.ann.restCrypto.util;

import com.ann.restCrypto.output.FrontendMapper;
import com.ann.restCrypto.output.dtos.EthereumDto;
import com.ann.restCrypto.persistence.model.*;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EtherumFactory {

    public static EthereumDto createEthereumDto(){

        return FrontendMapper.toEthereumDto(createEthereumBo(new ObjectId()));

    }

    public static EtherumBo createEthereumBo(ObjectId objectId) {

        EtherumBo etherumBo = new EtherumBo();
        etherumBo.setId(objectId);

        MarketCapBo marketCapBo = new MarketCapBo();
        marketCapBo.setMarketCapValue(999999d);

        RichListBo richListBo = new RichListBo();
        richListBo.setDateStamp(LocalDate.now());

        TransactionBo transactionBo= new TransactionBo();
        transactionBo.setTransactionVolumeEUR(500d);
        transactionBo.setTransactionVolumeAmount(10);

        Volume24HoursBo volume24HoursBo = new Volume24HoursBo();
        volume24HoursBo.setVolume24HoursEUR(300d);

        etherumBo.setMarketCapBo(marketCapBo);
        etherumBo.setRichListBo(richListBo);
        etherumBo.setTransactionBo(transactionBo);
        etherumBo.setVolumenTwentyFourHoursBo(volume24HoursBo);

        return etherumBo;

    }

    public static List<EtherumBo> createTwoEthereumBos() {

        List<EtherumBo> etherumBos = new ArrayList<>();
        EtherumBo etherumBoOne = EtherumFactory.createEthereumBo(new ObjectId());
        EtherumBo etherumBoTwo = EtherumFactory.createEthereumBo(new ObjectId());
        etherumBos.add(etherumBoOne);
        etherumBos.add(etherumBoTwo);

        return etherumBos;
    }
}
