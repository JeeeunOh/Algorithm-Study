package Ʈ��;

import java.io.*;
import java.util.*;
// ����, ����, ���� ���ʷ� ���
class Node {
	char data;
	Node left, right;
	
	Node(char data){ // �ش� ����� �� ����
		this.data = data;
	}
}

class Tree {
	Node root; //��Ʈ ��� ó���� null ���� 
	
	public void createNode(char data, char leftData, char rightData) {
		if(root==null) {
			if(data != '.') {
				root = new Node(data);
			}
			if(leftData != '.') {
				 root.left = new Node(leftData); 
			}
			if( rightData != '.') {
				 root.left = new Node( rightData); 
			}
		}else { //�ʱ���°� �ƴϸ� ��� �������� ã�ƾ���
			searchNode(root, data, leftData, rightData); 
		}
	}
	
    //���⿡�� root�� �Ű� ������ ���� ���ú��� root���� ���� 
	public void searchNode(Node root, char data, char leftData, char rightData) { 
		//������ ��尡 null�̸� ��� ���� - ã��(������) ��� X
		if(root == null)  return;  
		else if(root.data == data) { //�� ��ġ�� ã�Ҵٸ� 
			//.�� �ƴ϶� ���� �ִ� ��쿡�� �¿� ��� ���� 
			if(leftData != '.')  root.left = new Node(leftData); 
			if(rightData != '.')  root.right = new Node(rightData); 
		}
		else { //���� ã�����߰� Ž���� ��尡 ���� �ִٸ� 
			searchNode(root.left, data, leftData, rightData); //���� ��� Ž�� 
			searchNode(root.right, data, leftData, rightData); //������ ��� Ž�� 
		}
	}
	
	// ������ȸ : ��Ʈ -> �� -> �� 
	public void preorder(Node root){
		System.out.print(root.data); //���� ��� ���
		if(root.left!=null) preorder(root.left); //�� ���� ����
		if(root.right!=null) preorder(root.right); //������ ������
	}
	
	// ������ȸ : �� -> ��Ʈ -> ��
	public void inorder(Node root){
		if(root.left!=null) inorder(root.left); //���� ����
		System.out.print(root.data); //�� ���� �߾� ���
		if(root.right!=null) inorder(root.right); //���������� ������
	}
	
	// ������ȸ : �� -> �� -> ��Ʈ 
	public void postorder(Node root){
		if(root.left!=null) postorder(root.left); //���� ����
		if(root.right!=null) postorder(root.right); //�� ���� ������
		System.out.print(root.data);
	}
	
}

public class  ex1991 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Tree tree = new Tree();

		for(int i = 0; i < N; i++) {
			char[] data;
			// ��ĭ ������� ������� ���� �� ����
			data = br.readLine().replaceAll(" ", "").toCharArray();
			tree.createNode(data[0], data[1], data[2]);
		}
		
		//���� ��ȸ 
		tree.preorder(tree.root);
		System.out.println();
	
		//���� ��ȸ 
		tree.inorder(tree.root);
		System.out.println();
		
		//���� ��ȸ 
		tree.postorder(tree.root);
		
		br.close();
	}

}