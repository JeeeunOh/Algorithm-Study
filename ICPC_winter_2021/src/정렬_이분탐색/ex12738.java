package ����_�̺�Ž��;
// ���� A �־����� ��, ���� �� �����ϴ� �κ� ���� ���ϱ�
import java.io.*;
import java.util.*;

public class ex12738{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // ���������� ������ ����Ʈ
        List<Integer> list = new ArrayList<>();
        // �Էµ� ���� ������ �迭
        int arr[] = new int[n + 1];

        for(int i = 1 ; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        list.add(Integer.MIN_VALUE);

        for(int i = 1 ; i <= n; i++){
            int num = arr[i]; // arr[i] ���� Ž��
            int left = 1,  right = list.size() - 1;

            // Ȯ���ϴ� ���ڰ� ���������� ������ ������ ū ���
            // ������ �߰����ش�.
            if(num > list.get(list.size() - 1)) list.add(num);
            // Ȯ���ϴ� ���ڰ� ���������� ������ ������ ���� ���
            else{
                // ������ ������ ��ġ�� ã��
                // ���������� ���� �������ش�.
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }
                list.set(right, num);
            }
        }
        // ���� ���� ���
        sb.append(list.size() - 1 + "\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}