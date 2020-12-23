package com.in28mins.microservice.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28mins.microservice.currencyexchangeservice.bean.ExchangeValue;

public interface ExcahngeValueRepository extends JpaRepository<ExchangeValue, Long>{
	
	public ExchangeValue findByFromAndTo(String from, String to);

}
