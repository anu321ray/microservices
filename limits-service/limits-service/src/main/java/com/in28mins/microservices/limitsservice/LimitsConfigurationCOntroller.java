package com.in28mins.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28mins.microservices.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationCOntroller {
	
	@Autowired
	private Configurtion configuration;
	
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		
		return new LimitConfiguration(configuration.getMin(), configuration.getMax());
	}

}
