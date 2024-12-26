package javabasic.jdbc.board.service;

import java.util.List;
import java.util.Map;

import javabasic.jdbc.board.model.Member;

public interface MemberService {
	
	public abstract List<Member> listMember();
	
	public abstract Member getMember(String mid); // 조회

	public abstract int registMember(Member member); // 등록
	
	public abstract int modifyMember(Member member); // 업데이트
	
	public abstract int removeMember(String mid); // 삭제
	
}
