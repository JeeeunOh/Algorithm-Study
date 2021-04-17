package unit02_Àç±Í;

public class exÀç±ÍÀû°öÇÏ±â¿Í³ª´©±â {
	static int product(int a, int b) {
		if(b==1) return a;
		else return a+product(a,b-1);
	} // a¿Í bÀÇ °ö
	static int modulo (int a, int b) {
		if(a<b) return a;
		else return modulo(a-b,b);
	} //  a¸¦ b·Î ³ª´« ³ª¸ÓÁö °è»ê
	static int quotient(int a, int b) {
		if (a<b) return 0;
		else return 1+ quotient(a-b,b);
	}// a¸¦ b·Î ³ª´« ¸ò °è»ê
	
	public static void main(String[] args) {
		int a = 17, b =5;
		System.out.println("°ö :  "+product(a,b));
		System.out.println(" ³ª¸ÓÁö : "+modulo(a,b));
		System.out.println("¸ò : "+quotient(a,b));
	} 
}
