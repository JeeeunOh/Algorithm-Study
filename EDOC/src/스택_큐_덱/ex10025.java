package ����_ť_��;

import java.util.*;
import java.io.*;
// ������ ���
public class ex10025 {
	public static void main(String[] args) throws Exception{
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       StringTokenizer st = new StringTokenizer(br.readLine());
	       int N = Integer.parseInt(st.nextToken());   	// �����絿��
	       int K = Integer.parseInt(st.nextToken()); 	// �̵��ݰ�
	       
	       int[] ice = new int[1000001];
	       int max = 0;
	       
	       for ( int i = 0 ; i < N ; i++){
	           st = new StringTokenizer(br.readLine());
	           int val = Integer.parseInt(st.nextToken());
	           int idx = Integer.parseInt(st.nextToken());
	           ice[idx] = val;                           // idx��ǥ�� val��ŭ�� ������ ����ִ�.
	           max  = Math.max(max,idx );      // �ִ���ǥ�� max�� �����Ѵ�.
	          }
	       
	       int end=0, sum=0,start=0,ans = 0;
	       while(end<= max) { // end�� �ִ���ǥ�� ������ ������ ���� �۾� �ݺ�
	     	  sum += ice[end]; //sum�� ���� ��ǥ�� ���� ���� ���ϰ�
	     	  ans = Math.max(sum, ans); // ������ �� �ִ� ����
	     	  end++; 
	     	  if(end>K*2) { // ����� �¿� K�� �̵��� �� �����Ƿ�,  ������ǥ > ����̵��ݰ� �̸�,
	     		  sum -= ice[start]; // �ݰ��� �ʰ��� ��ŭ ���ش�.
	     		  start++;
	     	  } 
	       }
	       System.out.println(ans);	       
	}
}