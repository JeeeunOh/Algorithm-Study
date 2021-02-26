package 정렬_이분탐색;
// 세 용액 // 정렬 이분탐색 투포인터
import java.util.*;
import java.io.*;
 
// https://www.acmicpc.net/problem/2473
 
class ex2473 {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
 
    static long[] pick = new long[3];
    static long max = 3000000000L;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int n = stoi(br.readLine());
        long[] arr = new long[n];
 
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Long.parseLong(st.nextToken());
 
        Arrays.sort(arr);
 
        // index가 i이고 왼쪽, 오른쪽을 좁혀오면서 알맞은 값 갱신
        for(int i=0; i<n-2; i++) solution(arr, i); 
 
        // 정렬
        Arrays.sort(pick);
        
        for(int i=0; i<3; i++)  System.out.print(pick[i] + " ");
    }
 
    static void solution(long[] arr, int index) {
        int left = index+1;
        int right = arr.length-1;
 
        while(left < right) {
            long sum = arr[left] + arr[right] + arr[index];
            long absSum = Math.abs(sum);
 
            // 두 용액 갱신
            if(absSum < max) {
                pick[0] = arr[left];
                pick[1] = arr[right];
                pick[2] = arr[index];
                max = absSum;
            }
 
            if(sum > 0) right--;
            else left++;
        }
    }
}