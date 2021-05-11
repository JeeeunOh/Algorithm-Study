package unit05_�켱����ť;

import java.util.*;

// ���ڸ����� - �������� ��������

public class ����_�������� {
	static int MAX_SIZE = 15;
	static int[] list = new int[MAX_SIZE];

//��������; removemin, minKey, minElement�� ����
static void selectionSort() { 
	int indexMin, temp; 
	// �� �ڸ��� ���س��� �� �ڸ��� �� �ּҰ��� Ž���ؼ�
	// �ڸ��� ���ڿ� �ּڰ��� ���ڸ� ��ȯ��
	for (int i = 0; i < list.length-1; i++) { 
		indexMin = i; 
		for (int j = i + 1; j < list.length; j++) { 
			if (list[j] < list[indexMin]) { 
				indexMin = j; 
				} 
			}  
		temp = list[indexMin]; 
		list[indexMin] = list[i]; 
		list[i] = temp;
		} 
	return;
}

//�������� : �ʱ⸮��Ʈ�� ������ �Ǵ� ���� ���ĵ� ��� ; insertItem�� ����
static void insertion_sort() {
	int i, j, save;
	//�迭�� ��� ��Ҹ� �տ������� ���ʴ�� �̹� ���ĵ� �迭�� ��
	for(i = 1; i < MAX_SIZE ; i++) {
		save = list[i];
		j=i-1;
		while(j>=0 && list[j]>save) {
			// �ش� �迭�� �ڸ� ã�Ƴ���
			list[j+1]=list[j];
			j--;
		}
		// �ڸ� ã���� �������
		list[j+1]=save;
	}
	
	for(int k= 0 ; k<MAX_SIZE ; k++) System.out.printf("%d ", list[k]);
	return;
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
		selectionSort();
		for(int i = 0 ; i<MAX_SIZE ; i++) System.out.printf("%d ", list[i]);
		System.out.println();
		
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
		insertion_sort();
		System.out.println();
	}
}
