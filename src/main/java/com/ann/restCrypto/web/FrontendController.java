package com.ann.restCrypto.web;

import com.ann.restCrypto.output.FrontendMapper;
import com.ann.restCrypto.output.dtos.EthereumDto;
import com.ann.restCrypto.persistence.model.EtherumBo;
import com.ann.restCrypto.services.FrontendService;
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

    @GetMapping("/etherum/{fromDate}/{untilDate}")
    public ResponseEntity<List<EthereumDto>> getAllEthereumByDateIntervall(@PathVariable LocalDate fromDate, @PathVariable LocalDate untilDate){

            List<EtherumBo> ethereumBos = this.frontendService.getEthereumByDateIntervall(fromDate, untilDate);
            var response = ethereumBos.stream()
                    .map(FrontendMapper::toEthereumDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(response);
    }

    @GetMapping("/etherum/{date}")
    public ResponseEntity<List<EthereumDto>> getAllEthereumByDate(@PathVariable LocalDate date){

        List<EtherumBo> etherumBos = this.frontendService.getEthereumByDate(date);
        var response = etherumBos.stream()
                .map(FrontendMapper::toEthereumDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/etherum/all")
    public ResponseEntity<List<EthereumDto>> getAllEthereum(){

        List<EtherumBo> etherumBos = this.frontendService.getAllEthereum();
        var response = etherumBos.stream()
                .map(FrontendMapper::toEthereumDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}