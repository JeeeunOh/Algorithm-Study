package 悼利拌裙过;
import java.util.*;

public class 悼利拌裙过_2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int wine[] = new int [N];
		int tot[] = new int [N];
		int max = 0;
		for(int i=0;i<N;i++) {
			wine[i] =  sc.nextInt();
			if(i == 0) {
				tot[i] = wine[i];
			} else if (i == 1) {
				tot[i] = tot[i-1] + wine[i];
			} else if (i == 2) {
				tot[i] = Math.max(wine[1]+wine[2], Math.max(wine[0]+wine[2], wine[0]+wine[1]));
			} else {
				tot[i] = Math.max(tot[i-1], Math.max(tot[i-2]+wine[i], tot[i-3]+wine[i-1]+wine[i]));
			}
			max = Math.max(max, tot[i]);
		}
		System.out.println(max);
	}
}
