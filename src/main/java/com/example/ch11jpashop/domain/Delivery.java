package com.example.ch11jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "delivery")
public class Delivery {
	@Id
	@GeneratedValue
	@Column(name = "delivery_id")
	private Long id;

	@Setter
	@JoinColumn(name = "order_id")
	@OneToOne(mappedBy = "delivery")
	private Order order;

	@Embedded
	private Address address;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;

	public Delivery(Address address) {
		this.address = address;
	}
}
