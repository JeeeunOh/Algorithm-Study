package 그래프;

// 최단거리문제와 유사 -> BFS로 풀이가능
// BFS 는 큐, DFS 는 재귀!
// 수빈이는 걷거나 순간이동 가능, 수빈이 위치 x 에서 걷는다면 x-1. x+1 이동하고 순간이동 한다면 2*x의 위치로 이동할 수 있다.
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Scanner;

	public class ex1697  {
	    static int N;
	    static int K;
	    static int[] check = new int[100001];

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        N = sc.nextInt();
	        K = sc.nextInt();

	        if (N == K) System.out.println(0); 
	        else  bfs(N); 
	    }

	    static void bfs(int num) {
	        Queue<Integer> q = new LinkedList<>();
	        q.add(num);
	        check[num] = 1;

	        while (!q.isEmpty()) {
	            int temp = q.poll();

	            for (int i = 0; i < 3; i++) {
	                int next;

	                if (i == 0)    next = temp + 1;
	                else if (i == 1)  next = temp - 1;
	                else next = temp * 2;

	                if (next == K) {
	                    System.out.println(check[temp]);
	                    return;
	                }

	                if (next >= 0 && next < check.length && check[next] == 0) {
	                    q.add(next);
	                    check[next] = check[temp] + 1;
	                }
	            }
	        }
	    }
	}