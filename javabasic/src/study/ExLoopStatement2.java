package study;

public class ExLoopStatement2 {

	public static void main(String[] args) {

		System.out.println("==1번 별==");
		for (int i1 = 1; i1 <= 5; i1++) {
			// 별찍기
			for (int j1 = 1; j1 <= i1; j1++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("==3번 별==");
		// i3=0, j3=0, k3=0 1 2 3 4
		// i3=1, j3=0 1, k3=0 1 2 3
		// i3=2, j3=0 1 2, k3=0 1 2
		// i3=3, j3=0 1 2 3, k3=0 1
		// i3=4, j3=0 1 2 3 4, k3=0
		for (int i3 = 0; i3 < 5; i3++) { // 줄의 수
			for (int j3 = 0; j3 < i3; j3++) { // 공백의 수
				System.out.print(" ");
			}
			for (int k3 = 0; k3 < 5 - i3; k3++) { // 별의 수
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("==2번 별==");
		for (int i2 = 0; i2 < 5; i2++) { // 줄의 수
			for (int k2 = 0; k2 < 5 - i2; k2++) { // 별의 수
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("==4번 별==");
//		i4=0	j4=0 2 4 6     k4=0			
//		i4=2	j4=0 2 4     k4=0 1 2	   
//		i4=4	j4=0 2    k4=0 1 2 3 4    
//		i4=6	j4=0    k4=0 1 2 3 4 5 6	
//		i4=8	        k4=0 1 2 3 4 5 6 7 8
		for (int i4 = 0; i4 < 9; i4 += 2) { // 줄의 수
			for (int j4 = 0; j4 < 9 - i4; j4 += 2) { // 공백의 수
				System.out.print("  ");
			}
			for (int k4 = 0; k4 <= i4; k4++) { // 별의 수
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("==5번 별 예시==");
		for (int i=0; i<5; i++) {  //줄의 수
			for (int j=0; j<5; j++) {
				if (i%4==0||j%4==0) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			} System.out.println();
		}

		System.out.println("==5번 별==");
		for (int i5 = 0; i5 < 5; i5++) { // 줄의 수
			if (i5 % 4 == 0) { // 0  4줄 별찍기
				for (int k5 = 0; k5 < 5; k5++) { // 짝수줄 별의 수
					System.out.print("*");} 
			} // 0  4 별찍기
			else { // 나머지줄 별찍기
				for (int j5 = 0; j5 < 5; j5++) { // 나머지줄 별의 수
					if (j5 == 0 || j5 == 4) System.out.print("*");
					else System.out.print(" ");
				}
			} 
			System.out.println();
		} // 줄의 수

		System.out.println("==6번 별==");
		for (int i6=0; i6 < 5; i6++) { // 줄의 수
			for (int k6=0; k6<5; k6++) { // 별의 수		
				if (i6==0||i6==4) {  // 0, 4 별
					if (k6==0||k6==4) System.out.print("*");
					else System.out.print(" ");	
				}
				if (i6==1||i6==3) {  // 1, 3 별
					if (k6==1||k6==3) System.out.print("*");
					else System.out.print(" ");	
				}
				if (i6==2) {  // 2 별
					if (k6==3) System.out.print("*");
					else System.out.print(" ");	
				}
			}
			System.out.println();
		}
		
		System.out.println("==7번 별==");
		for (int i7=0; i7 < 5; i7++) { // 줄의 수
			for (int k6=0; k6<5; k6++) { // 별의 수
				if (i7==1||i7==3) {
					if (k6==2) System.out.print(" ");
					else System.out.print("*");
				}
				else if (i7==2) {
					if (k6%2==0) System.out.print("*");
					else System.out.print(" ");
				}else System.out.print("*");
			}
		System.out.println();
		}
	} // main

} // class
