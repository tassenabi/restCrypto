package com.ann.restCrypto.web;

import com.ann.restCrypto.services.FrontendService;
import com.ann.restCrypto.util.EtherumFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataMongo
class FrontendControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    FrontendService frontendService;

    private static final String URI_GET_ALL_ETHEREUMS = "/api/v1/eth/all/{amountOfEther}";
    private static final String URI_GET_ETHEREUM_BY_AFTERDATE = "/api/v1/eth/fromDate/{fromDate}";

    @Test
    void returnHttpOK_whenEthereumExists() throws Exception {

        //given
        when(frontendService.getAllEthereumAndReplaceAmountOfEtherFromNow(any())).thenReturn(EtherumFactory.createTwoEthereumBos());
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080" + URI_GET_ALL_ETHEREUMS, 1);

        //when
        MvcResult result = mvc.perform(request).andReturn();

        //then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void returnHttpOK_whenEthereumByAfterdateFromExists() throws Exception {

        //given
        when(frontendService.getEthereumByDateAfter(any())).thenReturn(EtherumFactory.createTwoEthereumBos());
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080" + URI_GET_ETHEREUM_BY_AFTERDATE, "2022-03-25");

        //when
        MvcResult result = mvc.perform(request).andReturn();

        //then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}