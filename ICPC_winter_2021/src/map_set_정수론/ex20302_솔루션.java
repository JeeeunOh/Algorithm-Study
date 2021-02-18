package map_set_정수론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex20302_솔루션{
    private static int[] head = new int[100_001];
    private static int[] tail = new int[100_001];

    private static ArrayList<Integer> primes = new ArrayList<>();
    private static boolean[] prime = new boolean[100_001];

    private static boolean zeroes;

    private static final char MUL = '*';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        eratosthenes();

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean flag = true;

        for(int i = 0; i < N; i++) {
            int v = Math.abs(Integer.parseInt(st.nextToken()));
            if(zeroes = (v == 0)) break;

            findPrimeFactor(flag, v);

            if(i == N - 1) continue;
            char formula = st.nextToken().charAt(0);

            if(formula == MUL) flag = true;
            else flag = false;
        }

        System.out.println(mintChoco());
    }

    private static String mintChoco(){
        if (zeroes) return "mint chocolate";

        for(int i = 0; i < head.length; i++) {
            if(i != 1 && head[i] < tail[i]) return "toothpaste";
        }

        return "mint chocolate";
    }

    private static void findPrimeFactor(boolean flag, int v){
        if(v == 1 || prime[v]) {
            if(flag) head[v]++;
            else tail[v]++;

            return;
        }

        int target = v;

        for(int p: primes) {
            if(target == 1) break;

            if (prime[target]) {
                if (flag) head[target]++;
                else tail[target]++;

                break;
            }

            while (target % p == 0) {
                if (flag) head[p]++;
                else tail[p]++;

                target /= p;
            }
        }
    }

    private static void eratosthenes() {
        int loop = (int) (Math.sqrt(100_000)) + 1;
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for(int i = 2; i < loop; i++) {
            if(!prime[i]) continue;

            for(int j = i + i; j < head.length; j += i) {
                prime[j] = false;
            }
        }

        for(int i = 0; i < prime.length; i++) {
            if (prime[i]) primes.add(i);
        }
    }
}
