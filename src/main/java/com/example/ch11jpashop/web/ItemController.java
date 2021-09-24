package com.example.ch11jpashop.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ch11jpashop.domain.Book;
import com.example.ch11jpashop.domain.Item;
import com.example.ch11jpashop.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ItemController {
	private final ItemService itemService;

	@GetMapping(value = "/items/new")
	public String createForm() {
		return "items/createItemForm";
	}

	@PostMapping(value = "/items/new")
	public String create(Book item) {
		itemService.saveItem(item);
		return "redirect:/items";
	}

	@GetMapping(value = "/items")
	public String list(Model model) {
		List<Item> items = itemService.findItems();
		model.addAttribute("items", items);
		return "items/itemList";
	}

	@GetMapping(value = "items/{itemId}/edit")
	public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
		Item item = itemService.findOne(itemId);
		model.addAttribute("item", item);
		return "items/updateItemForm";
	}

	@PostMapping(value = "/items/{itemId}/edit")
	public String updateItem(@ModelAttribute("item") Book item) {
		itemService.saveItem(item);
		return "redirect:/items";
	}

}
