package com.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class ConversionBean {

	private Long id;
	private String to;
	private String from;
	private BigDecimal conversionMultiple;
	private int port;
	private BigDecimal conversionAmount;

	public ConversionBean() {
		super();
	}

	public ConversionBean(Long id, String to, String from, BigDecimal conversionMultiple, int port,
			BigDecimal conversionAmount) {
		super();
		this.id = id;
		this.to = to;
		this.from = from;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
		this.conversionAmount = conversionAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public BigDecimal getConversionAmount() {
		return conversionAmount;
	}

	public void setConversionAmount(BigDecimal conversionAmount) {
		this.conversionAmount = conversionAmount;
	}

}
