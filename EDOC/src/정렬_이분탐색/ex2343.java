package 정렬_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        int max = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
            sum += array[i];
            if (array[i] > max){
                max = array[i];
            }
        }

        int left = max;
        int right = sum;
        int ans = 0;
        while(left <= right){
            int mid = (left + right) / 2;

            if (check(mid, M, array)){
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        System.out.println(ans);

    }

    private static boolean check(int size, int m, int[] array) {
        int cnt = 1;
        int sum = 0;
        for(int a : array){
            if (sum + a > size){
                cnt++;
                sum = a;
            }else {
                sum += a;
            }
        }
        return cnt <= m;
    }
}
