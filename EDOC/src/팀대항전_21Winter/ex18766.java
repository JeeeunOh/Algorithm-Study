package 팀대항전_21Winter;
// 카드바꿔치기 해시맵으로 구현
import java.util.*;

public class ex18766 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer>map = new HashMap<String,Integer>();
		int T = sc.nextInt();
		
		for(int i=0 ; i<T ; i++) {
			int n = sc.nextInt();
			int tf=0; // not cheater
			// 입력받기
			for (int j=0 ; j<n ; j++) {
				String a = sc.next();
				if(map.containsKey(a)) map.put(a, map.get(a)+1);
				else map.put(a, 1);
			}
			
			//판별하기
			for (int j=0 ; j<n ; j++) {
				String a = sc.next();
				// 해당키가 존재하고
				if(map.containsKey(a)) {
					// value가 0이라면 -> cheat
					if (map.get(a)==0) {
						tf=1;
					}
					// 카드 존재한다면, 카드 하나 빼준다.
					else map.put(a, map.get(a)-1);
				}
				// 해당키가 존재하지 않으면 -> cheat
				else {
					tf=1;
				}
			}
			if(tf==1) System.out.println("CHEATER");
			else System.out.println("NOT CHEATER");
			
		}
	}
}
