package camp_contest_�ʱ�;

import java.util.*;
//�ߺ��ȵǴ� �� ����
		//���� �� > ������ �� -> ����
		// �ѻ���� ��������� ���� ����
public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N+1];
		Arrays.fill(arr, 0); // �ʱ�ȭ
		int num=N-1; //k���� �E ����
		int input=N; //arr�� ������� ����, ������������ �Է���
		int index=1; //��� ���� �����������
		while(K>0) {
			if(K-num<0) {
				arr[N-K]=input;
				break;
			}else { // ����� �����ϴٸ�,
				K-=num; num-=1;
				arr[index]=input;  // input�� ���ϴ� �ε����� �־��ְ�,
				input--; //input��������
				index++; // �����ε����� ���� i++����
			}
		}
		 input=1;
		for(int i=1 ; i<= N ; i++) {
			if(arr[i]==0) { //�迭 �Է°��� ���ٸ� ������������ �־���
				arr[i]=input; input++; 
			}
			System.out.print(arr[i]+" ");
		}
	}

}
