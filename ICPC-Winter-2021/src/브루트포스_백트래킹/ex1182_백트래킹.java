package ���Ʈ����_��Ʈ��ŷ;
// ��Ʈ��ŷ : ������ ������ �� ��� ������ ���� ���캻��.
import java.util.Scanner;

public class ex1182_��Ʈ��ŷ {
    private static int N, S, count = 0;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        S = scanner.nextInt();

        scanner.nextLine();
        String input = scanner.nextLine();

        arr = new int[N];
     // �迭 �������
        for (int i = 0; i < N; i++)  arr[i] = Integer.parseInt(input.split(" ")[i]); 
        for (int i = 0; i < N; i++) backtracking(arr[i], i); 

        System.out.println(count);
    }

    private static void backtracking(int total, int depth) {
        if (depth == N - 1 && total == S)  count++; 
        // ������ ������ Ž���� �� ���� ��� dep++
        depth++;
        if (depth < N) { // ���� ��ġ ���� �����ϰų�, �������� �ʰų�
            backtracking(total + arr[depth], depth);
            backtracking(total, depth);
        }
    }
}