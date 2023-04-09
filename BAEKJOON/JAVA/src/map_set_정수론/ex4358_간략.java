 package map_set_������;

import java.io.*;
import java.util.*;
 
public class ex4358_���� {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Double> map = new HashMap<>();
        double sum = 0;
        String input = "";
        while ((input=br.readLine())!=null) { // �Է� ���� ������ �Է¹���
            if (map.containsKey(input)) {
                map.replace(input, map.get(input) + 1); // ���� �̸��� Ű�� �� ������ �� �� ���� ���� +1  �� ����.
            } else   map.put(input, 1.0);  //�������� ������, ���� �̸��� Ű�� �� ������ 1
            sum++; // �� ���� ���� ��� ���� sum
        }
        // ���� ���� ����Ʈ �����, ������ �迭
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
 
        //list �� ��� ���� ���
        for (String ans : list) {
            bw.write(ans + " " + String.format("%.4f", (map.get(ans) * 100 / sum))+"\n");
        }
        bw.flush();
    }
}
 
