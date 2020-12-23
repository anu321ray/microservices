package com.in28mins.microservice.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28mins.microservice.currencyexchangeservice.bean.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExcahngeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExcahngeValue(@PathVariable String from,@PathVariable String to) {
		ExchangeValue ev = new ExchangeValue(from, to, 1L, BigDecimal.valueOf(65));
		ev=repository.findByFromAndTo(from, to);
		ev.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("Curreny exchange service : ");
		return ev;
	}

}
