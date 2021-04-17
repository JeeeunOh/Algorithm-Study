package unit03_기초데이터구조;

//리스트노드 구현
class ListNode{
    private String data;    // 데이터 저장 변수
    public ListNode link;    // 다른 노드를 참조할 링크 노드
    
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

//연결리스트 구성
public class LinkedList {
    private ListNode head;    // ListNode 타입의 head 노드 인스턴스 변수
    
    // LinkedList 생성자
    public LinkedList() {
        head = null;    // head 노드 초기화
    }
    
    // Node 삽입 (중간에 삽입)
    public void insertNode(ListNode preNode, String data) {       
        ListNode newNode = new ListNode(data);    // 새로운 노드 생성
        newNode.link = preNode.link;
        preNode.link = newNode;
    }
    
    // Node 삽입 (마지막에 삽입)
    public void insertNode(String data) {
        ListNode newNode = new ListNode(data);    // 새로운 노드 생성
        if(head == null)  this.head = newNode;
        else { // head가 null이 아닌 경우
            ListNode tempNode = head;
            while(tempNode.link != null) {
                tempNode = tempNode.link;    // 다음 노드를 참조
            }
            tempNode.link = newNode;
        }
    }
    
    // Node 삭제(중간 노드 삭제)
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
    
    // Node 삭제(마지막 노드 삭제)
    public void deleteNode() {
        ListNode preNode;
        ListNode tempNode;
        
        // head 노드가 null인 경우 모든 노드가 삭제되었으므로 return
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
    
    // Node 탐색
    public ListNode searchNode(String data) {
        ListNode tempNode = this.head;    // temp 노드에 head가 가리키는 첫 번째 할당.
        
        while(tempNode != null) {
            if(data.equals(tempNode.getData())) {
                return tempNode;
            } else {
                tempNode = tempNode.link;
            }
        }
        
        return tempNode;
    }
    // 리스트의 노드를 역순으로 구성
    public void reverseList() {
        ListNode nextNode = head;    // head가 참조하는 첫번째 노드를 할당.
        ListNode currentNode = null;
        ListNode preNode = null;
        
        // nextNode가 순차적으로 이동하며 currentNode의 link가 preNode를 참조하도록 함.
        // 1) preNode를 currentNode 위치로 이동
        // 2) currentNode는 nextNode 위치로 이동
        // 3) nextNode는 다음 노드 위치로 이동
        // 4) currentNode의 link는 preNode를 참조하도록 함
        while(nextNode != null) {
            preNode = currentNode;    // preNode는 currentNode 위치로 이동
            currentNode = nextNode;    // currentNode는 nextNode 위치로 이동
            nextNode = nextNode.link;    // nextNode는 다음 노드 위치로 이동
            currentNode.link = preNode;    // currentNode의 link에 preNode를 할당하여 역순으로 설정
        }
        head = currentNode;    // currentNode가 마지막 노드를 가리킬 때, head는 currentNode를 참조하도록 함.
    }
    // 연결 리스트에 저장된 모든 데이터를 출력
    public void printList() {
        ListNode tempNode = this.head;    // tempNode에 head가 가리키는 첫번째 노드를 할당
        // tempNode가 null이 아닐 때까지 반복하여 출력
        while(tempNode != null) {
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.link;    // temp 노드에 다음 노드(tempNode.link) 할당.
        }
        System.out.println();
    }
 
    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();    // 연결 리스트 생성
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