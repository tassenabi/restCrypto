package com.ann.restCrypto.input;

import com.ann.restCrypto.input.clients.BasicRestCall;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestClientService {

    private final BasicRestCall basicRestCall;

    String btcUri = "https://api.blockchain.com/v3/exchange/tickers/BTC-USD";
    String ethUri = "https://api.blockchain.com/v3/exchange/tickers/ETH-USD";

    public void callThemAll(){
        //basicRestCall.callApi(btcUri);
    }

}