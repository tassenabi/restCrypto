package com.ann.restCrypto.web;

import com.ann.restCrypto.output.FrontendMapper;
import com.ann.restCrypto.output.dtos.EthereumDto;
import com.ann.restCrypto.persistence.model.EthereumData;
import com.ann.restCrypto.services.FrontendService;
import com.ann.restCrypto.util.CommonUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class FrontendController {

    private final FrontendService frontendService;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(FrontendController.class);

    @Autowired
    public FrontendController(FrontendService frontendService){
        this.frontendService = frontendService;
    }

    @GetMapping("/eth/fromDate/{fromDate}")
    public ResponseEntity<List<EthereumDto>> getAllEthereumByDateAfter(@PathVariable String fromDate){

        //20220325 -> 2022-03-25
        LocalDate localDateFrom = CommonUtils.convertStringToDate(fromDate);
        List<EthereumData> ethereumBos = this.frontendService.getEthereumByDateAfter(localDateFrom);
        var response = ethereumBos.stream()
                .map(FrontendMapper::toEthereumDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/eth/all/{amountOfEther}")
    public ResponseEntity<List<EthereumDto>> getAllEthereum(@PathVariable Integer amountOfEther){

        List<EthereumData> etherumBos = this.frontendService.getAllEthereumAndReplaceAmountOfEtherFromNow(amountOfEther);
        var response = etherumBos.stream()
                .map(FrontendMapper::toEthereumDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}