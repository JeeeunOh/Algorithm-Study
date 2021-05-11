package ����_ť_��;

import java.util.*;
import java.io.*;

public class ex17299{
    public static void main(String args[]) throws IOException {
        Stack<Integer> s = new Stack<Integer>(); // ���� Ƚ�� �� -> ����
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // ���� ũ��
        int[] a = new int[n]; // ���� ���� �迭
        int[] f = new int[1000001]; // ���� Ƚ�� �迭
        int[] ngf = new int[n]; // ����ū�� ���� �迭
        
        for(int i = 0; i < n; i++) { // ���� �����
            a[i] = sc.nextInt();
            f[a[i]] +=1; // �ش� ���� count++ ���ֱ�
        }
        
        s.push(0); // ó�� �ε����� �׳� �ְ�
        for (int i = 1; i < n; i++) {
            if(s.isEmpty())  s.push(i); // ���� ��������� �ٷ� ���� �ε��� ����
            while(!s.isEmpty() && f[a[s.peek()]] < f[a[i]]) { 
            	 // ����ū�� �߰� ��
                ngf[s.pop()] = a[i]; // �ش� �ε����� ��ġ�� ���� ����ū���� ������
            }
            // �ݺ� ������, ������ ���� �� stack�� ����
            s.push(i);
        }
        // ���� ���ÿ� �����ִ� ���ڵ��� ����ū���� ���� x -> -1 �� �־���
        while(!s.isEmpty())  ngf[s.pop()] = -1; 
        for (int i=0 ; i< n ; i ++) System.out.print(ngf[i]+" ");
    }
}