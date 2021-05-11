package ÇØ½Ã_201202;

import java.util.*;
import java.io.*;

public class ex2776_¾Ï±â¿Õ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T =Integer.parseInt(br.readLine());
		for (int i=0 ; i<T ; i++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j<N;j++) {
				map.put(Integer.parseInt(st.nextToken()), true);
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N;j++) {
				if(map.containsKey(Integer.parseInt(st.nextToken()))){
                    bw.write("1\n");
                }else {
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
