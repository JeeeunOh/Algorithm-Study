package 스택_큐_덱;

import java.util.*;
import java.io.*;

public class ex10025 {
	public static void main(String[] args) throws Exception{
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       StringTokenizer st = new StringTokenizer(br.readLine());
	       int N = Integer.parseInt(st.nextToken());   	// 얼음양동이
	       int M = Integer.parseInt(st.nextToken()); 		// 좌표, 거리
	       
	       int[] ice = new int[1000000];
	       int max = 0, start=0, end=0, sum=0,ans = 0;
	       
	       for ( int i = 0 ; i < N ; i++){
	           st = new StringTokenizer(br.readLine());
	           int val = Integer.parseInt(st.nextToken());
	           int idx = Integer.parseInt(st.nextToken());
	           ice[idx] = val;                           // 좌표별 얼음 무게 저장       
	           max  = Math.max(max,idx );      // 얼음의 최종 좌표 저장
	          }
	       
	       while(end<= max) {
	     	  sum += ice[end];
	     	  ans = Math.max(sum, ans);
	     	  end++;
	     	  
	     	  if(end>M*2) {
	     		  sum -= ice[start];
	     		  start+=1;	  
	     	  } 
	       }
	       System.out.println(ans);	       
	}
}