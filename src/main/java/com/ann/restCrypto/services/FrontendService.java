package com.ann.restCrypto.services;

import com.ann.restCrypto.persistence.model.EtherumBo;
import com.ann.restCrypto.persistence.repositories.EthereumRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FrontendService {

    private final EthereumRepository ethereumRepository;

    public List<EtherumBo> getEthereumByDateIntervall(LocalDate fromDate, LocalDate untilDate) {

        return ethereumRepository.findAllByDateStampBetween(fromDate, untilDate);
    }

    public List<EtherumBo> getEthereumByDate(LocalDate date){

        return ethereumRepository.findAllByDateStamp(date);
    }

    public List<EtherumBo> getAllEthereum(){

        return ethereumRepository.findAll();
    }

    public EtherumBo getEtherumBy(ObjectId objectId){

        var ethereumBo = ethereumRepository.findBy(objectId);

        return ethereumBo.orElseThrow(() -> {throw new NoSuchElementException();});
    }
}