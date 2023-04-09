package map_set_정수론;
//나무 입력받고, 나무별 분포비율 사전순으로 출력
import java.io.*;
import java.util.*;

//문자열, 해시맵
public class ex4358 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		HashMap<String, Integer> ts = new HashMap<String, Integer>();
		int num=0;
		while(true) {
            ts.put(str, ts.getOrDefault(str, 0) + 1);
			num++;
			str = br.readLine();
			if(str == null || str.length() == 0) { // 입력이 없으면 그만하기
				break;
			}
		}
		// 키 오름차순 정렬 
		Object[] ks = ts.keySet().toArray();
		Arrays.sort(ks);
		//출력
		StringBuilder sb = new StringBuilder();
		for(Object k : ks) {
			String k_str = (String) k;
			int count = ts.get(k_str);
			double per = (double)(count * 100.0) / num;
			sb.append(k_str + " " + String.format("%.4f", per) + "\n");	// 소수점 4번 째 자리까지 출력 
		}
		System.out.println(sb.toString());
	}
}