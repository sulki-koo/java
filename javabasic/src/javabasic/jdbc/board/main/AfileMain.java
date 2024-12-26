package javabasic.jdbc.board.main;

import javabasic.jdbc.board.model.Afile;
import javabasic.jdbc.board.service.AfileService;
import javabasic.jdbc.board.service.impl.AfileServiceImpl;

public class AfileMain {

	public static void main(String[] args) {

		AfileService afileService = new AfileServiceImpl();
		
//		List<Afile> afilerList = afileService.listAfile();
//
//		for(Afile afile:afilerList) {
//			System.out.println(afile);
//		}

//		System.out.println(afileService.getAfile(11));

//		afileService.registAfile(new Afile(0,"서버","클라이언트",null,null,3));
//		afileService.modifyAfile(new Afile(23,"new서버","new클라이언트", null, "N", 2));
		afileService.removeAfile(23);

	} // main

} // class
