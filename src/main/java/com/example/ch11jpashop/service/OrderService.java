package com.example.ch11jpashop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.ch11jpashop.domain.Delivery;
import com.example.ch11jpashop.domain.Item;
import com.example.ch11jpashop.domain.Member;
import com.example.ch11jpashop.domain.Order;
import com.example.ch11jpashop.domain.OrderItem;
import com.example.ch11jpashop.domain.OrderSearch;
import com.example.ch11jpashop.repository.MemberRepository;
import com.example.ch11jpashop.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderService {
	private final MemberRepository memberRepository;
	private final OrderRepository orderRepository;
	private final ItemService itemService;

	public Long order(Long memberId, Long itemId, int count) {
		Member member = memberRepository.findById(memberId).get();
		Item item = itemService.findOne(itemId);

		Delivery delivery = new Delivery(member.getAddress());
		OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
		Order order = Order.createOrder(member, delivery, orderItem);

		orderRepository.save(order);
		return order.getId();
	}

	public void cancelOrder(Long orderId) {
		Order order = orderRepository.findById(orderId).get();
		order.cancel();
	}

	public List<Order> findOrders(OrderSearch orderSearch) {
		return orderRepository.findAll(orderSearch.toSpecification());
	}
}
