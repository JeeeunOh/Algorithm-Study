package 정렬;

import java.util.*;

public class 정렬_2751 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		for(int value : list) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
	}
}

