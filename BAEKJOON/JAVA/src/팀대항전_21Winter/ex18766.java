package ��������_21Winter;
// ī��ٲ�ġ�� �ؽø����� ����
import java.util.*;

public class ex18766 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer>map = new HashMap<String,Integer>();
		int T = sc.nextInt();
		
		for(int i=0 ; i<T ; i++) {
			int n = sc.nextInt();
			int tf=0; // not cheater
			// �Է¹ޱ�
			for (int j=0 ; j<n ; j++) {
				String a = sc.next();
				if(map.containsKey(a)) map.put(a, map.get(a)+1);
				else map.put(a, 1);
			}
			
			//�Ǻ��ϱ�
			for (int j=0 ; j<n ; j++) {
				String a = sc.next();
				// �ش�Ű�� �����ϰ�
				if(map.containsKey(a)) {
					// value�� 0�̶�� -> cheat
					if (map.get(a)==0) {
						tf=1;
					}
					// ī�� �����Ѵٸ�, ī�� �ϳ� ���ش�.
					else map.put(a, map.get(a)-1);
				}
				// �ش�Ű�� �������� ������ -> cheat
				else {
					tf=1;
				}
			}
			if(tf==1) System.out.println("CHEATER");
			else System.out.println("NOT CHEATER");
			
		}
	}
}
