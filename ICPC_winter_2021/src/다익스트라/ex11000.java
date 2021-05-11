package ���ͽ�Ʈ��;

import java.util.*;

// �ּ��� ���ǽ� ����ؼ� ��� ������ �����ϰ� �ؾ��Ѵ�.
//�������۽ð� + ���ӽð�
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
		int n = sc.nextInt(); // ��� �Է�?
		Class[] arr = new Class[n];
		
		// �켱���� ť ����
		PriorityQueue <Integer> pq = new PriorityQueue<Integer>();
		
		for (int i=0 ; i<n ; i ++ ) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			arr[i]= new Class(n1,n2);
		}
		
		Arrays.sort(arr, (c1, c2) -> c1.start == c2.start ? c1.hour - c2.hour : c1.start - c2.start);
		 pq.offer(arr[0].hour);
		 
		 for (int i = 1; i < n; i++) {
	            // �켱���� ť���� ���� ���� ���� �ð��� ���� lectures[i]�� ���� �ð��� ���Ѵ�.
	            if (pq.peek() <= arr[i].start)  pq.poll(); 
	            pq.offer(arr[i].hour);
	        }
	        // ���� �켱���� ť�� �����ִ� ����� ������ �ʿ��� �ּ����� ���ǽ� �����̴�.
	        System.out.println(pq.size());
		
	}

}
