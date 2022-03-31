package com.ann.restCrypto.input.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CredConfigs {

    @Value("${coinmarket.apikey}")
    private String apiKey;

    public String getApiKey(){
        return apiKey;
    }
}