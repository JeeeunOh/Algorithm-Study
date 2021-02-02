package 스택_큐_덱;

import java.util.*;
import java.io.*;
// 게으른 백곰
public class ex10025 {
	public static void main(String[] args) throws Exception{
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       StringTokenizer st = new StringTokenizer(br.readLine());
	       int N = Integer.parseInt(st.nextToken());   	// 얼음양동이
	       int K = Integer.parseInt(st.nextToken()); 	// 이동반경
	       
	       int[] ice = new int[1000001];
	       int max = 0;
	       
	       for ( int i = 0 ; i < N ; i++){
	           st = new StringTokenizer(br.readLine());
	           int val = Integer.parseInt(st.nextToken());
	           int idx = Integer.parseInt(st.nextToken());
	           ice[idx] = val;                           // idx좌표에 val만큼의 얼음이 들어있다.
	           max  = Math.max(max,idx );      // 최대좌표를 max에 저장한다.
	          }
	       
	       int end=0, sum=0,start=0,ans = 0;
	       while(end<= max) { // end가 최대좌표와 같아질 때까지 밑의 작업 반복
	     	  sum += ice[end]; //sum에 현재 좌표의 얼음 양을 더하고
	     	  ans = Math.max(sum, ans); // 얼음들 합 최댓값 갱신
	     	  end++; 
	     	  if(end>K*2) { // 백곰이 좌우 K을 이동할 수 있으므로,  현재좌표 > 백곰이동반경 이면,
	     		  sum -= ice[start]; // 반경을 초과한 만큼 빼준다.
	     		  start++;
	     	  } 
	       }
	       System.out.println(ans);	       
	}
}