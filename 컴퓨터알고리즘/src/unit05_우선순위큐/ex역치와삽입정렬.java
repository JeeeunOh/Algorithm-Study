package unit05_�켱����ť;

import java.util.*;

// ��������, ���ڸ�����

public class ex��ġ�ͻ������� {
	static int MAX_SIZE = 15;
	static int[] list = new int[MAX_SIZE];

//�������� 
static int insertion_sort() {
	int i, j, save;
	int cnt=0;
	for(i = 1; i < MAX_SIZE ; i++) {
		save = list[i];
		j=i-1;
		while(j>=0 && list[j]<save) { 
			// ������ �Ǵ� i �ٷ� ������ �迭 ó������ Ž���ϴµ� �̶� list[j]<save�϶� ��� list[j]�� list[j+1]�� �ű�鼭 save�� �ڸ��� ã�´�.
			list[j+1]=list[j];
			j--;
			cnt++;
		}
		list[j+1]=save; //�ڸ��� ã�Ƽ� while���� ���������� save�� �ش��ڸ��� �����Ѵ�.
	}
	
	for(int k= 0 ; k<MAX_SIZE ; k++) System.out.printf("%d ", list[k]);
	return cnt;
}

	public static void main(String[] args) {
		// ��������
		for(int i = 0 ; i<MAX_SIZE ; i++) {
			Random ran = new Random();
			list[i] = ran.nextInt(MAX_SIZE)+1;
			for(int j = 0 ; j < i ; j++) {
				if(list[i] == list[j]) i--;
			}
		}
		System.out.println("---�������� ��---");
		for(int i = 0 ; i<MAX_SIZE ; i++) System.out.printf("%d ", list[i]);
		System.out.println();
		
		System.out.println("---�������� ��---");
		int cnt = insertion_sort();
		System.out.println();
		System.out.printf("%d���� ������ �ʿ��ϴ�.", cnt);
	}
}
