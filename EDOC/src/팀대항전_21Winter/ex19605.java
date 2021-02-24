package 팀대항전_21Winter;

import java.util.*;

public class ex19605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t = sc.next();
		String s = sc.next();
		String []T = t.split("");
		String []S = s.split("");
		
		int res=0 ; // 0은 없다를 의미

		int len1 =  S.length;
		int len2 =  T.length;
		
		for (int i=0 ; i< len1; i++) { // len1개의 새로운 문자열을 만들것임
			
			String[] news = new String[len1]; // 길이가 len1 인 새로운 스트링 묶음 만듦
			for (int j=0 ; j<len1 ; j++) { //news 0~ len1-1 인덱스에 집어넣기
				if (j+i>=len1) news[j]=S[j+i-len1];
				else news[j]=S[j+i];
			} // 여기까지 출력 잘 됨
			
			for (int j=0 ; j< len2-len1+1; j++) { // T 내부에서
				for(int k=0 ; k<len1 ; k++) { // len1의 길이만큼 탐색
					if(!T[j+k].equals(news[k])) break; // 스트링 글자 다르면 break
					//글자 같으면서 마지막 인덱스에 도착하면 res=1
					if(k==len1-1 && T[j+k].equals(news[k])) {
						res=1;
						break;
					}
				}
			}
		}
		if(res==1) System.out.println("yes");
		else System.out.println("no");
	}
}
