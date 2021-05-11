package unit02_재귀;

public class ex하노이탑 {
	static void hanoi(int n) {
		rHanoi(n, "A", "B", "C");
		return;
	} 
	static void rHanoi(int n, String from, String aux, String to) {
		if(n==1) {
			System.out.println("move from "+ from + " to "+ to);
			return;
		}
		rHanoi(n-1, from, to, aux);
		System.out.println("move from "+ from + " to "+ to);
		rHanoi(n-1, aux, from, to);
		return;
	}
	public static void main(String[] args) {
		hanoi(3);
	}
}
