package 스택_큐_덱;
//계산 후 스택이 비어있지 않거나, )를 입력 받았을 때 스택에 (가 존재하지 않는다면
//NO, 그게 아니라면 YES

import java.util.*;

public class ex9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int check1=0; //앞에 '('가 몇개였는지 알려줌
		int check2=1; // ) 체크용 인수
		for (int i=0 ; i<num ; i++) {
			Queue<String> q = new LinkedList<>();
			q.add(sc.next());
			while(!q.isEmpty()) { //큐가 비어있지 않고,
				if ((q.peek()).equals(')')) { // 첫번째 원소가 ')' 이며
					if(check1>0) { //앞에 ( 가 한개 이상이면
						q.remove();
						check1--; // (, ) 둘다 지워주고 넘어감
					}
					else { // 앞에 ( 가 없으면
						check2=-1; // 체크포인트 false로 바꿔줌
						continue;
					}
				}
				else { //첫번째 원소가 ( 이면
					q.remove();//해당 ( 지워주고
					check1++; 
				}
			}
			if (check1>0 || check2==-1) System.out.println("NO");
			else System.out.println("YES");
			check1=check2=0; //체크 초기화
		}
	}
}
