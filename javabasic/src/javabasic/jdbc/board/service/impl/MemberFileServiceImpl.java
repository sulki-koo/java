package javabasic.jdbc.board.service.impl;

import java.util.List;
import java.util.Map;

import javabasic.jdbc.board.dao.MemberDao;
import javabasic.jdbc.board.dao.impl.MemberFileDaoImpl;
import javabasic.jdbc.board.model.Member;
import javabasic.jdbc.board.service.MemberService;

public class MemberFileServiceImpl implements MemberService {
	
	private MemberDao memberFileDao = new MemberFileDaoImpl();
	
	public MemberFileServiceImpl() {
	}

	@Override
	public List<Member> listMember() {
		return memberFileDao.listMember();
	}

	@Override
	public Member getMember(String mid) {
		return memberFileDao.getMember(mid);
	}

	@Override
	public int registMember(Member member) {
		return memberFileDao.registMember(member);
	}

	@Override
	public int modifyMember(Member member) {
		return memberFileDao.modifyMember(member);
	}

	@Override
	public int removeMember(String mid) {
		return memberFileDao.removeMember(mid);
	}

}
