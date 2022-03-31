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

import java.util.Collections;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
class FrontendServiceIntegrationTest {

    @Autowired
    EthereumRepository ethereumRepository;

    @Autowired
    FrontendService frontendService;

    @AfterEach
    void cleanUp() {ethereumRepository.deleteAll();}

    @Test
    void find_EthereumBo_if_existing_withRepository_by_ObjectId(){

        //given
        var originalEthereumId = new ObjectId();
        var ethereum = EtherumFactory.createEthereumBo(originalEthereumId);
        ethereumRepository.save(ethereum);

        //when
        var expectedEthereumBo = ethereumRepository.findById(originalEthereumId);

        //then
        assertThat(expectedEthereumBo.get()).isEqualTo(ethereum);
    }

    @Test
    void find_EthereumBo_if_not_existing(){

        //given
        var originalEthereumId = new ObjectId();
        var ethereum = EtherumFactory.createEthereumBo(originalEthereumId);
        ethereumRepository.save(ethereum);

        //when
        var expectedEthereumBo = ethereumRepository.findById(new ObjectId());

        //then
        assertThat(expectedEthereumBo).isEmpty();

        /**
        Exception exceptionNullParameter = assertThrows(
                RuntimeException.class,
                () -> ethereumRepository.findById(new ObjectId()));

         **/
    }

    @Test
    void find_All_EthereumBo_if_existing(){

        //given
        var ethereum = EtherumFactory.createTwoEthereumBos();
        ethereumRepository.saveAll(ethereum);

        //when
        var expectedEthereumBo = frontendService.getAllEthereumAndReplaceAmountOfEtherFromNow(200);

        //then
        assertThat(expectedEthereumBo).isEqualTo(ethereum);
    }

    @Test
    void find_All_EthereumBo_if_existing_And_Overwrite_OwnWalletUSDValue(){

        //given
        var ethereum = EtherumFactory.createTwoEthereumBos();
        ethereum.get(1).setSequentialNumber(2);
        ethereumRepository.saveAll(ethereum);

        //when
        var ethereumData = frontendService.getAllEthereumAndReplaceAmountOfEtherFromNow(300);

        //then
        assertThat(ethereumData.get(1).getSequentialNumber()).isEqualTo(ethereum.get(1).getSequentialNumber());
        assertThat(ethereumData.get(1).getPriceUSD()).isEqualTo(ethereum.get(1).getPriceUSD());
        assertThat(ethereumData.get(1).getCoinsInCirculation()).isEqualTo(ethereum.get(1).getCoinsInCirculation());
        assertThat(ethereumData.get(1).getMarketCapUSD()).isEqualTo(ethereum.get(1).getMarketCapUSD());
        assertThat(ethereumData.get(1).getAmountOfTransactionsUSD()).isEqualTo(ethereum.get(1).getAmountOfTransactionsUSD());
        assertThat(ethereumData.get(1).getVolumen24hUSD()).isEqualTo(ethereum.get(1).getVolumen24hUSD());
        assertThat(ethereumData.get(1).getCountProjects()).isEqualTo(ethereum.get(1).getCountProjects());
        assertThat(ethereumData.get(1).getBuy()).isEqualTo(ethereum.get(1).getBuy());
        assertThat(ethereumData.get(1).getSell()).isEqualTo(ethereum.get(1).getSell());
        assertThat(ethereumData.get(1).getDateStamp()).isEqualTo(ethereum.get(1).getDateStamp());

        assertThat(ethereumData.get(1).getBitcoinData().getAmountOfCoins()).isEqualTo(ethereum.get(1).getBitcoinData().getAmountOfCoins());
        assertThat(ethereumData.get(1).getBitcoinData().getMarketCapUSD()).isEqualTo(ethereum.get(1).getBitcoinData().getMarketCapUSD());
        assertThat(ethereumData.get(1).getBitcoinData().getPriceUSD()).isEqualTo(ethereum.get(1).getBitcoinData().getPriceUSD());

        assertThat(ethereumData.get(0).getSequentialNumber()).isEqualTo(ethereum.get(0).getSequentialNumber());
        assertThat(ethereumData.get(0).getPriceUSD()).isEqualTo(ethereum.get(0).getPriceUSD());
        assertThat(ethereumData.get(0).getCoinsInCirculation()).isEqualTo(ethereum.get(0).getCoinsInCirculation());
        assertThat(ethereumData.get(0).getMarketCapUSD()).isEqualTo(ethereum.get(0).getMarketCapUSD());
        assertThat(ethereumData.get(0).getAmountOfTransactionsUSD()).isEqualTo(ethereum.get(0).getAmountOfTransactionsUSD());
        assertThat(ethereumData.get(0).getVolumen24hUSD()).isEqualTo(ethereum.get(0).getVolumen24hUSD());
        assertThat(ethereumData.get(0).getCountProjects()).isEqualTo(ethereum.get(0).getCountProjects());
        assertThat(ethereumData.get(0).getBuy()).isEqualTo(ethereum.get(0).getBuy());
        assertThat(ethereumData.get(0).getSell()).isEqualTo(ethereum.get(0).getSell());
        assertThat(ethereumData.get(0).getDateStamp()).isEqualTo(ethereum.get(0).getDateStamp());

        assertThat(ethereumData.get(0).getBitcoinData().getAmountOfCoins()).isEqualTo(ethereum.get(0).getBitcoinData().getAmountOfCoins());
        assertThat(ethereumData.get(0).getBitcoinData().getMarketCapUSD()).isEqualTo(ethereum.get(0).getBitcoinData().getMarketCapUSD());
        assertThat(ethereumData.get(0).getBitcoinData().getPriceUSD()).isEqualTo(ethereum.get(0).getBitcoinData().getPriceUSD());
    }

    @Test
    void find_AllEthereumBo_if_not_existing() {

        //given & when
        var expectedEthereumBo = frontendService.getAllEthereumAndReplaceAmountOfEtherFromNow(200);

        //then
        assertThat(expectedEthereumBo).isEqualTo(Collections.emptyList());

    }

    /**
    @Ignore
    @Test
    void find_All_EthereumBo_ByAfterdate_if_existing(){

        //given
        var originalEthereumId = new ObjectId();
        var ethereum = EtherumFactory.createTwoEthereumBos(true);
        ethereumRepository.saveAll(ethereum);

        //when
        var expectedEthereumBos = frontendService.getEthereumByDateAfter(EtherumFactory.FROM_DATE);

        //then

        assertThat(expectedEthereumBos.get(0)).isEqualTo(ethereum.get(0));
    }
**/
}