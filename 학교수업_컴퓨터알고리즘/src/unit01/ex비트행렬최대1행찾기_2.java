package unit01;
// 실행오류남 확인필요
public class ex비트행렬최대1행찾기_2 {
	static int mostOnes(int[][] A , int n) {
		int i=0, j = 0, row=0;
		while(i<n && j<n) {
			if(i<n-1 && A[i][j]==0) i++;
			else {
				row=i;
				j++;
			}
		}
		return row;
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
