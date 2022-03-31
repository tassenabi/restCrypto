package com.ann.restCrypto;

import com.ann.restCrypto.configs.CredConfigs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestCryptoApplication {

	private static Logger log = LoggerFactory.getLogger(CredConfigs.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(RestCryptoApplication.class, args);
		CredConfigs credConfigs = context.getBean(CredConfigs.class);
		log.info(credConfigs.getApiKeyCoinmarket());
	}

}