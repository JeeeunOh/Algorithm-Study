package ���ͽ�Ʈ��;

// https://bumbums.tistory.com/4
// �켱���� ť��� �˰����� ����
// �Ϲ����� ť : ���� ���� �����Ͱ� ���� ����
// �켱���� ť�� �츮�� ���� �켱���� ���� �����Ͱ� ����  ����

import java.io.*;
import java.util.*;

public class ex11286 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // �켱���� ť Ŭ���� Ȱ���ϱ�
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) ->
     // num1�� num2�� ���밪�� ���ٸ� ���� ���ڸ� �������� ������������ �������ְ�, 
      //�ƴ϶�� ���밪�� �������� ������������ ���ĵǵ��� �Ͽ���.
        Math.abs(num1) == Math.abs(num2) ? Integer.compare(num1, num2) : Integer.compare(Math.abs(num1), Math.abs(num2))
);
        
        for(int i = 0 ; i < n; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){ // �Է°��� 0�̸�, �迭���� ���� ���� ���� �� ��� �� �� �� �迭���� ����
                if(queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll());
            }else{  // 0 �ƴϸ�, �迭�� �Է°� �߰�
                queue.add(val);
            }
        }
    }
}