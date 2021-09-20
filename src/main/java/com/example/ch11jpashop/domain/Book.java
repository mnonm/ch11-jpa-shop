package com.example.ch11jpashop.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;

@Getter
@Entity
@DiscriminatorValue("B")
public class Book extends Item {
	@Column(name = "author")
	private String author;

	@Column(name = "isbn")
	private String isbn;
}
