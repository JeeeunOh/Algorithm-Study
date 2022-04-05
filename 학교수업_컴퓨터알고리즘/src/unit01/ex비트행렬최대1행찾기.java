package unit01;

public class ex비트행렬최대1행찾기 {
	// 최대 2n회의 비교 -> O(N)알고리즘
	static int mostOnes(int[][] A , int n) {
		int i=0, j = 0;
		while(true) {
			while(A[i][j]==1) {
				j++;
				if(j==n-1) return i;
			}
			int row=i;
			while(A[i][j]==0) { // 0나오면 열 유지하면서 다음행으로 넘어감
				i++;
				if(i==n-1) return row;
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 8;
		int[][] A = { {1,1,1,1,0,0,0,0},
				{1,1,1,1,1,0,0,0},
				{1,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,0,0},
				{0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,0},
				{1,1,1,1,1,0,0,0} };
		int res = mostOnes(A, n);
		System.out.println("가장 1이 많은 행은 "+res);
	}
}
