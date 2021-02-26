package 정렬_이분탐색;
// 수열 A 주어졌을 때, 가장 긴 증가하는 부분 수열 구하기
import java.io.*;
import java.util.*;

public class ex12738{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 증가수열을 저장할 리스트
        List<Integer> list = new ArrayList<>();
        // 입력된 값을 저장할 배열
        int arr[] = new int[n + 1];

        for(int i = 1 ; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        list.add(Integer.MIN_VALUE);

        for(int i = 1 ; i <= n; i++){
            int num = arr[i]; // arr[i] 기준 탐색
            int left = 1,  right = list.size() - 1;

            // 확인하는 숫자가 증가수열의 마지막 수보다 큰 경우
            // 수열에 추가해준다.
            if(num > list.get(list.size() - 1)) list.add(num);
            // 확인하는 숫자가 증가수열의 마지막 수보다 작은 경우
            else{
                // 숫자의 적당한 위치를 찾아
                // 증가수열의 값을 변경해준다.
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }
                list.set(right, num);
            }
        }
        // 최장 길이 출력
        sb.append(list.size() - 1 + "\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}