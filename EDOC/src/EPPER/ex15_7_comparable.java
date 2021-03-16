package EPPER;

// 백준 회의실 배정과 똑같은 문제

import java.util.*; 

public class ex15_7_comparable {
	public static class Person implements Comparable<Person>{
		int start; // 시작시간
		int end; // 끝나는시간
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
	      int answer = 0, N = num; 
	      int i, j, tmp, e1 = -1, e2 = -1;
	      
	      Arrays.sort(p); // 위에서 조건 정한대로 정렬
	      
	      for(i = 0; i < N; i++){
	          if(e1 <= p[i].start){ // 1번 좌석 비어있다면, 
	              e1 = p[i].end; // 이용 끝나는 시간을 해당학생 끝나는 시간으로 재설정
	              answer++;
	          }else if(e2 <= p[i].start){ //1번 좌석이 차 있을 때, 2번 좌석이 비어있다면
	        	  // e2=p[i].end 는 오류남
	        	  e2 = e1; 
	              e1 = p[i].end; //2번좌석에 사람 집어넣고, 1번과 2번 좌석 사람을 바꿈
	              answer++;
	          }
	      }
	      return answer; 
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
