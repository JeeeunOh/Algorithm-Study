package SUAPC;

import java.util.*;

public class K {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		int num=0, pre = 0, now=0;

        for (int i = 2; i <= N; i++) {
                while (N % i == 0) {
                    arr[now]=i ;
                    now++; // ¼ÒÀÎ¼ö ¼ø¼­´ë·Î ¹è¿­¿¡ ³ÖÀ½
                    N = N/i;
                    num++;
                }
        }
        
        Arrays.sort(arr);

        now=0; // arr[j] ²¨³»¿À±â ¿ë
        int check=0;
        if(num<=3)  System.out.println("-1"); 
        else { // ÇÕ¼º¼ÒÀÎ¼ö ¸¸µé ¼ö ÀÖÀ» ‹š
        	if(num%2==0 && N%2==0) { // numÀÌ Â¦¼ö, N Â¦¼ö
        		while(check!=num) {
        			if(arr[now]==0) {
        				now++;
        				continue; // 0ÀÌ¸é ÆÐ½º
        			}
        			
        			if(now%2!=0) pre = arr[now]; // index°¡ È¦¼öÀÎ ¼ö * Â¦¼öÀÎ ¼ö
        			else {
        				int ans = pre*arr[now];
        				System.out.print(ans+" ");
        			}
        			now++; check++;
        		}
        	}else if(num%2!=0 && N %2==0) { // numÀÌ È¦¼ö, N Â¦¼ö
        		while(check!=num-2) {
        			if(arr[now]==0) {
        				now++;
        				continue; // 0ÀÌ¸é ÆÐ½º
        			}
        			
        			if(now%2==0) pre = arr[now]; // index°¡ Â¦¼ö * È¦¼ö
        			else {
        				int ans = pre*arr[now];
        				System.out.print(ans+" ");
        			}
        			now++; check++;
        		}
        		int ans = arr[now]*arr[now+1]*arr[now+2];
        		System.out.print(ans+" ");
        	}else if (num%2==0 && N %2!=0) { // numÀÌ Â¦¼ö, N È¦¼ö
        		while(check!=num) {
        			if(arr[now]==0) {
        				now++;
        				continue; // 0ÀÌ¸é ÆÐ½º
        			}
        			
        			if(now%2==0) pre = arr[now]; // index Â¦¼ö * È¦¼ö
        			else {
        				int ans = pre*arr[now];
        				System.out.print(ans+" ");
        			}
        			now++; check++;
        		}
        	} else if (num%2!=0 && N %2!=0) { // numÀÌ È¦¼ö, N È¦¼ö
        		while(check!=num-2) {
        			if(arr[now]==0) {
        				now++;
        				continue; // 0ÀÌ¸é ÆÐ½º
        			}
        			
        			if(now%2!=0) pre = arr[now]; // index°¡ È¦¼öÀÎ ¼ö * Â¦¼öÀÎ ¼ö
        			else {
        				int ans = pre*arr[now];
        				System.out.print(ans+" ");
        			}
        			now++; check++;
        		}
        		int ans = arr[now]*arr[now+1]*arr[now+2];
        		System.out.print(ans+" ");
        	} 
        }
	}
}
