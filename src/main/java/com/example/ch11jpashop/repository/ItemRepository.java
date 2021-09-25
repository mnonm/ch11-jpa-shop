package com.example.ch11jpashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ch11jpashop.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
