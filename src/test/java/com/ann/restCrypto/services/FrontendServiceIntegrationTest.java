package com.ann.restCrypto.services;

import com.ann.restCrypto.persistence.repositories.EthereumRepository;
import com.ann.restCrypto.util.EtherumFactory;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
class FrontendServiceTest {

    @Autowired
    EthereumRepository ethereumRepository;

    @Autowired
    FrontendService frontendService;

    @AfterEach
    void cleanUp() {ethereumRepository.deleteAll();}

    @Test
    void find_EthereumBo_if_existing(){

        //given
        var originalEthereumId = new ObjectId();
        var ethereum = EtherumFactory.createEthereumBo(originalEthereumId);
        ethereumRepository.save(ethereum);

        //when
        var expectedEthereumBo = frontendService.getEtherumBy(originalEthereumId);

        //then
        assertThat(expectedEthereumBo).isEqualTo(ethereum);
    }
}