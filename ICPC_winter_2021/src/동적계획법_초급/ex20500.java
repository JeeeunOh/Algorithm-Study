package 동적계획법_초급;
/*
 * 15배수 : 각 자리의 합이 3의 배수이면서 일의자리가 0또는5 -> 일의자리 5
- N : 4
 ->   - - - 5
 - N : 5
 ->   - - - - 5 
 */
import java.util.*;

public class ex20500 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mod = 1000000007;
		int N = sc.nextInt();
		long[][] arr = new long[3][1516]; //[3으로 나눴을 때 나머지][숫자길이]
		arr[1][1]=1;arr[2][1]=1; //1%3==1, 5%3==2;
		for(int i=2 ; i<N ; i++) {
			arr[0][i]=(arr[1][i-1]+arr[2][i-1])%mod;
			arr[1][i]=(arr[0][i-1]+arr[2][i-1])%mod;
			arr[2][i]=(arr[0][i-1]+arr[1][i-1])%mod;
		}
		System.out.println(arr[1][N-1]);
	}
}
