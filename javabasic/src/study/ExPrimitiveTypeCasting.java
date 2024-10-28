package study;

public class ExPrimitiveTypeCasting {

	public static void main(String[] args) {
		
		byte b = 1;
		short s = 2;
		int i = 3;
		long l = 4;
		float f = 1.5f;
		double d = 10.5;
		char c = 'S';
		
		b = (byte) s;
		System.out.println("short 2 =  "+b);
		b = (byte) i;
		System.out.println("int 3 =  "+b);
		b = (byte) l;
		System.out.println("long 4 =  "+b);
		b = (byte) f;
		System.out.println("float 1.5 =  "+b);
		b = (byte) d;
		System.out.println("double 10.5 =  "+b);
		b = (byte) c;
		System.out.println("char S =  "+b);

	}
	
}
