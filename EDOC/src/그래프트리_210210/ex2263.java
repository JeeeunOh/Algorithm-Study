package 그래프트리_210210;
/*
 어려운점 : 트리도 어려운데 분할정복이라 더 어려움,,젠장
 문제 ) n개의 정점을 갖는 이진 트리의 정점에 1부터 n까지의 번호가 중복 없이 매겨져 있다
			인오더와 포스트오더 주어짐 -> 프리오더 찾자
푸는 방법)
1. 포스트오더의 끝을 루트로 정하고 프리오더로 답을 출력해야하므로 일단 출력
2. 루트를 기준으로 인오더의 왼쪽 오른쪽을 나눠서 재귀탐색
 */

import java.util.Scanner;
// 난 엄청 고민했는데 왜 코드는 짧은거지 이게 이렇게 쉬울일인가
public class ex2263{
    static int [] inOrder = new int[100000];
    static int [] postOrder = new int[100000];
    static int [] position = new int[100001];
    
   /* - 인오더 : 좌 -> 루트 -> 우
    -  포스트오더 : 좌 -> 우 -> 루트 : 맨 마지막에 입력 받는 것이 루트이다.
    -   - 프리오더 : 루트 -> 좌 -> 우 : 출력해야하는 것
    */
    
    
    // 인오더 시작과 끝, 포스트오더 시작과 끝을 입력받음
    static void solve(int is, int ie, int ps, int pe) {
        if(is>ie || ps>pe) return ; //이 if문에 해당하면 재귀가 끝난 것이므로 재귀 종료
        int root = postOrder[pe]; // 포스트오더 마지막이 루트임 -> 루트 출력
        System.out.print(root+" ");
        int inRoot = position[root]; //인오더의 루트 인덱스 : 루트를 중심으로 좌, 우 가 나눠짐
        int left = inRoot-is; //포스트오더의 왼쪽 자식의 수
        solve(is, inRoot-1, ps, ps+left-1); // 왼쪽 자식들 탐색 // 좌 루트 우
        solve(inRoot+1, ie, ps+left, pe-1); // 오른쪽 자식들 탐색
    } // 이렇게 탐색하다보면 루트 -> 좌 -> 우 순서대로 탐색하며 출력함
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        
        for(int i=0; i<n; i++) inOrder[i] = sc.nextInt();
        for(int i=0; i<n; i++) postOrder[i] = sc.nextInt(); // 일단 인오더와 포스트오더 입력 받고
        for(int i=0; i<n; i++)  position[inOrder[i]] = i; // 인오더 왼쪽 오른쪽 나눠서 재귀탐색 해야 하므로 inOrder값이 들어있는 인덱스 i를 저장함
        
        // 인오더, 포스트오더 모든 범위 집어넣어서 함수 계산
        solve(0, n-1, 0, n-1);
    }
 
}








