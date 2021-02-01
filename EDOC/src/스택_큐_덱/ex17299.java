package 스택_큐_덱;

import java.util.*;
import java.io.*;

public class ex17299{
    public static void main(String args[]) throws IOException {
        // 리소스 선언 및 초기화
        Stack<Integer> s = new Stack<Integer>(); // 등장 횟수 비교 시 자료구조(스택) 이용
        
        // input 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] a = new int[n]; // 수열 저장할 배열
        int[] f = new int[1000001]; // 등장한 횟수 저장할 배열 (1<=원소<=1,000,000)
        int[] ngf = new int[n]; // 오등큰수를 저장할 배열
        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < n; i++) { // 수열 만들기
            a[i] = Integer.parseInt(temp[i]);
            f[a[i]] += 1;
        }
        
        s.push(0);
        for (int i = 0; i < n; i++) {
            if(s.isEmpty()) {
                s.push(i);
            }
            while(!s.isEmpty() && f[a[s.peek()]] < f[a[i]]) {
                // 오등큰수 계산
                ngf[s.pop()] = a[i];
            }
            s.push(i);
        }

        while(!s.isEmpty()) {
            // 최종 스택에 남아있는 인덱스들을 기준으로 해당 위치의 a[i]의 오등큰수는 존재하지 않는다.
            ngf[s.pop()] = -1;
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int num : ngf) {
            bw.append(num + " ");
        }
        
        bw.write("\n");
        bw.flush();
        
    }
}