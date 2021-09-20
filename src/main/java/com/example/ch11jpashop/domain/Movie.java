package com.example.ch11jpashop.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;

@Getter
@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
	@Column(name = "director")
	private String director;

	@Column(name = "actor")
	private String actor;
}
