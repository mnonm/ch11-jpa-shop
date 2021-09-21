package com.example.ch11jpashop.domain;

public class NotEnoughStockException extends RuntimeException {
	public NotEnoughStockException(String msg) {
		super(msg);
	}
}
