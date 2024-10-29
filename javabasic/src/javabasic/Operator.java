package javabasic;

public class Operator {

	public static void main(String[] args) {

		// 단항 연산자
		int i1 = +5;
		int j1 = -i1;

		// 전치, 후치 연산자
		int i2 = ++i1; // i1이 1 증가하고 증가된 값이 i2에 할당 > i1은 그대로 1 (연산자 앞에 위치 > 전치)
		int i3 = i1++; // i1이 i3에 할당된 후 i1이 1증가 > i1은 2가 됨 (연산자 뒤에 위치 > 후치)

		// 삼항 연산자
		int i4 = 5;
		int j2 = i4 > 5 ? 1 : 2; // i4가 5보다 크면 j2에는 1이 할당되고 아니면 2가 할당됨
		// if문으로 변경
//		int j2 = 0;
//		if (i4 > 5) {
//			j2 = 1;
//		} else {
//			j2 = 2;
//		}

		// 비트 연산자
		byte b1 = 3; // 2진수 0(양수)0000011
		byte b2 = ~3; // ~:비트반전 -> 2진수 1(음수)1111100
		System.out.println(b2); // -4

		// 양수 > 음수 (3 > -3) 연산법
		// 1. 모든비트를 반전
		// 2. 1을 더함
		// ex) 00000011 (십진수 3) > 11111100 (십진수 -4) +1 > 11111101 (십진수 -3)

		byte b3 = 5; // 00000101 (2^2+1)
		byte b4 = 3 | 5; // 00000011 | 00000101 -> 00000111(십진수 7) (bit or)
		byte b5 = 3 & 5; // 00000011 & 00000101 -> 00000001(십진수 1) (bit and)
		byte b6 = 3 ^ 5; // 00000011 | 00000101 -> 00000110(십진수 6) (bit xor)

		// 쉬프트 연산자 (비트 이동)
		byte b7 = 5; // 00000101
		// 비트를 오른쪽으로 3칸 이동시키고 나머지는 0으로 채움
		byte b8 = 5 >> 3; // 00000101 > 00000000(십진수 0)
		byte b9 = (byte) (-5 >>> 3); // 11111011(십진수 -5) > 11111111(십진수 -1)
		byte b11 = 3 << 2; // 00000011 > 00001100(십진수 12)

		// 나머지 연산자
		int i5 = 7;
		int j5 = 3;
		System.out.println(i5 % j5); // 1

		// 관계 연산자 : 값은 항상 ture | false
		int i6 = 10;
		int j6 = 5;
		System.out.println(i6 == j6);
		System.out.println(i6 != j6);
		System.out.println(i6 > j6);
		System.out.println(i6 >= j6);
		System.out.println(i6 < j6);
		System.out.println(i6 <= j6);

		// 논리 연산자
		boolean bool1 = true;
		boolean bool2 = false;
		System.out.println(!bool1); // false 논리 부정
		System.out.println(bool1 & bool2); // false 논리 곱
		System.out.println(bool1 | bool2); // true 논리 합

		// && : 앞의 결과가 false면 뒤의 연산을 수행하지 않음(why? 전체결과가 false이니까)
		int i7 = 10;
		int j7 = 5;
		if (i7 > 10 && j7 < 10) {
			System.out.println("i7은 j7보다 큽니다!");
		}

		// || : 앞의 결과가 true면 뒤의 연산을 수행하지 않음(why? 전체결과가 true임)

		// 대입 연산자(=할당 =저장)
		// 연산방향이 우 > 좌
		int i8 = 5;
		int i9 = 3;
		i9 += i8; // i9 = i9 + i8;
		i9 -= i8; // i9 = i9 - i8;
		i9 *= i8; // i9 = i9 * i8;
		i9 /= i8; // i9 = i9 / i8;
		i9 %= i8; // i9 = i9 % i8;

		// 연산자 우선순위 : 연산자가 동시에 여러개 사용되면 연산의 우선순위가 연산자에 따라 결정
		// ()가 연산 우선순위가 가장 높다
		// 대입연산자가 우선순위가 가장 낮다

	} // main

} // class
