 package map_set_정수론;

import java.io.*;
import java.util.*;
 
public class ex4358_간략 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Double> map = new HashMap<>();
        double sum = 0;
        String input = "";
        while ((input=br.readLine())!=null) { // 입력 없을 때까지 입력받음
            if (map.containsKey(input)) {
                map.replace(input, map.get(input) + 1); // 나무 이름을 키로 한 정수에 그 전 나무 개수 +1  을 저장.
            } else   map.put(input, 1.0);  //존재하지 않으면, 나무 이름을 키로 한 정수는 1
            sum++; // 총 나무 개수 계산 위한 sum
        }
        // 정렬 위해 리스트 만들고, 사전식 배열
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
 
        //list 내 모든 나무 출력
        for (String ans : list) {
            bw.write(ans + " " + String.format("%.4f", (map.get(ans) * 100 / sum))+"\n");
        }
        bw.flush();
    }
}
 
