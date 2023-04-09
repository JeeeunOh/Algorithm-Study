package map_set_정수론;

import java.io.*;
import java.util.*;

public class ex20302{
    private static ArrayList<Integer> primes = new ArrayList<>();
    private static boolean[] p = new boolean[100_001];
    private static int[] start = new int[100_001];
    private static int[] end = new int[100_001];
    private static boolean zero;
    private static boolean flag;
    
    private static void Calc() {
        int n = (int) (Math.sqrt(100_000)) + 1;
        Arrays.fill(p, true);

        p[0] = p[1] = false;
        for(int i = 2; i < n; i++) {
            if(!p[i]) continue;
            for(int j = i + i; j < start.length; j += i) {
                p[j] = false;
            }
        }
        for(int i = 0; i < p.length; i++) {
            if (p[i]) primes.add(i);
        }
    }
    
    private static void prime(boolean flag, int v){
        if(v == 1 || p[v]) {
            if(flag) start[v]++;
            else end[v]++;
            return;
        }
        int cur = v;

        for(int pp: primes) {
            if(cur == 1) break;
            if (p[cur]) {
                if (flag) start[cur]++;
                else end[cur]++;
                break;
            }

            while (cur % pp == 0) {
                if (flag) start[pp]++;
                else end[pp]++;
                cur /= pp;
            }
        }
    }
    
    private static String mintChoco(){
        if (zero) return "mint chocolate";
        for(int i = 0; i < start.length; i++) {
            if(i != 1 && start[i] < end[i]) return "toothpaste";
        }
        return "mint chocolate";
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //계산하기
        Calc();

        for(int i = 0; i < N; i++) {
            int dm = Math.abs(sc.nextInt());
            if(zero = (dm == 0)) break;

            prime(flag, dm);

            if(i == N - 1) continue;
            char s = sc.next().charAt(0);

            if(s == '*') flag = true;
            else flag = false;
        }
        System.out.println(mintChoco());
    }
}
