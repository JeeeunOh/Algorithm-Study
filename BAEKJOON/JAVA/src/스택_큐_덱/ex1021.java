package Ω∫≈√_≈•_µ¶;

import java.util.*;
import java.io.*;

public class ex1021 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        LinkedList<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i <= n; ++i)  queue.addFirst(i);
        tokenizer = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < m; ++i) {
            int next = Integer.parseInt(tokenizer.nextToken());
            int r = 0;
            while (queue.isEmpty() || queue.peekLast() != next) {
                queue.addFirst(queue.removeLast());
                ++r;
            }
            count += Math.min(r, queue.size()-r);
            queue.removeLast();
        }
        bw.write(String.valueOf(count));
        bw.write('\n');
        bw.close();
    }
}