package unit02_���;

public class ex��������ϱ�ͳ����� {
	static int product(int a, int b) {
		if(b==1) return a;
		else return a+product(a,b-1);
	} // a�� b�� ��
	static int modulo (int a, int b) {
		if(a<b) return a;
		else return modulo(a-b,b);
	} //  a�� b�� ���� ������ ���
	static int quotient(int a, int b) {
		if (a<b) return 0;
		else return 1+ quotient(a-b,b);
	}// a�� b�� ���� �� ���
	
	public static void main(String[] args) {
		int a = 17, b =5;
		System.out.println("�� :  "+product(a,b));
		System.out.println(" ������ : "+modulo(a,b));
		System.out.println("�� : "+quotient(a,b));
	} 
}
