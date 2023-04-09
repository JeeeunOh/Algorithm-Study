package Ω∫≈√_≈•_µ¶;

import java.util.*;
import java.io.*;

public class ex10828 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());
        Stack<String> stk = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "push":
                    stk.push(st.nextToken());
                break;

                case "pop":
                    if(stk.isEmpty()) sb.append("-1\n");
                    else sb.append(stk.pop()).append("\n");
                break;

                case "size":
                    sb.append(String.valueOf(stk.size())).append("\n");
                break;

                case "empty":
                    if(stk.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                break;

                case "top":
                    if(stk.isEmpty()) sb.append("-1\n");
                    else sb.append(stk.peek()).append("\n");
                break;
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
	}

}
