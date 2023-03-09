package 그래프;

import java.io.*;
import java.util.*;

public class ex16953 {
   static int A,B;
   static HashMap<Long, Integer> map = new HashMap<>();
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st=  new StringTokenizer(br.readLine());
       A = Integer.parseInt(st.nextToken());
       B = Integer.parseInt(st.nextToken());
       int val = bfs();
       if(val == -1) System.out.println(val);
       else  System.out.println(val+1);
   }
   public static int bfs() { // 큐 -> DFS
       Queue<Po> queue = new LinkedList<Po>();
       queue.add(new Po(A,0));
       while(!queue.isEmpty()) {
           Po p = queue.poll();
           //System.out.println(po.x + " " +po.y);
           if(p.val == B) return p.cnt; 
           if(p.val * 2 <= B && !map.containsKey(p.val*2)) {
               map.put(p.val*2, p.cnt+1);
               queue.add(new Po(p.val*2, p.cnt+1));
           }
           if(p.val*10 + 1 <= B && !map.containsKey(p.val*10 +1)) {
               map.put(p.val*10 + 1, p.cnt+1);
               queue.add(new Po(p.val*10 + 1, p.cnt+1));
           }
       }
       return -1;
   }
   public static class Po{
       long val;
       int cnt;
       public Po(long v, int c) {
           this.val=v;
           this.cnt=c;
       }
   }
}