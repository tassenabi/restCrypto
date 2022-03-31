package com.ann.restCrypto.configs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CredConfigsTest {

    @Autowired
    CredConfigs credConfigs;

    @Test
    void can_read_credentials(){
        assertThat(credConfigs.getApiKeyCoinmarket() != null).isTrue();
        assertThat(credConfigs.getApiKeyCryptoapis() != null).isTrue();

    }
}