package 브루트포스_백트래킹;
// 백트래킹 문제
import java.util.*;

public class ex1182 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int[] arr = new int[n+1];
		int[] ssum = new int[n+1];
		int ans=0;
		
		for(int i=0 ; i<n ; i++) {
			arr[i]=sc.nextInt();
			if(i==0) ssum[i]=arr[i];
			else ssum[i]=ssum[i-1]+arr[i];
			
			if(i!=0)
				for(int j=0 ; j<i ; j++) {
					if(ssum[i]-ssum[j]==sum) ans++;
				}
		}
		System.out.println(ans);
	}

}
