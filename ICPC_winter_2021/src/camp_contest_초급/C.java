package camp_contest_�ʱ�;

import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // ���� ������ �̷���� ���̰� N�� ����
		int K = Integer.parseInt(st.nextToken()); // ���� ���� K�� ���� ���� ���忬�Ӻκм�������
		
		int[] arr = new int[N];
		int[] max = new int[N]; // ���� ���� ���� 
		int start=0; // ���� ���� �ε��� ����
		int ans=0;
	
		HashMap<Integer, Integer> map = new HashMap(); // ���� ������ �����ϴ� <��, �� ����>
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			if(i>0) max[i]=max[i-1]; // ���� max �� �ʱ�ȭ����
			arr[i]=Integer.parseInt(st.nextToken());
			if(map.containsKey(arr[i])) { // arr[i]�� �̹� �����ϰ�
				if(map.get(arr[i])+1>K) { //�߰��ϸ� �� ������ K���� ���
					for (int j = start ; j<i ; j ++) { //���� �� �ִ� �ε��� ã��
						if(arr[i]==arr[j]) { // j�� ���� �� �ִ� �ε���
							start=j+1; // ���� ���� ������ ���� �� �ִ� �ε��� �������� ����, �������̴� �״��
							break; // ã������ ����
						} else { //���� �� �ִ� �ε��� ã�� ������
							map.put(arr[j], map.get(arr[j])-1); // �� �� ���� ��� map���� ����
							max[i]--; //�׸�ŭ ���� ���� �۾���
						}
					} // �ε��� ã�� �� -->  ���� �� �ִ� �ε��� �������� start���� �ű��, ���� �� ���� -> map(����� , value) ���� x
				} else { // ���� �� �߰��ص� K���� ������
					map.put(arr[i], map.get(arr[i])+1); // ������ arr[i] ����
					max[i]++; // �������� ����
				}
			} else { //arr[i]�� ������ �������� ������
				map.put(arr[i], 1); // �ʿ� �ְ�
				max[i]++; // ���� �߰�
			} 
			ans=Math.max(ans,max[i]);
		}
		System.out.println(ans);
	}
}
