package com.ann.restCrypto.util;

import com.ann.restCrypto.output.FrontendMapper;
import com.ann.restCrypto.output.dtos.EthereumDto;
import com.ann.restCrypto.persistence.model.*;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class EtherumFactory {

    public static final LocalDate DATE_ONE = LocalDate.of(2022, Month.JANUARY, 12);
    public static final LocalDate DATE_TWO = LocalDate.of(2022, Month.JANUARY, 11);

    public static EthereumDto createEthereumDto(){

        return FrontendMapper.toEthereumDto(createEthereumBo(new ObjectId()));

    }

    public static EthereumData createEthereumBo(ObjectId objectId) {

        EthereumData ethereumData = new EthereumData();

        ethereumData.setId(objectId);
        ethereumData.setSequentialNumber(1);
        ethereumData.setOwnWalletValueUSD(200);
        ethereumData.setPriceUSD(1000);
        ethereumData.setCoinsInCirculation(25);
        ethereumData.setMarketCapUSD(25000);
        ethereumData.setAmountOfTransactionsUSD(200);
        ethereumData.setVolumen24hUSD(200);
        ethereumData.setCountProjects(20);
        ethereumData.setBuy(200);
        ethereumData.setSell(100);
        BitcoinData bitcoinData = new BitcoinData(100, 100,100);
        ethereumData.setBitcoinData(bitcoinData);
        ethereumData.setDateStamp(LocalDate.now());

        return ethereumData;

    }

    public static List<EthereumData> createTwoEthereumBos() {

        List<EthereumData> etherumBos = new ArrayList<>();
        EthereumData etherumBoOne = EtherumFactory.createEthereumBo(new ObjectId());
        EthereumData etherumBoTwo = EtherumFactory.createEthereumBo(new ObjectId());
        etherumBoOne.setDateStamp(DATE_ONE);
        etherumBoTwo.setDateStamp(DATE_TWO);
        etherumBos.add(etherumBoOne);
        etherumBos.add(etherumBoTwo);

        return etherumBos;
    }
}