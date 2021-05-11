package 팀대항전_21Winter;
// 세준이가 안 팔수도 있다는 것 유의
import java.util.*;

public class ex1487 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //  살 의향이 있는 사람들

		int[][]arr = new int[N][2]; // 지불할 최대금액과 배송비
		int price=0; //설정할 금액
		int maxbene=0 ; // 최대 이득
		int bene=0; // 현재 계산하는 이득
		int[] p = new int[N]; // 손님들이 지불하는 금액 입력받기
		
		for (int i=0 ; i<N ; i++) {
			arr[i][0]=sc.nextInt(); // 지불할 최대금액
			arr[i][1]=sc.nextInt(); // 배송비
			p[i]=arr[i][0]; // 오름차순 정리 위한 수열
		}
		
		Arrays.sort(p); // 오름차순
		
		for(int i=0 ; i<N ; i++) { // 가격 올려가며 확인하기 p[i]
			bene=0; // 현재 이득 다시 초기화
			for(int j=0 ; j<N ; j++) {
				// 손님 지불가능 금액>=  현재 설정가격 && 지불가능 금액>배송비 라면
				if(arr[j][0]>=p[i] &&p[i]>arr[j][1]) {
					bene+= p[i];
					bene-=arr[j][1];// + 우리가 설정한 금액 - 배송비
				}
			}
			if(maxbene<bene) { // 전에 계산한 이득보다 현재 계산한 이득이 더 크다면
				maxbene=bene; // 최대 이득 바꿔주고
				price = p[i]; // 출력할 price 갱신해줌
			}
		}
		System.out.println(price); // 이익 만들어주는 가격 출력
	}
}
