package com.example.ch11jpashop.domain;

import static com.example.ch11jpashop.domain.OrderSpec.*;
import static org.springframework.data.jpa.domain.Specification.*;

import org.springframework.data.jpa.domain.Specification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderSearch {
	private String memberName;
	private OrderStatus orderStatus;

	public Specification<Order> toSpecification() {
		return where(memberNameLike(memberName))
			.and(orderStatusEq(orderStatus));
	}
}
