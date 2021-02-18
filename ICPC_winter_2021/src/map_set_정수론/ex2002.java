package map_set_정수론;

import java.io.*;
import java.util.*;

public class ex2002 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        // 출발점 차들 입력받음
        for(int i=0; i<N; i++) {
            String car_start = br.readLine();
            map.put(car_start, i);
        }
        int[] grade = new int[N];
        // 도착점 차들 입력받음
        for(int i=0; i<N; i++) {
            String car_end = br.readLine();
            grade[i] = map.get(car_end);
        }                                                                                                                                                                                                                                                                                                                                                                           
        // 제일 앞 차부터 기준으로 잡고, 
        //그 차 다음 차부터 매칭값 비교해서 앞 차가 뒤 차보다 순서가 뒤처지면 ans++;
        for(int i=0; i<N-1; i++)
            for(int j=i+1; j<N; j++)
                if(grade[i]>grade[j]) {
                    num++;
                    break;
                }
        System.out.println(num);
    }
}