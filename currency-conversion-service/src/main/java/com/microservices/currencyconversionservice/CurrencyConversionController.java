package com.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private ConnectionProxy proxy;

	@GetMapping("/convert/{to}/{from}/{amount}")
	public ConversionBean getExchangeRates(@PathVariable String to, @PathVariable String from,
			@PathVariable String amount) {

		ConversionBean bean = new ConversionBean();
		// Object uriVariables = null;
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("to", to);
		uriVariables.put("from", from);
		bean = new RestTemplate().getForEntity("http://localhost:8000/conversion/{to}/exchange/{from}",
				ConversionBean.class, uriVariables).getBody();
		bean.setConversionAmount(bean.getConversionMultiple().multiply(new BigDecimal(amount)));
		System.out.println(bean.getConversionAmount());
		return bean;

	}

	@GetMapping("/convert/feign/{to}/{from}/{amount}")
	public ConversionBean getExchangeRatesProxy(@PathVariable String to, @PathVariable String from,

			@PathVariable String amount) {

		ConversionBean bean = new ConversionBean();
		bean = proxy.getExchangeRates(to, from);
		bean.setConversionAmount(bean.getConversionMultiple().multiply(new BigDecimal(amount)));
		System.out.println(bean.getConversionAmount());
		return bean;

	}

}
