package com.ann.restCrypto.web;

import com.ann.restCrypto.persistence.model.EtherumBo;
import com.ann.restCrypto.services.FrontendService;
import com.ann.restCrypto.util.EtherumFactory;
import org.bson.types.ObjectId;
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

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
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

    private static final String URI_GET_ALL_ETHEREUMS = "/api/v1/eth/all";
    private static final String URI_GET_ALL_ETHEREUMS_BY_DATE = "/api/v1/eth/{date}";
    private static final String URI_GET_ALL_ETHEREUMS_BY_DATE_INTERVALL = "/api/v1/eth/{fromDate}/{untilDate}";
    private static final String URI_GET_ETHEREUM_BY_OBJECTID = "/api/v1/eth/id/{id}";

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
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080" + URI_GET_ALL_ETHEREUMS_BY_DATE, "2022-03-26");

        //when
        MvcResult result = mvc.perform(request).andReturn();

        //then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void returnHttpOK_whenEthereumExistsByDateIntervall() throws Exception {

        //given
        when(frontendService.getEthereumByDateIntervall(any(), any())).thenReturn(EtherumFactory.createTwoEthereumBos());
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080" + URI_GET_ALL_ETHEREUMS_BY_DATE_INTERVALL, "2022-03-25", "2022-03-26");

        //when
        MvcResult result = mvc.perform(request).andReturn();

        //then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void returnsHttpOK_whenEthereumExistsByObjectId() throws Exception {

        //given
        var newObjectId = new ObjectId();
        EtherumBo ethereumBo = EtherumFactory.createEthereumBo(newObjectId);
        when(frontendService.getEtherumBy(any())).thenReturn(ethereumBo);
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080" + URI_GET_ETHEREUM_BY_OBJECTID, newObjectId.toString());

        //when
        MvcResult result = mvc.perform(request).andReturn();

        //then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void returnsHttpNotFound_whenEthereumNotExistsByObjectId() throws Exception {

        //given
        var objectId = new ObjectId();
        when(frontendService.getEtherumBy(eq(objectId)))
                .thenThrow(new NoSuchElementException());

        RequestBuilder request = MockMvcRequestBuilders.get(URI_GET_ETHEREUM_BY_OBJECTID, objectId);

        //when
        MvcResult result = mvc.perform(request).andReturn();

        //then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());

    }
}