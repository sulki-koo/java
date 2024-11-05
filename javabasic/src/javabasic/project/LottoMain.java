package javabasic.project;

// 로직을 이용해 배열에 숫자를 넣고 프린트하기
public class LottoMain {

	public static void main(String[] args) {
		
		LottoMachine lottoMachine = new LottoMachine();

		int[] lottoDraw = new int[45];

		int lottoDrawLeng = lottoDraw.length;
		
		for(int i = 0; i<lottoDrawLeng; i++)	{
			lottoDraw[i] = i+1;
			System.out.print(lottoDraw[i]+"\t" );
		}
		System.out.println();
		
		
		
		
		for(int i = 0; i<lottoDrawLeng; i++)	{
			lottoMachine.lottoBalls[i] = new LottoBall("ddd", lottoDraw[i]);
			System.out.print(lottoMachine.lottoBalls[i].ball+"\t");
		}
		
		// lottoMachine.lottoBalls[i].ball -> .ball(class LottoBall의 int ball;을 불러옴)
		
		
	}  // main
	

}  // class
