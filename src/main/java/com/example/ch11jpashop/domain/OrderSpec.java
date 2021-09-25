package com.example.ch11jpashop.domain;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class OrderSpec {
	public static Specification<Order> memberNameLike(final String memberName) {
		return (root, query, builder) -> {
			if (!StringUtils.hasText(memberName)) {
				return null;
			}
			Join<Order, Member> m = root.join("member", JoinType.INNER);
			return builder.like(m.<String>get("name"), "%" + memberName + "%");
		};
	}

	public static Specification<Order> orderStatusEq(final OrderStatus orderStatus) {
		return (root, query, builder) -> {
			if (orderStatus == null) {
				return null;
			}
			return builder.equal(root.get("status"), orderStatus);
		};
	}
}
