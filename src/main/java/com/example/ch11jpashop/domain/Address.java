package com.example.ch11jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "zipcode")
	private String zipcode;
}
