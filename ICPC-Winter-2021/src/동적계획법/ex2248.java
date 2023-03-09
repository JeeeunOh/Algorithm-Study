package 동적계획법;

import java.util.*;
import java.util.stream.*;

public class ex2248 {
	    static long[][] dp;
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();  // 0< n < 32
	        int l = sc.nextInt(); // ㅣ개의 1이 있음
	        long i = sc.nextLong(); // n의 범위때문에 최대 2^31(int범위 초과)

	        dp = new long[n + 1][l + 1];
	        dp[0][0] = 1; // 후에 for문에서 계산용으로 1설정
	        
	        for (int y = 1; y <= n; y++) {
	            dp[y][0] = 1; // 이진수가 y개의 자리를 가지고 있고 1이 0개 있다면 경우의 수 1
	            for (int x = 1; x <= l; x++) { // 이 때 y개의 자리에 x개의 1을 가지고 있다면
	                dp[y][x] = dp[y - 1][x - 1] + dp[y - 1][x]; 
	                // dp[y][x]= y-1개의 자리에 x-1개의 1을 가진 수에 1추가 or
	                // y-1개의 자리에 x개의 1을 가진 수에 0 추가를 더한다.
	            }
	        }
	        
	        StringBuilder result = new StringBuilder();  
	        // 스트링 값을 계속 바꿀 수 있게 StringBuilder 사용
	        for (int pos = n; pos > 0; pos--) { // n부터 1번째 자리 탐색
	            final int tempPos = pos; 
	            long count = IntStream.range(0, l + 1). // 카운트번위를 현재 남은 1bit 수로 설정
	            		mapToLong(k -> dp[tempPos - 1][k]). //여기서부터
	                    sum(); //여기까지 뭔소리여,, 아마 이진수단위로 탐색할 때
	            //다음 탐색 범위 구할 때 쓰는 듯
	            int digit;
	            if (count < i) { //count가 주어진 i보다 작으면,
	                digit = 1; // i번째 이진수는 다음 비트에 1이 올 것임 (count보다 크면 1, 작으면 0붙음)
	                i -= count; //i-count를 해주면서 다음 탐색에 씀
	                l--;
	            } else digit = 0;
	            result.append(digit); // 위에서 구한 digit을 뒤에 추가해줌.
	        }
	        System.out.print(result.toString());
	    }
	}

