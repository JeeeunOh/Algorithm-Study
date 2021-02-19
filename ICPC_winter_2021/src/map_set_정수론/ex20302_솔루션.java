package map_set_정수론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 1. 모든 합성수는 소인수분해를 통해 소수의 곱으로 표현할 수 있고, 
 * 그 개수들을 카운트하기 위해 소수들의 개수를 담는 배열을 사용합니다. 
 * 또한 정수, 유리수 판별에 음수 여부는 관계없으므로 편의를 위해 모두 양수로 바꿔줍니다.

2. 곱하는 수는 소인수 분해하여 표현된 소수들의 개수를 올려주고, 
나누는 수는 소인수 분해하여 표현된 소수들의 개수를 빼주어 그 개수들을 관리할 수 있습니다. 
(곱하는 수 중 0이 존재한다면 항상 결과는 0이므로 이는 따로 처리해줍니다.)

3. 모든 수를 소인수분해하고나서 구간[2, 1e5] 소수 배열을 순회하는데 
그 값이 음수인 경우 분모에 수가 남게 되는 것이므로 이는 유리수라고 판정할 수 있고, 
그 외는 정수라고 출력하면 됩니다.
 */

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
