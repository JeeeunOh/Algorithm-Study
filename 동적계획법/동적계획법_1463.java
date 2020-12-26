import java.util.*;

public class µ¿Àû°èÈ¹¹ı_1463 {
	public static int min(int a, int b) {
		return a<b? a:b;
	}

	public static void main(String[] args) {
		int res=0;
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num+1];
		arr[1] = 0 ;
		for (int i = 2 ; i <= num ; i++) {
			arr[i] = arr[i-1] + 1;
			if (i%2==0) {
				arr[i] = min(arr[i], arr[i/2]+1);
			}
			if (i%3==0) {
				arr[i] = min(arr[i], arr[i/3]+1);
			}
		}
		System.out.println(arr[num]);
	}

}








