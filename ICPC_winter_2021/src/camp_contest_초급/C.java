package camp_contest_초급;

import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 양의 정수로 이루어진 길이가 N인 수열
		int K = Integer.parseInt(st.nextToken()); // 같은 정수 K개 이하 포함 최장연속부분수열길이
		
		int[] arr = new int[N];
		int[] max = new int[N]; // 현재 수열 길이 
		int start=0; // 수열 시작 인덱스 저장
		int ans=0;
	
		HashMap<Integer, Integer> map = new HashMap(); // 현재 수열에 존재하는 <수, 그 개수>
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			if(i>0) max[i]=max[i-1]; // 지금 max 값 초기화해줌
			arr[i]=Integer.parseInt(st.nextToken());
			if(map.containsKey(arr[i])) { // arr[i]이 이미 존재하고
				if(map.get(arr[i])+1>K) { //추가하면 그 개수가 K넘을 경우
					for (int j = start ; j<i ; j ++) { //같은 수 있는 인덱스 찾기
						if(arr[i]==arr[j]) { // j가 같은 수 있는 인덱스
							start=j+1; // 수열 시작 지점은 같은 수 있는 인덱스 다음부터 시작, 수열길이는 그대로
							break; // 찾았으니 종료
						} else { //같은 수 있는 인덱스 찾기 전까지
							map.put(arr[j], map.get(arr[j])-1); // 그 전 수열 모두 map에서 빼줌
							max[i]--; //그만큼 수열 길이 작아짐
						}
					} // 인덱스 찾기 끝 -->  같은 수 있는 인덱스 다음으로 start지점 옮기고, 현재 수 포함 -> map(현재수 , value) 변동 x
				} else { // 현재 수 추가해도 K넘지 않으면
					map.put(arr[i], map.get(arr[i])+1); // 수열에 arr[i] 넣음
					max[i]++; // 수열길이 증가
				}
			} else { //arr[i]이 수열에 존재하지 않으면
				map.put(arr[i], 1); // 맵에 넣고
				max[i]++; // 길이 추가
			} 
			ans=Math.max(ans,max[i]);
		}
		System.out.println(ans);
	}
}
