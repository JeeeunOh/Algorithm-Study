package camp_contest_초급;

import java.util.*;
//중복안되는 수 나열
		//왼쪽 수 > 오른쪽 수 -> 성사
		// 한사람이 여러사람과 성사 가능
public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N+1];
		Arrays.fill(arr, 0); // 초기화
		int num=N-1; //k에서 뺼 숫자
		int input=N; //arr에 집어넣을 숫자, 내림차순으로 입력함
		int index=1; //어디에 숫자 집어넣을건지
		while(K>0) {
			if(K-num<0) {
				arr[N-K]=input;
				break;
			}else { // 계산이 가능하다면,
				K-=num; num-=1;
				arr[index]=input;  // input을 원하는 인덱스에 넣어주고,
				input--; //input내림차순
				index++; // 다음인덱스를 위해 i++해줌
			}
		}
		 input=1;
		for(int i=1 ; i<= N ; i++) {
			if(arr[i]==0) { //배열 입력값이 없다면 오름차순으로 넣어줌
				arr[i]=input; input++; 
			}
			System.out.print(arr[i]+" ");
		}
	}

}
