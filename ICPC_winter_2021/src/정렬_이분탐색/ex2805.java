package ����_�̺�Ž��;
// �̺�Ž��
import java.util.*;

public class ex2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(); // ������ �� N
        int m = sc.nextInt(); // ����̰� ������ ���������� �ϴ� ������ ���� M

        int[] arr = new int[n]; // ������ ���� ����
        for (int i = 0; i <n ; i++)  arr[i] = sc.nextInt(); 

        int max = 0;
        Arrays.sort(arr); // ���� ������� ����

        int left =1; // ���ܱ� �ּ� ����
        int right =arr[n-1]; // ���ܱ� �ִ� ���� -> ���� �ִ� ����
        long height =0;
        int mid =0, ans=0;
        
        while(left <= right){
            height =0;
            mid =(left+right)/2;
            
            for (int i = 0; i <n ; i++)
                if(arr[i]>=mid)  height += (arr[i] -mid);  
            
            if(height >= m)  left = mid + 1;
            else  if(height < m)  right = mid-1; 
        }
        System.out.println(right);
    }
}
