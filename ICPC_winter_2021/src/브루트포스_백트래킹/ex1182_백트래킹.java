package 브루트포스_백트래킹;
// 백트래킹 : 조건이 만족할 때 모든 조합의 수를 살펴본다.
import java.util.Scanner;

public class ex1182_백트래킹 {
    private static int N, S, count = 0;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        S = scanner.nextInt();

        scanner.nextLine();
        String input = scanner.nextLine();

        arr = new int[N];
     // 배열 저장받음
        for (int i = 0; i < N; i++)  arr[i] = Integer.parseInt(input.split(" ")[i]); 
        for (int i = 0; i < N; i++) backtracking(arr[i], i); 

        System.out.println(count);
    }

    private static void backtracking(int total, int depth) {
        if (depth == N - 1 && total == S)  count++; 
        // 수열을 끝까지 탐색할 떄 까지 계속 dep++
        depth++;
        if (depth < N) { // 지금 위치 원소 선택하거나, 선택하지 않거나
            backtracking(total + arr[depth], depth);
            backtracking(total, depth);
        }
    }
}