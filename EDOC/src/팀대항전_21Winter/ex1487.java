package ��������_21Winter;
// �����̰� �� �ȼ��� �ִٴ� �� ����
import java.util.*;

public class ex1487 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //  �� ������ �ִ� �����

		int[][]arr = new int[N][2]; // ������ �ִ�ݾװ� ��ۺ�
		int price=0; //������ �ݾ�
		int maxbene=0 ; // �ִ� �̵�
		int bene=0; // ���� ����ϴ� �̵�
		int[] p = new int[N]; // �մԵ��� �����ϴ� �ݾ� �Է¹ޱ�
		
		for (int i=0 ; i<N ; i++) {
			arr[i][0]=sc.nextInt(); // ������ �ִ�ݾ�
			arr[i][1]=sc.nextInt(); // ��ۺ�
			p[i]=arr[i][0]; // �������� ���� ���� ����
		}
		
		Arrays.sort(p); // ��������
		
		for(int i=0 ; i<N ; i++) { // ���� �÷����� Ȯ���ϱ� p[i]
			bene=0; // ���� �̵� �ٽ� �ʱ�ȭ
			for(int j=0 ; j<N ; j++) {
				// �մ� ���Ұ��� �ݾ�>=  ���� �������� && ���Ұ��� �ݾ�>��ۺ� ���
				if(arr[j][0]>=p[i] &&p[i]>arr[j][1]) {
					bene+= p[i];
					bene-=arr[j][1];// + �츮�� ������ �ݾ� - ��ۺ�
				}
			}
			if(maxbene<bene) { // ���� ����� �̵溸�� ���� ����� �̵��� �� ũ�ٸ�
				maxbene=bene; // �ִ� �̵� �ٲ��ְ�
				price = p[i]; // ����� price ��������
			}
		}
		System.out.println(price); // ���� ������ִ� ���� ���
	}
}
