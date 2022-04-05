package unit01;

public class ex행렬특정원소찾기 {
	static int findRow(int[] A, int x) {
		int i = 0 ;
		while(i<A.length) {
			if (x==A[i]) return i;
			else i++;
		}
		return -1;
	}
	
	static void findMatrix(int[][] A, int x) {
		int r=0;
		while(r<A[0].length) {
			int i=findRow(A[r],x);
			if(i>=0) {
				System.out.println("found at "+ r + ", " + i);
				return;
			} else r++;
		}
		System.out.println("not found");
		return;
	}
	
	public static void main(String[] args) {
		int n = 10;
		int arr = 0;
		int[][] A = new int[5][5];
		for (int i = 0  ; i< 5 ; i ++) {
			for ( int j = 0 ; j<5 ; j++) {
				A[i][j]=arr;
				System.out.printf("%3d ", arr);
				arr++;
			}
			System.out.println();
		}
		findMatrix(A,n);
	}
}
