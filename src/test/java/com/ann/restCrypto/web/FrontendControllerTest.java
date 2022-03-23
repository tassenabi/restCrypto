package com.ann.restCrypto.web;

import com.ann.restCrypto.services.FrontendService;
import com.ann.restCrypto.util.EtherumFactory;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
class FrontendControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    FrontendService frontendService;

    private static final String URI_GET_ALL_ETHEREUMS = "/api/v1/etherum/all";
    private static final String URI_GET_ALL_ETHEREUMS_BY_DATE = "/api/v1/etherum/etherum/{fromDate}/{untilDate}";
    private static final String URI_GET_ALL_ETHEREUMS_BY_DATE_INTERVALL = "/api/v1/etherum/{date}";

    @Test
    void returnHttpOK_whenEthereumExists() throws Exception {

        //given
        when(frontendService.getAllEthereum()).thenReturn(EtherumFactory.createTwoEthereumBos());
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080" + URI_GET_ALL_ETHEREUMS);

        //when
        MvcResult result = mvc.perform(request).andReturn();

        //then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void returnHttpOK_whenEthereumByDateExists() throws Exception {

        //given
        when(frontendService.getEthereumByDate(any())).thenReturn(EtherumFactory.createTwoEthereumBos());
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080" + URI_GET_ALL_ETHEREUMS_BY_DATE);

        //when
        MvcResult result = mvc.perform(request).andReturn();

        //then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void returnHttpOK_whenEthereumExistsByDateIntervall() throws Exception {

        //given
        when(frontendService.getEthereumByDateIntervall(any(), any())).thenReturn(EtherumFactory.createTwoEthereumBos());
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080" + URI_GET_ALL_ETHEREUMS_BY_DATE_INTERVALL);

        //when
        MvcResult result = mvc.perform(request).andReturn();

        //then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}