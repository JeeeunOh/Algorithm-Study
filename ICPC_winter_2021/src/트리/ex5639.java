package Æ®¸®;
import java.io.IOException;
import java.util.Scanner;
 
public class ex5639 {
    static int arr[] = new int[10001];
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node root = new Node(N);
        while(sc.hasNext()) {
            try {
                N = sc.nextInt();
                root = insertNode(root, N);
            } catch (Exception e) {
                // TODO: handle exception
                break;
            }
            
        }
        postOrder(root);
    }
    
    public static class Node{
        Node left;
        Node right;
        int val;
        public Node(int v) {
            this.val = v;
        }
        
    }
    public static Node insertNode(Node node, int N) {
        Node current = null;
        if(node == null) {
            return new Node(N);
        }
        
        if(node.val > N) {
            current = insertNode(node.left, N);
            node.left = current;
        }else {
            current = insertNode(node.right, N);
            node.right = current;
        }
        return node;
    }
    
    public static void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.val);
        }
    }
}