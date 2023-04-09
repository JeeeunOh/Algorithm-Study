package map_set_������;
//���� �Է¹ް�, ������ �������� ���������� ���
import java.io.*;
import java.util.*;

//���ڿ�, �ؽø�
public class ex4358 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		HashMap<String, Integer> ts = new HashMap<String, Integer>();
		int num=0;
		while(true) {
            ts.put(str, ts.getOrDefault(str, 0) + 1);
			num++;
			str = br.readLine();
			if(str == null || str.length() == 0) { // �Է��� ������ �׸��ϱ�
				break;
			}
		}
		// Ű �������� ���� 
		Object[] ks = ts.keySet().toArray();
		Arrays.sort(ks);
		//���
		StringBuilder sb = new StringBuilder();
		for(Object k : ks) {
			String k_str = (String) k;
			int count = ts.get(k_str);
			double per = (double)(count * 100.0) / num;
			sb.append(k_str + " " + String.format("%.4f", per) + "\n");	// �Ҽ��� 4�� ° �ڸ����� ��� 
		}
		System.out.println(sb.toString());
	}
}