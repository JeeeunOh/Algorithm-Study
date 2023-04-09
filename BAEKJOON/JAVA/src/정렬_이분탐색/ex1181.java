package 정렬_이분탐색;

import java.io.*;
import java.util.*;

public class ex1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		List<String> n = new ArrayList<String>(20010);
		for(int i =0; i<T; i++){
			String temp= br.readLine();
			if(!n.contains(temp))
			n.add(temp);
		}
		Comparator<String> myComparator = new Comparator<String>() {
			public int compare(String x, String y) {
				if(x.length()>y.length()) return 1; 
				else if(x.length()==y.length()) return x.compareTo(y); 
				return -1;
			}
		};
		Collections.sort(n, myComparator);
		for(int i =0; i<n.size(); i++) System.out.println(n.get(i)); 
	}
}