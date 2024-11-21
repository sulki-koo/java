package javabasic.exio;

public class Score {

	String kor;
	String eng;
	String math;

	public Score() {
	}

	public Score(String kor, String eng, String math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}
	
	@Override
	public String toString() {
		return "국어:"+kor+" 영어:"+eng+" 수학:"+math;
	}

}
