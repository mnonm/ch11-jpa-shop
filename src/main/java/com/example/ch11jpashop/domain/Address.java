package com.example.ch11jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "zipcode")
	private String zipcode;
}
