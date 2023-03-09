package 정렬_이분탐색;

import java.util.Arrays;
import java.util.Scanner;
 
public class ex1026{
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int[] A = new int[n];
        int[] B = new int[n];
 
        for (int i = 0; i < n; i++)  A[i] = sc.nextInt(); 
        for (int i = 0; i < n; i++) B[i] = sc.nextInt(); 
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 서로 역방향이 되어 큰값과 작은값이 곱해질 때이다. 
        int sum = 0;
        for (int i = 0; i < n; i++)  sum += A[i] * B[n - 1 - i]; 
        System.out.println(sum);
 
    }
}


