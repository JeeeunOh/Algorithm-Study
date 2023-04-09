package ����_ť_��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class ex10845 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());
        Queue<String> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "push":
                    q.add(st.nextToken());
                break;

                case "pop":
                    if(q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.remove()).append("\n");
                break;

                case "size":
                    sb.append(String.valueOf(q.size())).append("\n");
                break;

                case "empty":
                    if(q.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                break;

                case "front": //���� �� ����
                    if(q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.peek()).append("\n");
                break;
                
                case "back": // ���� ������ ����
                    if(q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.poll()).append("\n");
                break;
            }
        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
	}
}
