package 다익스트라;

import java.util.*;

// 최소의 강의실 사용해서 모든 수업을 가능하게 해야한다.
//수업시작시간 + 지속시간
	class Class{
	    public int start;
	    public int hour;

	    Class(int start, int hour){
	        this.start = start;
	        this.hour = hour;
	    }
	}
	
public class ex11000 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 몇개의 입력?
		Class[] arr = new Class[n];
		
		// 우선순위 큐 정의
		PriorityQueue <Integer> pq = new PriorityQueue<Integer>();
		
		for (int i=0 ; i<n ; i ++ ) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			arr[i]= new Class(n1,n2);
		}
		
		Arrays.sort(arr, (c1, c2) -> c1.start == c2.start ? c1.hour - c2.hour : c1.start - c2.start);
		 pq.offer(arr[0].hour);
		 
		 for (int i = 1; i < n; i++) {
	            // 우선순위 큐에서 가장 작은 종료 시간과 현재 lectures[i]의 시작 시간을 비교한다.
	            if (pq.peek() <= arr[i].start)  pq.poll(); 
	            pq.offer(arr[i].hour);
	        }
	        // 현재 우선순위 큐에 남아있는 요소의 개수가 필요한 최소한의 강의실 개수이다.
	        System.out.println(pq.size());
		
	}

}
