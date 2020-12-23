package com.in28mins.microservie.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28mins.microservie.currencyconversionservice.bean.CurrencyConversionBean;

/*@FeignClient(name="currency-exchange-service",url = "http://localhost:8000")*/
/*@FeignClient(name="currency-exchange-service")*/
@FeignClient(name="netflix-zullzpi-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExcahngeServiceProxy {

	/* @GetMapping("/currency-exchange/from/{from}/to/{to}") */
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExcahngeValue(@PathVariable String from,@PathVariable String to);
	
}
