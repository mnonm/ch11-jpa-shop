package com.example.ch11jpashop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ch11jpashop.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	List<Member> findByName(String name);
}
