package javabasic.exexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 1. 입력한 것이 숫자인 경우는 정수로 변환하기
		// 2. 입력한 것이 숫자이지만 int의 범위를 넘어가면 예외처리 하기
		// 3. 입력한 것이 숫자가 아닌 경우에 대해 예외처리 하기

		try {
			System.out.println("피제수를 입력해주세요");
			double d1 = scan.nextDouble();
			System.out.println("제수를 입력해주세요");
			double d2 = scan.nextDouble();

			if (d2 == 0) {  // 제수에 0값을 입력하면 ArithmeticException
				throw new ArithmeticException();
			} else if (Double.isNaN(d1) && Double.isNaN(d2)) {// 숫자면 false, 숫자가 아니면 true
				throw new NumberFormatException();  // 숫자가 아니면 NumberFormatException
			} else {
				int i1 = (int) d1;  // int로 강제 형변환
				int i2 = (int) d2;
				// int의 최대값, 최소값 범위 안에 있는지 확인
				if (i1 >= Integer.MAX_VALUE || i1 <= Integer.MIN_VALUE) {
					try {
						throw new Exception();  // 
					} catch (Exception e) {
						System.out.println("int의 범위를 초과했습니다.");
					}
				} else {  // 위 사항 해당하지 않는다면 나누기
					System.out.println(i1 + "/" + i2 + "=" + (i1 / i2));
				}
			}
		} catch (ArithmeticException ae) {
			System.out.println("0으로는 나눌 수 없습니다!");
		} catch (NumberFormatException ne) {
			System.out.println("double값이 아닙니다.");
		} catch (InputMismatchException ie) {
			System.out.println("숫자가 아닙니다.");
		} finally {
			scan.close();
		}

	} // main

} // class
