package com.ann.restCrypto.input;

import com.ann.restCrypto.persistence.model.EthereumData;

public class RestClientMapper {

    public static EthereumData toEthereumData(Integer sequentialNumber, String responseRestCall){

        EthereumData ethereumData = new EthereumData();

        ethereumData.setSequentialNumber(sequentialNumber);

        return ethereumData;
    }
}
