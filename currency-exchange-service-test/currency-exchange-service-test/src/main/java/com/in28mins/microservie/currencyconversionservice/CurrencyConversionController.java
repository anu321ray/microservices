package com.in28mins.microservie.currencyconversionservice;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.in28mins.microservie.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyExcahngeServiceProxy currencyExcahngeServiceProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean converter(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables=new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,uriVariables);
		
		CurrencyConversionBean response = forEntity.getBody();
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean converterFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		CurrencyConversionBean response =currencyExcahngeServiceProxy.retrieveExcahngeValue(from, to);
		logger.info("Curreny converter response : {} ",response);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
}
