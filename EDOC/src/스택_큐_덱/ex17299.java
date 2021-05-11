package 스택_큐_덱;

import java.util.*;
import java.io.*;

public class ex17299{
    public static void main(String args[]) throws IOException {
        Stack<Integer> s = new Stack<Integer>(); // 등장 횟수 비교 -> 스택
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수열 크기
        int[] a = new int[n]; // 수열 저장 배열
        int[] f = new int[1000001]; // 등장 횟수 배열
        int[] ngf = new int[n]; // 오등큰수 저장 배열
        
        for(int i = 0; i < n; i++) { // 수열 만들기
            a[i] = sc.nextInt();
            f[a[i]] +=1; // 해당 숫자 count++ 해주기
        }
        
        s.push(0); // 처음 인덱스는 그냥 넣고
        for (int i = 1; i < n; i++) {
            if(s.isEmpty())  s.push(i); // 스택 비어있으면 바로 지금 인덱스 저장
            while(!s.isEmpty() && f[a[s.peek()]] < f[a[i]]) { 
            	 // 오등큰수 발견 시
                ngf[s.pop()] = a[i]; // 해당 인덱스에 위치한 수의 오등큰수를 저장함
            }
            // 반복 끝나면, 다음에 비교할 값 stack에 저장
            s.push(i);
        }
        // 최종 스택에 남아있는 숫자들의 오등큰수는 존재 x -> -1 값 넣어줌
        while(!s.isEmpty())  ngf[s.pop()] = -1; 
        for (int i=0 ; i< n ; i ++) System.out.print(ngf[i]+" ");
    }
}