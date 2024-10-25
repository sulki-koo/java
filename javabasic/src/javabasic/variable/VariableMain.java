package javabasic.variable;

import javabasic.Variable3;

public class VariableMain {

	public static void main(String[] args) {
		
		Variable3 v3 = new Variable3();
		System.out.println(v3.pubi);
		// protected 접근제한은 다른 패키지에 있을때 접근 불가
		//System.out.println(v3.proti);
		// default 접근제한은 다른 패키지에 있을때 접근 불가
		//System.out.println(v3.di);
		// private 접근제한은 다른 패키지에 있을때 접근 불가
		//System.out.println(v3.prii);
		
	}
	
	
}
