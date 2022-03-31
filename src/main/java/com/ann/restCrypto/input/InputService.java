package com.ann.restCrypto.input;

import com.ann.restCrypto.persistence.model.EthereumData;
import com.ann.restCrypto.persistence.repositories.EthereumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class InputService {

    @Autowired
    private final EthereumRepository ethereumRepository;

    @Autowired
    private final RestClientDatasaver restClientDatasaver;

    //@Scheduled(cron = "0 15 10 16 * ?") -> executed at 10:15 AM on the 16th day of every month
    @Scheduled(cron = "* * */1 * * ?")
    public void saveEthereumEveryDay(){

        Integer newSequentialNumber = this.getHighestSequentialNumberInDatabase() +1;

        String response = restClientDatasaver.getRestcall();
        EthereumData ethereumData = RestClientMapper.toEthereumData(newSequentialNumber, response);

        ethereumRepository.save(ethereumData);

    }

    private Integer getHighestSequentialNumberInDatabase() {

        List<EthereumData> allExistingEthereumData = ethereumRepository.findAll();

        return allExistingEthereumData.stream()
                .mapToInt(EthereumData::getSequentialNumber)
                .max().orElseThrow(NoSuchElementException::new);
    }
}