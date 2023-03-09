package 누적합_이중포인터;

import java.util.*;

public class ex1253 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)  arr[i] = sc.nextInt();
        Arrays.sort(arr); // 정렬
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            int target = arr[i];
            while (left < right) {
                int cal = arr[left] + arr[right];
                if (cal < target)  left++;
                else if (cal > target)  right--;
                else { // cal==target 일 때
                    if (i != left && i != right) { // 두 수가 자신과 같으면 안되기 때문에
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
