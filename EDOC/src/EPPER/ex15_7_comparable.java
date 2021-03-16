package EPPER;

// 백준 회의실 배정과 똑같은 문제

import java.util.*; 

public class ex15_7_comparable {
	public static class Person implements Comparable<Person>{
		int start;
		int end;
		public Person(int start, int end) {
			this.start=start;
			this.end=end;
		}
		 @Override
		 // 종료시간 오름차순 정렬 후 같으면 시작시간 오름차순
		    public int compareTo(Person p){
		    	if(this.end!=p.end)  return this.end-p.end; 
		    	else  return this.start-p.start;
		    }
	}
	
	  public static int solution(Person p[], int num){      
	      int answer = 0, N = num; // N은 학생 수
	      int i, j, tmp, e1 = -1, e2 = -1; // e1, e2는 각 자리를 의미합니다.
	      
	      Arrays.sort(p);	      
	      
	      for(i = 0; i < N; i++){
	          if(e1 <= p[i].start){ // 1번 자리가 비어있다면 학생을 할당합니다.
	              e1 = p[i].end; // 1번 자리에 학생의 종료 시간을 대입합니다.
	              answer++; 
	          }else if(e2 <= p[i].start){ // 2번 자리가 비어 있다면 학생을 할당합니다.
	              e2 = e1; // 이미 자리에 할당된 학생의 종료 시간을 보존합니다.
	              e1 = p[i].end; // 1번 자리에 학생의 종료 시간을 대입합니다.
	              answer++;
	          }
	      }
	      return answer; // 학생이 할당된 횟수를 저장한 answer를 반환합니다.
	  }
	  
	  public static void main(String args[]) {
		  Scanner sc = new Scanner(System.in);
		  int N = sc.nextInt();
		  
		  int s[] = new int[N];
		  int e[] = new int[N];
		  Person[] p = new Person[N];
		  for(int i=0 ; i<N ; i++) s[i]=sc.nextInt();
		  for(int i=0 ; i<N ; i++) e[i]=sc.nextInt();
		  for(int i=0 ; i<N ; i++) p[i]=new Person(s[i], e[i]);
		  
		  System.out.println(solution(p, N));
	  } 
	}
