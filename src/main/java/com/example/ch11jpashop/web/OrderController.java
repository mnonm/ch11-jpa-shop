package com.example.ch11jpashop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ch11jpashop.domain.Item;
import com.example.ch11jpashop.domain.Member;
import com.example.ch11jpashop.domain.Order;
import com.example.ch11jpashop.domain.OrderSearch;
import com.example.ch11jpashop.service.ItemService;
import com.example.ch11jpashop.service.MemberService;
import com.example.ch11jpashop.service.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OrderController {

	private final OrderService orderService;
	private final MemberService memberService;
	private final ItemService itemService;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String createForm(Model model) {

		List<Member> members = memberService.findMembers();
		List<Item> items = itemService.findItems();

		model.addAttribute("members", members);
		model.addAttribute("items", items);

		return "order/orderForm";
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(@RequestParam("memberId") Long memberId, @RequestParam("itemId") Long itemId, @RequestParam("count") int count) {

		orderService.order(memberId, itemId, count);
		return "redirect:/orders";
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {

		List<Order> orders = orderService.findOrders(orderSearch);
		model.addAttribute("orders", orders);

		return "order/orderList";
	}

	@RequestMapping(value = "/orders/{orderId}/cancel")
	public String processCancelBuy(@PathVariable("orderId") Long orderId) {

		orderService.cancelOrder(orderId);

		return "redirect:/orders";
	}
}
