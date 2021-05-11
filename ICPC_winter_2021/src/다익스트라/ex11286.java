package 다익스트라;

// https://bumbums.tistory.com/4
// 우선순위 큐라는 알고리즘이 사용됨
// 일반적인 큐 : 먼저 들어온 데이터가 먼저 나감
// 우선순위 큐는 우리가 정한 우선순위 높은 데이터가 먼저  나감

import java.io.*;
import java.util.*;

public class ex11286 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 우선순위 큐 클래스 활용하기
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) ->
     // num1과 num2의 절대값이 같다면 실제 숫자를 기준으로 오름차순으로 정렬해주고, 
      //아니라면 절대값을 기준으로 오름차순으로 정렬되도록 하였다.
        Math.abs(num1) == Math.abs(num2) ? Integer.compare(num1, num2) : Integer.compare(Math.abs(num1), Math.abs(num2))
);
        
        for(int i = 0 ; i < n; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){ // 입력값이 0이면, 배열에서 절댓값 가장 작은 값 출력 후 그 값 배열에서 제거
                if(queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll());
            }else{  // 0 아니면, 배열에 입력값 추가
                queue.add(val);
            }
        }
    }
}