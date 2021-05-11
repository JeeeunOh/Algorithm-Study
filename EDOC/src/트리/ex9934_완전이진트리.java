package 트리;

//예제 입력은 중위순회
//완전이진트리문제
//k주어짐 -> k층의 트리 -> 빌딩번호 1~2의k제곱-1
//중위순환 나열했을 때 대칭구조 나타나는 것을 이용함

/*예제
3
1 6 4 3 5 2 7
*/

import java.util.*;

public class ex9934_완전이진트리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tree[][] = new int[11][2048]; // tree 배열 생성
		int arr[] = new int[2048];
		int i=2, t=0, j=0;
		
		int level = sc.nextInt(); //몇층인지 입력받기
		int tmp=level; // 총 레벨값 저장
		
		for(int k=0 ; k<Math.pow(2, level)-1; k++) { // 입력받기
			arr[k] = sc.nextInt();
		}
		while(true) {
			if (level<=0) break;
			for (int n=0; n<Math.pow(2, level); n++) {
				tree[level][j] = arr[n*i+t]; // level층 // 0번째 ~ 끝까지 입력받은 값을 공식대로 트리에 넣음
				j++; 
			}
			i *= 2;
	        t = (t+1)*2 - 1;
	        j = 0;//원소들 입력받는 공식
	        level--; //그 다음 층 입력받기위한 절차
		}
		
		tree[level][0] = arr[(int)Math.pow(2, tmp) / 2 - 1]; // 트리의 0번째 층의 0번쨰 원소는 다음과 같다. //트리의 제일 꼭대기
		
		while(level++!= tmp) // 트리의 꼭대기 층에 가기전까지 계속 출력 -> 모든 층 출력
	    {
	        
	        for (int n = 0; tree[level][n] != 0; n++)
	            System.out.print(tree[level][n]+" ");
	        if(level!=tmp)
	        	System.out.println();
	    }
	}
}
















