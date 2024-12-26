package javabasic.jdbc.board.main;

import java.util.List;

import javabasic.jdbc.board.model.Member;
import javabasic.jdbc.board.model.Reply;
import javabasic.jdbc.board.service.MemberService;
import javabasic.jdbc.board.service.ReplyService;
import javabasic.jdbc.board.service.impl.MemberServiceImpl;
import javabasic.jdbc.board.service.impl.ReplyServiceImpl;

public class ReplyMain {

	public static void main(String[] args) {

		ReplyService replyService = new ReplyServiceImpl();
		
//		List<Reply> replyList = replyService.listReply();
//		for(Reply reply:replyList) {
//			System.out.println(reply);
//		}

//		System.out.println(replyService.getReply(10));

//		replyService.registReply(new Reply(0,"댓글",null,null, 2,"HONG"));
//		replyService.modifyReply(new Reply(21, "new댓글", null, "Y", 3,"KANG"));
		replyService.removeReply(21);

	} // main

} // class
