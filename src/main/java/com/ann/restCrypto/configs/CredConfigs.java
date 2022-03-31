package com.ann.restCrypto.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CredConfigs {

    @Value("${coinmarket.apikey}")
    private String apiKeyCoinmarket;

    @Value("${cryptoapis.apikey}")
    private String apiKeyCryptoapis;

    public String getApiKeyCoinmarket(){
        return apiKeyCoinmarket;
    }

    public String getApiKeyCryptoapis() { return apiKeyCryptoapis; }
}