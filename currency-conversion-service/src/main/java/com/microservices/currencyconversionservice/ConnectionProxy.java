package com.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name ="currency-exchange-service")
public interface ConnectionProxy {

	@GetMapping("/conversion/{to}/exchange/{from}")
	public ConversionBean getExchangeRates(@PathVariable("to") String to, @PathVariable("from") String from);

}
