package ������_����������;

import java.util.*;

public class ex1253 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)  arr[i] = sc.nextInt();
        Arrays.sort(arr); // ����
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            int target = arr[i];
            while (left < right) {
                int cal = arr[left] + arr[right];
                if (cal < target)  left++;
                else if (cal > target)  right--;
                else { // cal==target �� ��
                    if (i != left && i != right) { // �� ���� �ڽŰ� ������ �ȵǱ� ������
                        cnt++;
                        break;
                    }
                    else if (left == i) left++;
                    else if (right == i) right--;
                }
            }
        }
        System.out.println(cnt);
    }
}
