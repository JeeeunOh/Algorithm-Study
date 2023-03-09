package map_set_������;

import java.io.*;
import java.util.*;

public class ex2002 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        // ����� ���� �Է¹���
        for(int i=0; i<N; i++) {
            String car_start = br.readLine();
            map.put(car_start, i);
        }
        int[] grade = new int[N];
        // ������ ���� �Է¹���
        for(int i=0; i<N; i++) {
            String car_end = br.readLine();
            grade[i] = map.get(car_end);
        }                                                                                                                                                                                                                                                                                                                                                                           
        // ���� �� ������ �������� ���, 
        //�� �� ���� ������ ��Ī�� ���ؼ� �� ���� �� ������ ������ ��ó���� ans++;
        for(int i=0; i<N-1; i++)
            for(int j=i+1; j<N; j++)
                if(grade[i]>grade[j]) {
                    num++;
                    break;
                }
        System.out.println(num);
    }
}