package 팀대항전_21Winter;


import java.util.*;

public class ex19605_함수 {
	static int len1, len2, res;
	static String t,s;
	static String[] T,S;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.next();
		s = sc.next();
		T = t.split("");
		S = s.split("");
		
		res=0 ; // 0은 없다를 의미
		len1 =  S.length;
		len2 =  T.length;
		
		bool();
		
		if(res==1) System.out.println("yes");
		else System.out.println("no");
	}
	public static int bool() {
		for (int i=0 ; i< len1; i++) { // len1개의 새로운 문자열을 만들것임
			
			String[] news = new String[len1]; // 길이가 len1 인 새로운 스트링 묶음 만듦
			
			for (int j=0 ; j<len1 ; j++) { //news 0~ len1-1 인덱스에 집어넣기
				if (j+i>=len1) news[j]=S[j+i-len1];
				else news[j]=S[j+i];
			}
			for (int j=0 ; j< len2-len1; j++) { // T 내부에서
				for(int k=0 ; k<len1 ; k++) { // len1의 길이만큼 탐색
					if(!T[j+k].equals(news[k])) break; // 스트링 글자 다르면 break
					//글자 같으면서 마지막 인덱스에 도착하면 res=1
					if(k==len1-1 && T[j+k].equals(news[k])) return 1; 
				}
			}
		}
		return 0;
	}
}
