package javabasic.project.ooplotto;

// 로직을 이용해 배열에 숫자를 넣고 프린트하기
public class LottoMain {

	public static void main(String[] args) {

		// 아이템 정보 클래스 호출
		//LottoItemInfo lottoItemInfo = new LottoItemInfo();
		// 아이템 정보 프린트
		//System.out.println(lottoItemInfo);
		
//		LottoUser lottoUser = new LottoUser();
//		// LottoBuyInfo lottoBuyInfo = new LottoBuyInfo();
//		System.out.println("수동으로 선택하시겠습니까?");
//		String c = "yes";  // 추후 입력받을 예정
//		if (c.equals("yes")) {
//			// lottoUser가 lottoBuyInfo 위임받아 howToPurchase 사용가능                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
//			lottoUser.lottoBuyInfo.setHowToPurchase(true);
//		}
//		System.out.println(lottoUser.lottoBuyInfo.isHowToPurchase());
		

//		// 로또로직 클래스 호출
//		LottoLogic lottoLogic = new LottoLogic();
//		// 로또로직의 객체를 만들어서 intoMachine 메서드 호출 - 추첨진행
//		lottoLogic.intoMachine();
		
		// 인터페이스로 불러오기
		ILottoGame host = new LottoLogic();
		host.gameHost();
		host.gameUser();
		
		

	} // main


} // class
