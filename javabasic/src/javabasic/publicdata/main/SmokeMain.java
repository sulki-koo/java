package javabasic.publicdata.main;

import javabasic.publicdata.api.APIModule;
import javabasic.publicdata.service.APIService;
import javabasic.publicdata.service.impl.APIServiceImpl;

public class SmokeMain {

	public static void main(String[] args) {

		APIService service = new APIServiceImpl();

		service.initData(new APIModule().getSmokeMap());

		System.out.println(service.getList());
		
	} // main

} // class
