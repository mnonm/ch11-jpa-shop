package com.example.ch11jpashop.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;

@Getter
@Entity
@DiscriminatorValue("A")
public class Album extends Item {
	@Column(name = "artist")
	private String artist;

	@Column(name = "etc")
	private String etc;
}
