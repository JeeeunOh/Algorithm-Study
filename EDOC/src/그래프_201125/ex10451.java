package 그래프_201125;

import java.util.*;

public class ex10451{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int testCase=sc.nextInt();

		for (int i = 0; i < testCase; i++) {
            List<Node> list = new ArrayList<>();
            int n = sc.nextInt();
            int[] visited = new int[n + 1];
            Arrays.fill(visited, -1); // 방문한 노드 표시
            int answer = 0;
            for (int k = 0; k < n + 1; k++) {
                list.add(new Node());
            }
            for (int j = 1; j <= n; j++) {
                int val = sc.nextInt();
                list.get(j).child.add(val);
            }
            for (int j = 1; j <= n; j++) {
                // 이미 방문한 노드
                if (visited[j] == -1) {
                    answer += bfs(list, visited, j);
                }
            }
            System.out.println(answer);
        }
    }

    public static int bfs(List<Node> list, int [] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;
        while (!q.isEmpty()) {
            int index = q.poll();
            for (int val : list.get(index).child) {
                if(visited[val] == -1) {
                    q.offer(val);
                }
                visited[val] = 1;
            }
        }
        return 1;
    }

    static class Node {
        List<Integer> child = new ArrayList<>();
    }
}