package ����_ť_��;
//��� �� ������ ������� �ʰų�, )�� �Է� �޾��� �� ���ÿ� (�� �������� �ʴ´ٸ�
//NO, �װ� �ƴ϶�� YES

import java.util.*;

public class ex9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int check1=0; //�տ� '('�� ������� �˷���
		int check2=1; // ) üũ�� �μ�
		for (int i=0 ; i<num ; i++) {
			Queue<String> q = new LinkedList<>();
			q.add(sc.next());
			while(!q.isEmpty()) { //ť�� ������� �ʰ�,
				if ((q.peek()).equals(')')) { // ù��° ���Ұ� ')' �̸�
					if(check1>0) { //�տ� ( �� �Ѱ� �̻��̸�
						q.remove();
						check1--; // (, ) �Ѵ� �����ְ� �Ѿ
					}
					else { // �տ� ( �� ������
						check2=-1; // üũ����Ʈ false�� �ٲ���
						continue;
					}
				}
				else { //ù��° ���Ұ� ( �̸�
					q.remove();//�ش� ( �����ְ�
					check1++; 
				}
			}
			if (check1>0 || check2==-1) System.out.println("NO");
			else System.out.println("YES");
			check1=check2=0; //üũ �ʱ�ȭ
		}
	}
}
