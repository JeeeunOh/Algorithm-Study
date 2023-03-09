package ����_ť_��;

import java.util.*;
import java.io.*;

public class ex1158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       Deque<Integer> deque = new ArrayDeque<>();

	        StringBuilder sb = new StringBuilder("<");
	        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

	        int n = Integer.parseInt(st.nextToken());
	        int k = Integer.parseInt(st.nextToken());

	        for (int i = 1; i <= n; i++) deque.add(i);

	        while(!deque.isEmpty()){
	            for (int i = 0; i < k-1; i++) deque.addLast(deque.removeFirst()); 
	            // k��°�� ���� �������� ���� ���� ���� �ڷ� �ű��.
	            sb.append(deque.removeFirst() + ", "); // k��°�� ������ ���� string�� �̾���δ�.
	        }
	        System.out.println(sb.toString().substring(0,sb.length()-2) + ">");
	        // �ϼ��� ��Ʈ�� ���
	    }
	}