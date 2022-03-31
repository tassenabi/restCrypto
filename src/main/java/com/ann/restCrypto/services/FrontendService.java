package com.ann.restCrypto.services;

import com.ann.restCrypto.persistence.model.EthereumData;
import com.ann.restCrypto.persistence.repositories.EthereumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FrontendService {

    private final EthereumRepository ethereumRepository;

    public List<EthereumData> getEthereumByDateAfter(LocalDate date){

        return ethereumRepository.findAllByDateStampIsAfter(date);
    }

    public List<EthereumData> getAllEthereumAndReplaceAmountOfEtherFromNow(Integer amountOfEther){

        List<EthereumData> allEthereum = ethereumRepository.findAll();

        Integer highestSequentialNumber = allEthereum.stream().
                mapToInt(EthereumData::getSequentialNumber)
                .max().orElseThrow(NoSuchElementException::new);

        allEthereum.stream()
                .filter(x -> x.getSequentialNumber().equals(highestSequentialNumber))
                .forEach(y -> y.setOwnWalletValueUSD(amountOfEther));

        return allEthereum;
    }
}