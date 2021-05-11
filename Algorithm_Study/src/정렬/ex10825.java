package ����;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ex10825 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		String[][] arr = new String[N][4];
		
 
		for(int i = 0; i < N; i++) {
			arr[i][0] = in.next();	// �̸�
			arr[i][1] = in.next();	// ����
			arr[i][2] = in.next();	// ����
			arr[i][3] = in.next();	// ����
		}
 
		Arrays.sort(arr, new Comparator<String[]>() {
			// �������� ���� �� ����
			@Override
			public int compare(String[] s1, String[] s2) {
				if(Integer.parseInt(s1[1])==Integer.parseInt(s2[1])) {
					if(Integer.parseInt(s1[2])==Integer.parseInt(s2[2])){
						if(Integer.parseInt(s1[3])==Integer.parseInt(s2[3])) {
							return s1[0].compareTo(s2[0]);
							//String.CompareTo �޼ҵ�
						}
						return Integer.compare(Integer.parseInt(s2[3]), Integer.parseInt(s1[3]));
					}
					return Integer.compare(Integer.parseInt(s1[2]), Integer.parseInt(s2[2]));
				}
				return Integer.compare(Integer.parseInt(s2[1]), Integer.parseInt(s1[1]));
			}
		});
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] );
		}
        
		
	}
 
}
