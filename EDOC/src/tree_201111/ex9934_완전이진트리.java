package tree_201111;

//���� �Է��� ������ȸ
//��������Ʈ������
//k�־��� -> k���� Ʈ�� -> ������ȣ 1~2��k����-1
//������ȯ �������� �� ��Ī���� ��Ÿ���� ���� �̿���

/*����
3
1 6 4 3 5 2 7
*/

import java.util.*;

public class ex9934_��������Ʈ�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tree[][] = new int[11][2048]; // tree �迭 ����
		int arr[] = new int[2048];
		int i=2, t=0, j=0;
		
		int level = sc.nextInt(); //�������� �Է¹ޱ�
		int tmp=level; // �� ������ ����
		
		for(int k=0 ; k<Math.pow(2, level)-1; k++) { // �Է¹ޱ�
			arr[k] = sc.nextInt();
		}
		while(true) {
			if (level<=0) break;
			for (int n=0; n<Math.pow(2, level); n++) {
				tree[level][j] = arr[n*i+t]; // level�� // 0��° ~ ������ �Է¹��� ���� ���Ĵ�� Ʈ���� ����
				j++; 
			}
			i *= 2;
	        t = (t+1)*2 - 1;
	        j = 0;//���ҵ� �Է¹޴� ����
	        level--; //�� ���� �� �Է¹ޱ����� ����
		}
		
		tree[level][0] = arr[(int)Math.pow(2, tmp) / 2 - 1]; // Ʈ���� 0��° ���� 0���� ���Ҵ� ������ ����. //Ʈ���� ���� �����
		
		while(level++!= tmp) // Ʈ���� ����� ���� ���������� ��� ��� -> ��� �� ���
	    {
	        
	        for (int n = 0; tree[level][n] != 0; n++)
	            System.out.print(tree[level][n]+" ");
	        if(level!=tmp)
	        	System.out.println();
	    }
	}
}
















