package EPPER;

import java.util.*;

public class ex15_7 {
	  public static int solution(int s[], int e[], int num){      
	      int answer = 0, N = num; // N은 학생 수 입니다.
	      int i, j, tmp, e1 = -1, e2 = -1; // e1, e2는 각 자리를 의미합니다.
	      
	      for(i = 0; i < N; i++){ // 학생들을 종료시간 오름차순으로 정렬합니다.
	          for(j = 0; j < N - 1; j++){ // 동일 케이스는 시작시간 오름차순입니다.
	              if((e[j] > e[j + 1]) || (e[j] == e[j + 1] && s[j] > s[j + 1])){ 
	                  // 버블 정렬, 현재와 다음 학생의 시간을 교환합니다.
	                  tmp = s[j];
	                  s[j] = s[j + 1];
	                  s[j + 1] = tmp;
	                  tmp = e[j];
	                  e[j] = e[j + 1];
	                  e[j + 1] = tmp;
	              }
	          }
	      }
	      
	      for(i = 0; i < N; i++){ // 학생 수 만큼 반복합니다.
	          if(e1 <= s[i]){ // 1번 자리가 비어있다면 학생을 할당합니다.
	              e1 = e[i]; // 1번 자리에 학생의 종료 시간을 대입합니다.
	              answer++; // 학생이 1명 할당 되었으니 ++를 사용하여 answer += 1 을 합니다.
	          }else if(e2 <= s[i]){ // 2번 자리가 비어 있다면 학생을 할당합니다.
	              e2 = e1; // 이미 자리에 할당된 학생의 종료 시간을 보존합니다.
	              e1 = e[i]; // 1번 자리에 학생의 종료 시간을 대입합니다.
	              answer++; // 학생이 1명 할당 되었으니 ++를 사용하여 answer += 1 을 합니다.
	          }
	      }
	      
	      return answer; // 학생이 할당된 횟수를 저장한 answer를 반환합니다.
	  }
	  
	  public static void main(String args[]) {
		  Scanner sc = new Scanner(System.in);
		  int N = sc.nextInt();
		    int s[] = new int[N];
		    int e[] = new int[N];
		    for(int i=0 ; i<N ; i++) s[i]=sc.nextInt();
		    for(int i=0 ; i<N ; i++) e[i]=sc.nextInt();
		    System.out.println(solution(s, e, N));
	  } 
	}
