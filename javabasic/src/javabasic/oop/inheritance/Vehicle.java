package javabasic.oop.inheritance;

public class Vehicle{  //  Vehicle extends Object

	String name;  // 이름
	private Boolean hasEngine;  // 엔진보유여부

	String getName() {
		return "탈것";
	}

	// Object의 toString메서드를 오버라이딩
	@Override
		public String toString() {
			return "Vehicle의 toString()";
		}
	
	

}
