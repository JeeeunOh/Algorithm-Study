package 정렬_이분탐색;
/* 이분탐색 간단 정리
 1. 이분탐색 전 정렬이 되어있어야 함.->Arryays.sort()
 2. left, right로 mid 값 설정해주기
 3. mid와 구하고자 하는 값 비교
 4. 비교할 시 (mid<구 -> left=mid+1 ),  ( mid>구 -> right=mid-1)
 5. left>right 까지 반복
 ; https://chanhuiseok.github.io/posts/baek-22/ 에 이 문제 설명 잘 되어 있음
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex2343 {
	static int M;
	static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 레슨 수
        M = Integer.parseInt(st.nextToken()); // 블루레이 개수

        array = new int[N];// 레슨 길이
        int max = 0;
        int sum = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken()); // 레슨 길이
            sum += array[i];  // 후의 이분탐색 right구하기 위함
            if (array[i] > max) max = array[i]; // 최대값 구하기
        }

        int left = max; 
        // 블루레이크기 최소 -> 모든 블루레이에 강의 하나씩 담음 ; 크기는 제일 큰 강의
        int right = sum; 
        // 블루레이크기 최대 -> 한 블루레이에 모든 강의 담음 ; 크기는 강의 총합
        int ans = 0; // ans 초기화 해 줌
        
        while(left <= right){
            int mid = (left + right) / 2;
            if (check(mid)){ // 해당 크기의 블루레이가 존재할 수 있는가?
                ans = mid; // 가능하다면 ans 바꿔주고
                right = mid - 1; //탐색 범위 left~mid-1
            }else   left = mid + 1; //존재가능하지 않다면, 탐색범위 mid+1 ~ right
        }
        System.out.println(ans);
    }
    
    private static boolean check(int size) { 
        int cnt = 1;
        int sum = 0;
        for(int a : array){ // 레슨길이 받으면서 for문
            if (sum + a > size){ //해당 레슨길이를 포함한 총 레슨길이가 주어진 size보다 크면
            	//해당 레슨은 다음 블루레이에 들어가야 함
                cnt++;
                sum = a; //다음 블루레이 크기 구하기 위해 sum을 현재 받은 레슨길이로 초기화 해줌
            }else  sum += a; //sum+a가 주어진 블루레이 크기 넘지 않으면 sum+=a를 해주고 다음과정 계속함
        }
        return cnt <= M; //블루레이 개수보다 cnt가 작으면 해당 사이즈 존재 가능
    }
}
