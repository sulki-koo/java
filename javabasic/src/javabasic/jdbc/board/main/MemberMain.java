package javabasic.jdbc.board.main;

import java.util.List;

import javabasic.jdbc.board.model.Member;
import javabasic.jdbc.board.service.MemberService;
import javabasic.jdbc.board.service.impl.MemberServiceImpl;

public class MemberMain {

	public static void main(String[] args) {

		MemberService memberService = new MemberServiceImpl();
//		List<Member> memberList = memberService.listMember();

//		for(Member member:memberList) {

//			System.out.println(member);
//		}

//		System.out.println(memberService.getMember("HONG"));

//		memberService.registMember(new Member("JANG","JANG","장보고",null,null));
//		memberService.modifyMember(new Member("JANG","newJang","new장보고",null,"N"));
		memberService.removeMember("JANG");

	} // main

} // class
