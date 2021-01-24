package 정렬_이분탐색;

import java.util.*;

public class ex1920 {
	static long[] arr;
	static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int low,high,mid=0;
		
		int N = sc.nextInt();
		arr= new long[N];
		for (int i=0 ; i<N ; i++) 
			arr[i]=sc.nextInt();
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		for (int i=0 ; i<M ; i++) {
			m = sc.nextInt();
			System.out.println(BSearch(arr,m));
		}
		
	}
	static int BSearch(long arr[], int target) {
	    int low = 0;
	    int high = arr.length - 1;
	    int mid;
	    
	    while(low <= high) {
	        mid = (low + high) / 2;
	        
	        if (arr[mid] == target)
	            return 1;
	        else if (arr[mid] > target)
	            high = mid - 1;
	        else
	            low = mid + 1;
	    }
	    return 0;
	}
}


