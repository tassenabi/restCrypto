package com.ann.restCrypto.web;

import com.ann.restCrypto.output.FrontendMapper;
import com.ann.restCrypto.output.dtos.EthereumDto;
import com.ann.restCrypto.persistence.model.EtherumBo;
import com.ann.restCrypto.services.FrontendService;
import com.ann.restCrypto.util.CommonUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
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

    @GetMapping("/eth/{fromDate}/{untilDate}")
    public ResponseEntity<List<EthereumDto>> getAllEthereumByDateIntervall(@PathVariable String fromDate, @PathVariable String untilDate){

        //20220325 -> 2022-03-25
        LocalDate localDateFrom = CommonUtils.convertStringToDate(fromDate);
        LocalDate localDateUntil = CommonUtils.convertStringToDate(untilDate);
            List<EtherumBo> ethereumBos = this.frontendService.getEthereumByDateIntervall(localDateFrom, localDateUntil);
            var response = ethereumBos.stream()
                    .map(FrontendMapper::toEthereumDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(response);
    }

    @GetMapping("/eth/{date}")
    public ResponseEntity<List<EthereumDto>> getAllEthereumByDate(@PathVariable String date){

        //20220325 -> 2022-03-25
        LocalDate localDate = CommonUtils.convertStringToDate(date);

        List<EtherumBo> etherumBos = this.frontendService.getEthereumByDate(localDate);
        var response = etherumBos.stream()
                .map(FrontendMapper::toEthereumDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/eth/all")
    public ResponseEntity<List<EthereumDto>> getAllEthereum(){

        List<EtherumBo> etherumBos = this.frontendService.getAllEthereum();
        var response = etherumBos.stream()
                .map(FrontendMapper::toEthereumDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/eth/id/{id}")
    public ResponseEntity<EthereumDto> getEthereumBy(@PathVariable String id){

        try {
            ObjectId objectId = CommonUtils.objectIdFromString(id);
            var etherumBo = this.frontendService.getEtherumBy(objectId);

            var response = FrontendMapper.toEthereumDto(etherumBo);
            return ResponseEntity.ok(response);
        } catch(NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}