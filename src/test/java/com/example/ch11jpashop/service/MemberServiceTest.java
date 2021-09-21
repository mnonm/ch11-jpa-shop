package com.example.ch11jpashop.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ch11jpashop.domain.Member;
import com.example.ch11jpashop.repository.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MemberServiceTest {
	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void 회원가입() {
		//given
		Member member = new Member();
		member.setName("kim");

		//when
		Long saveId = memberService.join(member);

		//then
		assertEquals(member.getName(), memberRepository.findOne(saveId).getName());
	}

	@Test(expected = IllegalStateException.class)
	public void 중복_회원_예외() throws Exception {
		//given
		Member member1 = new Member();
		member1.setName("kim");

		Member member2 = new Member();
		member2.setName("kim");

		//when
		memberService.join(member1);
		memberService.join(member2);

		//then
		fail("예외 발생");

	}

}