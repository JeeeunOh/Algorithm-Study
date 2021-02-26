package 정렬_이분탐색;
// 이분탐색
import java.util.*;

public class ex2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(); // 나무의 수 N
        int m = sc.nextInt(); // 상근이가 집으로 가져가려고 하는 나무의 길이 M

        int[] arr = new int[n]; // 나무의 높이 저장
        for (int i = 0; i <n ; i++)  arr[i] = sc.nextInt(); 

        int max = 0;
        Arrays.sort(arr); // 높이 순서대로 저장

        int left =1; // 절단기 최소 높이
        int right =arr[n-1]; // 절단기 최대 높이 -> 나무 최대 높이
        long height =0;
        int mid =0;
        int ans=0;
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
