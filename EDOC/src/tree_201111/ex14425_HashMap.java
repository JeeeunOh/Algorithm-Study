package tree_201111;

import java.util.*;

public class ex14425_HashMap { // �ؽø� Ǯ��
	static HashMap<String, Integer> map; // ���ڿ��� �˻��ϱ� ���� �ؽø�
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); // ��� ���ڿ� �Է��� ������
		int n = sc.nextInt(); // ��� ���ڿ� Ž���� ������
		int num=0;
		map = new HashMap();
		for(int i = 0 ; i < m ; i++ ) {
			map.put(sc.next(), 1); // �Է��� ���ڿ��� Ű�� �ϴ� �ؽø�
		}
		for (int i = 0 ;i < n; i++) {
			String str = sc.next(); // str�Է� �ް�
			if(map.get(str) != null) // �� str�� Ű�� �ϴ� �ؽø��� �ִ°�?
				num++; // ������ num++;
		}
		System.out.println(num);
	}
}