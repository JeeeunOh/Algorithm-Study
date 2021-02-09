package 그래프트리_210210;

 // 1+ 2+ 4+ 8+...
// 어려운점 : 트리도 어려운데 분할정복이라 더 어려움,,젠장

// 인오더와 포스트오더 주어짐 -> 프리오더 찾자
// 인오더 : 좌 -> 루트 -> 우
// 프리오더 : 루트 -> 좌 -> 우
// 포스트오더 : 좌 -> 우 -> 루트
/* 이런식으로 출력 : 풀이를 보니 별로 상관없어보임
 *public void preorder(Node root){
		System.out.print(root.data); //먼저 가운데 출력
		if(root.left!=null) preorder(root.left); //그 다음 왼쪽
		if(root.right!=null) preorder(root.right); //마지막 오른쪽
	}
 */

import java.util.Scanner;
// 난 엄청 고민했는데 왜 코드는 짧은거지 이게 이렇게 쉬울일인가
public class ex2263{
    static int [] inOrder = new int[100000];
    static int [] postOrder = new int[100000];
    static int [] position = new int[100001];
    
    static void solve(int is, int ie, int ps, int pe) {
        if(is>ie || ps>pe) return ;
        int root = postOrder[pe];
        System.out.print(root+" ");
        int inRoot = position[root]; //인오더의 루트 인덱스
        int left = inRoot-is; //포스트오더의 왼쪽 자식의 수
        solve(is, inRoot-1, ps, ps+left-1);
        solve(inRoot+1, ie, ps+left, pe-1);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();    
        
        for(int i=0; i<n; i++)
            inOrder[i] = scan.nextInt();
        for(int i=0; i<n; i++)
            postOrder[i] = scan.nextInt();
        for(int i=0; i<n; i++)
            position[inOrder[i]] = i;
        
        solve(0, n-1, 0, n-1);
    }
 
}








