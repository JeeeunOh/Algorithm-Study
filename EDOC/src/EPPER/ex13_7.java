package EPPER;

import java.util.*;

public class ex13_7 {
	public static int solution(int[] arr, int start, int end) {
		 int answer = 0;
		 while(start<end) {
			 // 대칭 이루면 패스
			 if(arr[start]==arr[end]) {
				 start++; end--; continue;
			 }
			 // 대칭 아니면
			 else {
				 if(arr[start]<arr[end]) {
					 arr[start+1]+= arr[start];
					 start++;
					 answer++;
					 continue;
				 } else {
					 arr[end-1]+= arr[end];
					 end--;
					 answer++;
					 continue;
				 }
			 }
		 }
		 return answer;
   }
	
	public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n =  sc.nextInt();
          
          int[] arr = new int[n];
          int start = 0;
          int end = 0;
          
          for (int i = 0; i < n; i++) arr[i] = sc.nextInt(); 
          end = n - 1;

          System.out.println(solution(arr, start, end));
	}
}
