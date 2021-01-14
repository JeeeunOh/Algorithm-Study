package 정렬;

import java.util.*;
import java.math.*;

public class ex11652 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] card = new long[n];
		
		for(int i=0;i<n;i++) { 
			card[i] = sc.nextLong(); // 데이터의 입력역시 nextLong()을 사용해야 한다.
		}
			
		if(n==1) { // n이 1일 경우는 0번 인덱스만 출력해주면 된다.
			System.out.println(card[0]);
			return;
		}
		Arrays.sort(card); // 입력받은 데이터를 오름차순 정렬
		
		int cnt =1 , a_cnt=0; // cnt는 데이터에 따라 증가하는 변수, a_cnt는 최대 갯수를 저장 할 변수
		long ans=0; // 정답을 출력 할 변수, 이 역시 long형에 주의해야 한다.
		
		for(int i=0;i<n-1;i++) { // 탐색은 n-2까지 탐색한다.
			
			if(i ==n-2) { // n-2인 경우
				
				if(card[i] == card[i+1]) // 마지막 원소가 같다면 cnt 증가 
					cnt++;
                // 마지막 원소가 다르다면 고려해 줄 필요가 없다.
				if(a_cnt<cnt) { // 최대 카운트 수가 현재 카운트된 수보다 작다면
					a_cnt = cnt; // 최대 카운트 수 변경
					ans = card[i]; // 해당 정수를 ans변수에 저장
					cnt =1;
				}else if(a_cnt == cnt) { // 같다면 이미 저장된 값과 비교하여 최솟값을 저장
					ans = Math.min(ans, card[i]);
				}
			}
			else if(card[i] == card[i+1]) { // 현재 정수와 다음 정수가 같다면 cnt증가
				cnt++;
			}
			else { // 현재 정수와 다음 정수가 다르다면
				
				if(a_cnt<cnt) { // 위의 조건문과 동일
					a_cnt = cnt;
					ans = card[i];
					cnt =1;
					
				}else if(a_cnt == cnt) {
					ans = Math.min(ans, card[i]);
					a_cnt = cnt;
					cnt=1;
				}else { // 위 두 조건에 걸리지 않으면 cnt변수만 초기화 해준다.
					cnt =1;
				}
			}
		}
		
		
		System.out.println(ans);
		
		
	}

}
