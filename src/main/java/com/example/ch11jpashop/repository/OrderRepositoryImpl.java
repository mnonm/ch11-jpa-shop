package com.example.ch11jpashop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import com.example.ch11jpashop.domain.Order;
import com.example.ch11jpashop.domain.OrderSearch;
import com.example.ch11jpashop.domain.QMember;
import com.example.ch11jpashop.domain.QOrder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class OrderRepositoryImpl extends QuerydslRepositorySupport implements CustomOrderRepository {
	private final JPAQueryFactory queryFactory;

	public OrderRepositoryImpl(JPAQueryFactory queryFactory) {
		super(Order.class);
		this.queryFactory = queryFactory;
	}

	@Override
	public List<Order> search(OrderSearch orderSearch) {
		QOrder order = QOrder.order;
		QMember member = QMember.member;

		JPAQuery<Order> query = queryFactory.selectFrom(order);

		if (StringUtils.hasText(orderSearch.getMemberName())) {
			query.leftJoin(order.member, member)
				.where(member.name.contains(orderSearch.getMemberName()));
		}

		if (orderSearch.getOrderStatus() != null) {
			query.where(order.status.eq(orderSearch.getOrderStatus()));
		}

		return query.fetch();
	}
}
