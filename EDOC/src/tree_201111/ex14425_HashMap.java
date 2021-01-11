package tree_201111;

import java.util.*;

public class ex14425_HashMap { // 해시맵 풀이
	static HashMap<String, Integer> map; // 문자열들 검색하기 위한 해시맵
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); // 몇개의 문자열 입력할 것인지
		int n = sc.nextInt(); // 몇개의 문자열 탐색할 것인지
		int num=0;
		map = new HashMap();
		for(int i = 0 ; i < m ; i++ ) {
			map.put(sc.next(), 1); // 입력한 문자열을 키로 하는 해시맵
		}
		for (int i = 0 ;i < n; i++) {
			String str = sc.next(); // str입력 받고
			if(map.get(str) != null) // 그 str을 키로 하는 해시맵이 있는가?
				num++; // 없으면 num++;
		}
		System.out.println(num);
	}
}