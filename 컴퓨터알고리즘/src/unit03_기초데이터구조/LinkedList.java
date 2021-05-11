package unit03_���ʵ����ͱ���;

//���Ḯ��Ʈ ����
public class LinkedList {
	//����Ʈ��� ����
	class ListNode{
	    String data;    // ������ ���� ����
	    ListNode link;    // �ٸ� ��带 ������ ��ũ ���
	    
	    ListNode() {
	        this.data = null;
	        this.link = null;
	    }
	    
	    ListNode(String data) {
	        this.data = data;
	        this.link = null;
	    }
	    
	    ListNode(String data, ListNode link) {
	        this.data = data;
	        this.link = link;
	    }
	    
	    String getData() {
	        return this.data;
	    }
	}
    private ListNode head;    // ListNode Ÿ���� head ��� �ν��Ͻ� ����
    
    // LinkedList ������
    LinkedList() {
        head = null;    // init()�Լ� ������ ��ȯ
    }
    
  // Node ���� (ó���� ����)
    void insertFirst(LinkedList l,  String data) {       
        ListNode newNode = new ListNode(data);    // ���ο� ��� ����
        newNode.link = l.head;
    }
    
    // Node ���� (�߰��� ����)
    void insertNode(ListNode preNode, String data) {       
        ListNode newNode = new ListNode(data);    // ���ο� ��� ����
        newNode.link = preNode.link;
        preNode.link = newNode;
    }
    
    // Node ���� (�������� ����)
    void insertNode(String data) {
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
 // Node ����(ó�� ��� ����)
    void deleteFirst(LinkedList L) {    
    	ListNode second = L.head.link; // �ι�°���
    	L.head = second; // �ι�°��带 head�� �ٲ�
    }
    
    // Node ����(�߰� ��� ����)
   void deleteNode(String data) {
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
   void deleteNode() {
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
    //pos�ڸ��� data ��ȯ
    static String  get(LinkedList L, int pos) {
    	ListNode p = L.head;
    	for(int i = 0 ; i < pos ; i++) p = p.link;
    	return p.getData();
    }
    //pos�ڸ��� item ����ֱ�
    static void set(LinkedList L, int pos, String item) {
    	ListNode p = L.head;
    	for(int i = 1 ; i < pos ; i++) p = p.link;
    	p.data = item;
    }
    
    // Node Ž��
    ListNode searchNode(String data) {
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
    void reverseList() {
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
    void printList() {
        ListNode tempNode = this.head;    // tempNode�� head�� ����Ű�� ù��° ��带 �Ҵ�
        // tempNode�� null�� �ƴ� ������ �ݺ��Ͽ� ���
        while(tempNode != null) {
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.link;    // temp ��忡 ���� ���(tempNode.link) �Ҵ�.
        }
        System.out.println();
    }
 
    static void main(String args[]) {
        LinkedList L = new LinkedList();    // ���� ����Ʈ ����
        String str = "wed";
        
        L.insertNode("sun");  L.insertNode("mon");
        L.insertNode("tue"); L.insertNode("wed");
        L.insertNode("thu");  L.insertNode("fri");
        L.insertNode("sat"); L.printList(); // �ѹ� �� ���
        
        System.out.println(L.searchNode(str).getData()); // wed ã�Ƽ� ���
        
        L.deleteNode(L.searchNode(str).getData()); // wedã�Ƽ� ����
        L.printList(); // ���� �� ���
        
        str = "sun";
        
        L.deleteNode(L.searchNode(str).getData()); //sun ���� �� ���
        L.printList();
        
        System.out.println(get(L, 2)); // 2��° �ڸ� ���
        L.printList();
        
        set(L, 2, "new"); // 2��° �ڸ� �ٲٱ�
        L.printList();
        
        L.reverseList();
        L.printList();
    }
    
}