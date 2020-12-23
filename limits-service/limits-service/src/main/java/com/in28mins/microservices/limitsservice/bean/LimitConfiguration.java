package com.in28mins.microservices.limitsservice.bean;

public class LimitConfiguration {

	int min,max;

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public LimitConfiguration(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	
	protected LimitConfiguration() {
		
	}
}
