package �׷���Ʈ��_210210;
/*
 ������� : Ʈ���� ���� ���������̶� �� �����,,����
 ���� ) n���� ������ ���� ���� Ʈ���� ������ 1���� n������ ��ȣ�� �ߺ� ���� �Ű��� �ִ�
			�ο����� ����Ʈ���� �־��� -> �������� ã��
Ǫ�� ���)
1. ����Ʈ������ ���� ��Ʈ�� ���ϰ� ���������� ���� ����ؾ��ϹǷ� �ϴ� ���
2. ��Ʈ�� �������� �ο����� ���� �������� ������ ���Ž��
 */

import java.util.Scanner;
// �� ��û ����ߴµ� �� �ڵ�� ª������ �̰� �̷��� �������ΰ�
public class ex2263{
    static int [] inOrder = new int[100000];
    static int [] postOrder = new int[100000];
    static int [] position = new int[100001];
    
   /* - �ο��� : �� -> ��Ʈ -> ��
    -  ����Ʈ���� : �� -> �� -> ��Ʈ : �� �������� �Է� �޴� ���� ��Ʈ�̴�.
    -   - �������� : ��Ʈ -> �� -> �� : ����ؾ��ϴ� ��
    */
    
    
    // �ο��� ���۰� ��, ����Ʈ���� ���۰� ���� �Է¹���
    static void solve(int is, int ie, int ps, int pe) {
        if(is>ie || ps>pe) return ; //�� if���� �ش��ϸ� ��Ͱ� ���� ���̹Ƿ� ��� ����
        int root = postOrder[pe]; // ����Ʈ���� �������� ��Ʈ�� -> ��Ʈ ���
        System.out.print(root+" ");
        int inRoot = position[root]; //�ο����� ��Ʈ �ε��� : ��Ʈ�� �߽����� ��, �� �� ������
        int left = inRoot-is; //����Ʈ������ ���� �ڽ��� ��
        solve(is, inRoot-1, ps, ps+left-1); // ���� �ڽĵ� Ž�� // �� ��Ʈ ��
        solve(inRoot+1, ie, ps+left, pe-1); // ������ �ڽĵ� Ž��
    } // �̷��� Ž���ϴٺ��� ��Ʈ -> �� -> �� ������� Ž���ϸ� �����
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        
        for(int i=0; i<n; i++) inOrder[i] = sc.nextInt();
        for(int i=0; i<n; i++) postOrder[i] = sc.nextInt(); // �ϴ� �ο����� ����Ʈ���� �Է� �ް�
        for(int i=0; i<n; i++)  position[inOrder[i]] = i; // �ο��� ���� ������ ������ ���Ž�� �ؾ� �ϹǷ� inOrder���� ����ִ� �ε��� i�� ������
        
        // �ο���, ����Ʈ���� ��� ���� ����־ �Լ� ���
        solve(0, n-1, 0, n-1);
    }
 
}








