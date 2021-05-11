package ����_�̺�Ž��;
/* �̺�Ž�� ���� ����
 1. �̺�Ž�� �� ������ �Ǿ��־�� ��.->Arryays.sort()
 2. left, right�� mid �� �������ֱ�
 3. mid�� ���ϰ��� �ϴ� �� ��
 4. ���� �� (mid<�� -> left=mid+1 ),  ( mid>�� -> right=mid-1)
 5. left>right ���� �ݺ�
 ; https://chanhuiseok.github.io/posts/baek-22/ �� �� ���� ���� �� �Ǿ� ����
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex2343 {
	static int M;
	static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // ���� ��
        M = Integer.parseInt(st.nextToken()); // ��緹�� ����

        array = new int[N];// ���� ����
        int max = 0;
        int sum = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken()); // ���� ����
            sum += array[i];  // ���� �̺�Ž�� right���ϱ� ����
            if (array[i] > max) max = array[i]; // �ִ밪 ���ϱ�
        }

        int left = max; 
        // ��緹��ũ�� �ּ� -> ��� ��緹�̿� ���� �ϳ��� ���� ; ũ��� ���� ū ����
        int right = sum; 
        // ��緹��ũ�� �ִ� -> �� ��緹�̿� ��� ���� ���� ; ũ��� ���� ����
        int ans = 0; // ans �ʱ�ȭ �� ��
        
        while(left <= right){
            int mid = (left + right) / 2;
            if (check(mid)){ // �ش� ũ���� ��緹�̰� ������ �� �ִ°�?
                ans = mid; // �����ϴٸ� ans �ٲ��ְ�
                right = mid - 1; //Ž�� ���� left~mid-1
            }else   left = mid + 1; //���簡������ �ʴٸ�, Ž������ mid+1 ~ right
        }
        System.out.println(ans);
    }
    
    private static boolean check(int size) { 
        int cnt = 1;
        int sum = 0;
        for(int a : array){ // �������� �����鼭 for��
            if (sum + a > size){ //�ش� �������̸� ������ �� �������̰� �־��� size���� ũ��
            	//�ش� ������ ���� ��緹�̿� ���� ��
                cnt++;
                sum = a; //���� ��緹�� ũ�� ���ϱ� ���� sum�� ���� ���� �������̷� �ʱ�ȭ ����
            }else  sum += a; //sum+a�� �־��� ��緹�� ũ�� ���� ������ sum+=a�� ���ְ� �������� �����
        }
        return cnt <= M; //��緹�� �������� cnt�� ������ �ش� ������ ���� ����
    }
}
