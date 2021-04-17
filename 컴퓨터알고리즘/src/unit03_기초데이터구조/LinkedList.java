package unit03_���ʵ����ͱ���;

//����Ʈ��� ����
class ListNode{
    private String data;    // ������ ���� ����
    public ListNode link;    // �ٸ� ��带 ������ ��ũ ���
    
    public ListNode() {
        this.data = null;
        this.link = null;
    }
    
    public ListNode(String data) {
        this.data = data;
        this.link = null;
    }
    
    public ListNode(String data, ListNode link) {
        this.data = data;
        this.link = link;
    }
    
    public String getData() {
        return this.data;
    }
}

//���Ḯ��Ʈ ����
public class LinkedList {
    private ListNode head;    // ListNode Ÿ���� head ��� �ν��Ͻ� ����
    
    // LinkedList ������
    public LinkedList() {
        head = null;    // head ��� �ʱ�ȭ
    }
    
    // Node ���� (�߰��� ����)
    public void insertNode(ListNode preNode, String data) {       
        ListNode newNode = new ListNode(data);    // ���ο� ��� ����
        newNode.link = preNode.link;
        preNode.link = newNode;
    }
    
    // Node ���� (�������� ����)
    public void insertNode(String data) {
        ListNode newNode = new ListNode(data);    // ���ο� ��� ����
        if(head == null)  this.head = newNode;
        else { // head�� null�� �ƴ� ���
            ListNode tempNode = head;
            while(tempNode.link != null) {
                tempNode = tempNode.link;    // ���� ��带 ����
            }
            tempNode.link = newNode;
        }
    }
    
    // Node ����(�߰� ��� ����)
    public void deleteNode(String data) {
        ListNode preNode = head;
        ListNode tempNode = head.link; 
        if(data.equals( preNode.getData() )) {
            head = preNode.link;
            preNode.link = null;
        } else {
            while(tempNode != null) {
                if(data.equals( tempNode.getData() )) {
                    if(tempNode.link == null) {
                        preNode.link = null;
                    } else {
                        preNode.link = tempNode.link;
                        tempNode.link = null;
                    }
                    break;
                } else {
                    preNode = tempNode;
                    tempNode = tempNode.link;
                }
            }
        }
    }
    
    // Node ����(������ ��� ����)
    public void deleteNode() {
        ListNode preNode;
        ListNode tempNode;
        
        // head ��尡 null�� ��� ��� ��尡 �����Ǿ����Ƿ� return
        if(head == null) {
            return;
        } 
        if(head.link == null) {
            head = null;
        } else {
            preNode = head;
            tempNode = head.link;     

            while(tempNode.link != null) {
                preNode = tempNode;
                tempNode = tempNode.link;
            }
            preNode.link = null;
        }
    }
    
    // Node Ž��
    public ListNode searchNode(String data) {
        ListNode tempNode = this.head;    // temp ��忡 head�� ����Ű�� ù ��° �Ҵ�.
        
        while(tempNode != null) {
            if(data.equals(tempNode.getData())) {
                return tempNode;
            } else {
                tempNode = tempNode.link;
            }
        }
        
        return tempNode;
    }
    // ����Ʈ�� ��带 �������� ����
    public void reverseList() {
        ListNode nextNode = head;    // head�� �����ϴ� ù��° ��带 �Ҵ�.
        ListNode currentNode = null;
        ListNode preNode = null;
        
        // nextNode�� ���������� �̵��ϸ� currentNode�� link�� preNode�� �����ϵ��� ��.
        // 1) preNode�� currentNode ��ġ�� �̵�
        // 2) currentNode�� nextNode ��ġ�� �̵�
        // 3) nextNode�� ���� ��� ��ġ�� �̵�
        // 4) currentNode�� link�� preNode�� �����ϵ��� ��
        while(nextNode != null) {
            preNode = currentNode;    // preNode�� currentNode ��ġ�� �̵�
            currentNode = nextNode;    // currentNode�� nextNode ��ġ�� �̵�
            nextNode = nextNode.link;    // nextNode�� ���� ��� ��ġ�� �̵�
            currentNode.link = preNode;    // currentNode�� link�� preNode�� �Ҵ��Ͽ� �������� ����
        }
        head = currentNode;    // currentNode�� ������ ��带 ����ų ��, head�� currentNode�� �����ϵ��� ��.
    }
    // ���� ����Ʈ�� ����� ��� �����͸� ���
    public void printList() {
        ListNode tempNode = this.head;    // tempNode�� head�� ����Ű�� ù��° ��带 �Ҵ�
        // tempNode�� null�� �ƴ� ������ �ݺ��Ͽ� ���
        while(tempNode != null) {
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.link;    // temp ��忡 ���� ���(tempNode.link) �Ҵ�.
        }
        System.out.println();
    }
 
    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();    // ���� ����Ʈ ����
        String str = "wed";
        
        linkedList.insertNode("sun");  linkedList.insertNode("mon");
        linkedList.insertNode("tue"); linkedList.insertNode("wed");
        linkedList.insertNode("thu");  linkedList.insertNode("fri");
        linkedList.insertNode("sat"); linkedList.printList();
        
        System.out.println(linkedList.searchNode(str).getData());
        
        linkedList.deleteNode(linkedList.searchNode(str).getData());
        linkedList.printList();
        
        str = "sun";
        
        linkedList.deleteNode(linkedList.searchNode(str).getData());
        linkedList.printList();
        
        linkedList.reverseList();
        linkedList.printList();
    }
    
}