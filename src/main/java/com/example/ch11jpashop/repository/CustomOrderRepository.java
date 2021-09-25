package com.example.ch11jpashop.repository;

import java.util.List;

import com.example.ch11jpashop.domain.Order;
import com.example.ch11jpashop.domain.OrderSearch;

public interface CustomOrderRepository {
	List<Order> search(OrderSearch orderSearch);
}
