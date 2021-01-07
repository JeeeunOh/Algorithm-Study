package 정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ex10825 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		String[][] arr = new String[N][4];
		
 
		for(int i = 0; i < N; i++) {
			arr[i][0] = in.next();	// 이름
			arr[i][1] = in.next();	// 국어
			arr[i][2] = in.next();	// 영어
			arr[i][3] = in.next();	// 수학
		}
 
		Arrays.sort(arr, new Comparator<String[]>() {
			// 국어점수 낮은 순 정렬
			@Override
			public int compare(String[] s1, String[] s2) {
				if(Integer.parseInt(s1[1])==Integer.parseInt(s2[1])) {
					if(Integer.parseInt(s1[2])==Integer.parseInt(s2[2])){
						if(Integer.parseInt(s1[3])==Integer.parseInt(s2[3])) {
							return s1[0].compareTo(s2[0]);
							
						}
					}
					
				}
				return Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]);
			}
			
		});
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
        
		
	}
 
}
