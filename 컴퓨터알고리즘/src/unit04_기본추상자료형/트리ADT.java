package unit04_�⺻�߻��ڷ���;
// ���⼭�� ����Ʈ��, 38���������� �ٽ� �ϱ�
public class Ʈ��ADT {
	public class Node {
        private int data;
        private Node left;
        private Node right;

        /* ������ */
        public Node(int data){
            this.setData(data);
            setLeft(null);
            setRight(null);
        }


        /* ���� getter / setter */
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
    public Node root;
    BinarySearchTree(){
        root = null;
    }

    /*Ž�� ����*/
    public boolean find(int key){
        Node currentNode = root;
        while(currentNode != null){
            // ���� ���� ã�� ���� ������
            if(currentNode.getData() == key){
                return true;
            }else if(currentNode.getData() > key){ // ã�� ���� ���� ��庸�� ������
                currentNode = currentNode.getLeft();
            }else {// ã�� ���� ���� ��庸�� ũ��
                currentNode = currentNode.getRight();
            }
        }
        return false;
    }

    /*���� ����*/
    public void insert(int data) {
        Node newNode = new Node(data); // ����, ������ �ڽ� ��尡 null �̸� data �� ���� ����� �� ��� ����
        if(root == null){// ��Ʈ ��尡 ������, �� Ʈ���� ����ִ� ������ ��,
            root = newNode;
            return;
        }
        Node currentNode = root;
        Node parentNode = null;

        while(true) {

            parentNode = currentNode;

            if(data < currentNode.getData()) { // �ش� ��庸�� Ŭ ��.
                currentNode = currentNode.getLeft();
                if(currentNode == null) {
                    parentNode.setLeft(newNode);
                    return ;
                }
            }else { // �ش� ��庸�� ���� ��.
                currentNode = currentNode.getRight();
                if(currentNode == null){
                    parentNode.setRight(newNode);
                    return ;
                }
            }
        }

    }

    /*���� ����*/
    public boolean delete(int data){
        Node parentNode = root;
        Node currentNode = root;
        boolean isLeftChild = false;

        while(currentNode.getData() != data) {
            parentNode = currentNode;
            if(currentNode.getData() > data) {
                isLeftChild = true;
                currentNode = currentNode.getLeft();
            }else {
                isLeftChild = false;
                currentNode = currentNode.getRight();
            }
            if(currentNode == null){
                return false;
            }
        }


        if(currentNode.getLeft() == null && currentNode.getRight() == null) { // 1. �ڽ� ��尡 ���� ���
            if(currentNode == root) {
                root = null; // �ش� ��尡 root node�� ���
            }
            if(isLeftChild) {
                parentNode.setLeft(null); // ������ ��尡 �θ� ����� ���� �ڽ��� ���
            }
            else {
                parentNode.setRight(null); // ������ ��尡 �θ� ����� ������ �ڽ��� ���
            }
        } else if(currentNode.getRight() == null){      // 2-1. �ڽ� ��尡 �ϳ��� ���(������ �ڽ��� ���� ��)
            parentNode.setLeft(currentNode.getLeft());
        } else if(currentNode.getLeft() == null) {      // 2-2. �ڽ� ��尡 �ϳ��� ���(���� �ڽ��� ���� ��)
            parentNode.setRight(currentNode.getRight());
        } else {                                        // 3. �ڽ��� ���� ���
                Node minimum = getMinumun(currentNode);
                if(currentNode == root) {
                    root = minimum;
                }else if (isLeftChild){
                    parentNode.setLeft(minimum);
                }else {
                    parentNode.setLeft(currentNode.getLeft());
                }
                minimum.setLeft(currentNode.getLeft());
        }
        return false;
    }

    Node getMinumun(Node deleteNode) {
        Node minimum = null;
        Node minimumParent = null;
        Node currentNode = deleteNode.getRight();
        while(currentNode != null) {
            minimumParent = minimum;
            minimum = minimumParent;
            currentNode = currentNode.getLeft();
        }
        if(minimum != deleteNode.getRight()){
            minimumParent.setLeft(minimum.getRight());
            minimum.setRight(deleteNode.getRight());
        }
        return minimum;
    }
}