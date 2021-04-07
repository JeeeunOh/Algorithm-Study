package �׸���;
// https://www.acmicpc.net/problem/1071
import java.util.*;

public class boj1071 {
	static int[] arr;
	
	public static void swap(int a, int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		for(int i=0 ; i<n ; i++) arr[i]=sc.nextInt();
		
		Arrays.sort(arr);  // ���������� ���� �տ��ִ� �� ���� ��� ���� �������� �迭
		
		int k;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i + 1] == arr[i] + 1) { // arr[i]��  arr[i+1]�� ���ӵ� �� �϶�
				// arr[i], arr[i+1]�� �������Ƿ�, ������ ���ǿ� ������� �ʴ� arr[k]���� ã�� ���� �� ���� index���� Ž��
				// �� �� index���� Ž���ϸ� ���������� ���� �տ� �ִ� ��쿡 ����ǹǷ� �ں��� Ž����
				for (k = i + 2; k < n; k++) if (arr[k] != arr[i + 1]) break; // arr[i]+1�� ���� ���� �� arr[k]�� ã�� �ݺ��� ����
				if (k == n) { //k==n�̶�� ���� ������ i�� �ڿ��� ������ ������ �����ϴ� kã�� ���� ���� arr[i]+1�� ���� ���� ���� ���ٸ�
					for (k = i; k >= 0; k--) if (arr[k] != arr[i]) break; //i�� ���� Ž���ؼ� ������� ���� ���� ���� ã�´�
					swap(i+1, k + 1); // ã�Ƴ� ���� ���� �ٲ�
				}
				else swap(i+1, k); // k!=n�̸� 
			}
		}
	
		for(int i=0 ; i<n ; i++) System.out.println(arr[i]); //���
	}
}
