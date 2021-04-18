package unit03_기초데이터구조;

//연결리스트 구성
public class LinkedList {
	//리스트노드 구현
	class ListNode{
	    String data;    // 데이터 저장 변수
	    ListNode link;    // 다른 노드를 참조할 링크 노드
	    
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
    private ListNode head;    // ListNode 타입의 head 노드 인스턴스 변수
    
    // LinkedList 생성자
    LinkedList() {
        head = null;    // init()함수 생성시 소환
    }
    
  // Node 삽입 (처음에 삽입)
    void insertFirst(LinkedList l,  String data) {       
        ListNode newNode = new ListNode(data);    // 새로운 노드 생성
        newNode.link = l.head;
    }
    
    // Node 삽입 (중간에 삽입)
    void insertNode(ListNode preNode, String data) {       
        ListNode newNode = new ListNode(data);    // 새로운 노드 생성
        newNode.link = preNode.link;
        preNode.link = newNode;
    }
    
    // Node 삽입 (마지막에 삽입)
    void insertNode(String data) {
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
 // Node 삭제(처음 노드 삭제)
    void deleteFirst(LinkedList L) {    
    	ListNode second = L.head.link; // 두번째노드
    	L.head = second; // 두번째노드를 head로 바꿈
    }
    
    // Node 삭제(중간 노드 삭제)
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
    
    // Node 삭제(마지막 노드 삭제)
   void deleteNode() {
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
    //pos자리의 data 반환
    static String  get(LinkedList L, int pos) {
    	ListNode p = L.head;
    	for(int i = 0 ; i < pos ; i++) p = p.link;
    	return p.getData();
    }
    //pos자리에 item 집어넣기
    static void set(LinkedList L, int pos, String item) {
    	ListNode p = L.head;
    	for(int i = 1 ; i < pos ; i++) p = p.link;
    	p.data = item;
    }
    
    // Node 탐색
    ListNode searchNode(String data) {
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
    void reverseList() {
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
    void printList() {
        ListNode tempNode = this.head;    // tempNode에 head가 가리키는 첫번째 노드를 할당
        // tempNode가 null이 아닐 때까지 반복하여 출력
        while(tempNode != null) {
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.link;    // temp 노드에 다음 노드(tempNode.link) 할당.
        }
        System.out.println();
    }
 
    static void main(String args[]) {
        LinkedList L = new LinkedList();    // 연결 리스트 생성
        String str = "wed";
        
        L.insertNode("sun");  L.insertNode("mon");
        L.insertNode("tue"); L.insertNode("wed");
        L.insertNode("thu");  L.insertNode("fri");
        L.insertNode("sat"); L.printList(); // 한번 다 출력
        
        System.out.println(L.searchNode(str).getData()); // wed 찾아서 출력
        
        L.deleteNode(L.searchNode(str).getData()); // wed찾아서 삭제
        L.printList(); // 삭제 후 출력
        
        str = "sun";
        
        L.deleteNode(L.searchNode(str).getData()); //sun 삭제 후 출력
        L.printList();
        
        System.out.println(get(L, 2)); // 2번째 자리 출력
        L.printList();
        
        set(L, 2, "new"); // 2번째 자리 바꾸기
        L.printList();
        
        L.reverseList();
        L.printList();
    }
    
}