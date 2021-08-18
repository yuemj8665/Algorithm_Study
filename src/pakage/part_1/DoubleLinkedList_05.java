package part_1;

public class DoubleLinkedList_05<T> {
    private static final String DUBBLELINE = "============================================";
    private static final String SINGLELINE = "--------------------------------------------";
    public static void main(String[] args) {
        DoubleLinkedList_05<Integer> myLinkedList = new DoubleLinkedList_05<>();
        myLinkedList.addNode(0);
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.addNode(4);

        myLinkedList.printAll();
        System.out.println(DUBBLELINE);
        System.out.println(myLinkedList.SearchFromHead(3));
        System.out.println(myLinkedList.SearchFromTail(2));

        DoubleLinkedList_05<Integer> myLinkedList2 = new DoubleLinkedList_05<>();
        myLinkedList2.addNode(0);
        myLinkedList2.addNode(1);
        myLinkedList2.addNode(2);
        myLinkedList2.addNode(3);
        myLinkedList2.addNode(4);
        myLinkedList2.insultNode(3,2);

        myLinkedList2.printAll();
        System.out.println(DUBBLELINE);

        DoubleLinkedList_05<Integer> myLinkedList3 = new DoubleLinkedList_05<>();

        myLinkedList3.addNode(1);
        myLinkedList3.addNode(2);
        myLinkedList3.addNode(3);
        myLinkedList3.addNode(4);
        myLinkedList3.addNode(5);
        myLinkedList3.printAll();
        System.out.println("----------------");

        myLinkedList3.insertToFront(3, 2);
        myLinkedList3.printAll();
        System.out.println("----------------");

        myLinkedList3.insertToFront(6, 2);
        myLinkedList3.insertToFront(1, 0);
        myLinkedList3.printAll();
        System.out.println("----------------");

        myLinkedList3.addNode(6);
        myLinkedList3.printAll();

    }

    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T>{
        T data; // 데이터
        Node<T> prev = null; // 앞쪽 노드를 가리키는 포인터 변수
        Node<T> next = null; // 다음 노드를 가리키는 포인터 변수

        public Node(T data){ // 노드 생성자
            this.data = data;
        }
    }

    /**
     * 입력 노드 데이터를 마지막 순서로 추가하는 메소드
     * 생성 후에
     * 1. 기존 마지막 노드를 새로 생성한 마지막 노드에 연결하기
     * 2. 새로 생성한 마지막 노드의 앞을 가리키는 포인터에 기존 마지막 노드 데이터를 추가한다
     * @param data : 넣을 데이터
     */
    public void addNode(T data){
        if(this.head == null) { // head가 null일경우 어차피 없던 노드
            this.head = new Node<>(data); // 받은 데이터로 head를 만든다
            this.tail = this.head; // 1칸짜리 노드의 데이터는 head이자 tail이다.
        }
        else {
            Node<T> node = this.head;
            while (node.next != null){ // tail까지 순환한다.
                node = node.next; // 마지막 node까지 순환
            }
            node.next = new Node<>(data); // 마지막 node의 next에 받은 데이터 add
            node.next.prev = node; // add된 데이터의 다음 노드를 가리키는 포인터 변수에 현재 node를 가리킨다.
            this.tail = node.next; // tail은 마지막으로 추가된 node.next
        }
    }

    /**
     * 현재 노드에 있는 데이터와 주소값 추출
     */
    public void printAll(){
        if(this.head != null){
            Node<T> node = this.head;
            System.out.println("주소값 : "+node +" | 데이터 : "+node.data);
            while(node.next!=null){
                node = node.next;
                System.out.println("주소값 : "+node +" | 데이터 : "+node.data);
            }
        }
    }
    /**
     * head에서부터 차례대로 찾아가는 메소드
     * @param data : 찾을 데이터
     * @return : 데이터
     */
    public T SearchFromHead(T data){
        if(this.head==null){
            return null; // head가 없다면 그냥 노드자체가 없다는거니 그대로 null 반환
        }else {
            Node<T> node = this.head; // 서치 시작지점 head
            while(node!=null){ // 노드가 없을떄까지 검색한다.
                if(node.data==data){ // 만약 데이터를 찾았다면
                    return node.data; // 그대로 해당 데이터 리턴
                }
                else{
                    // 현재 노드가 뒤쪽 노드 포인터를 가지고있기때문에 해당 데이터를 다음 노드로 넘긴다
                    node = node.next;
                }
            }
            return null; // 끝까지 못찾았다면 그대로 null 반환
        }
    }

    /**
     * tail에서부터 차례대로 찾아가는 메소드
     * @param data : 찾을 데이터
     * @return : 데이터
     */
    public T SearchFromTail(T data){
        if(this.head==null){
            return null; // head가 없다면 그냥 노드자체가 없다는거니 그대로 null 반환
        }else {
            Node<T> node = this.tail; // 서치 시작지점 tail
            while(node != null){ // 노드가 없을떄까지 검색
                if(node.data == data){ // 입력한 데이터를 찾았다면
                    return node.data; // 그대로 리턴 반환
                }
                else{
                    // 현재 노드가 다음 앞 노드 포인터를 가지고있기때문에 포인터를 다음 노드에 넣는다.
                    node = node.prev;
                }
            }
            return null; // 끝까지 못찾았다면 그대로 null 반환
        }
    }

    /**
     * ★ 내가 한 버전
     * 데이터를 임의 노드 앞에 노드를 추가하는 메소드를 만들기
     * @param data
     * @param SearchData
     */
    public void insultNode(T data, T SearchData){
        if(this.head == null){ // 헤드가 없다면 아예 없는 노드임으로 생성자로 생성
            this.head = new Node<>(data);
            this.tail = this.head;
        } else {// 헤드가 있다는 경우, 생성되어있는것을 사용한다.
            Node<T> node = new Node<>(data);
            Node<T> prevNode = this.head;
            while(SearchFromHead(SearchData) != prevNode.data) {
                prevNode = prevNode.next;
            }
            /**
             * prevNode 노드는 임의 노드
             * node는 새로 생성한 노드
             * node의 next 포인터에 prevNode 노드를 넣기
             * prevNode.prev.next 포인터에 node의 노드를 넣기
             */
            node.next = prevNode;
            prevNode.prev.next = node;
//            if(this.head == this.tail){
//                node.next = new Node<>(data); // 마지막 node의 next에 받은 데이터 add
//                node.next.prev = node; // add된 데이터의 다음 노드를 가리키는 포인터 변수에 현재 node를 가리킨다.
//                this.tail = node.next; // tail은 마지막으로 추가된 node.next
//            }

            if(this.head == this.tail){
                addNode(data);
            }
        }
    }

    /**
     * ★ 강의에 있는 버전
     * 데이터를 임의 노드 앞에 노드를 추가하는 메소드를 만들기
     * @param existedData : 임의 노드의 데이터 검색
     * @param addData : 신규 노드 추가 할 데이터
     * @return
     */
    public boolean insertToFront(T existedData, T addData){
        if(this.head == null){ // head가 없을 경우
            this.head = new Node<>(addData); // 그냥 head와 tail을 새로 생성한 데이터로 사용한다.
            this.tail = this.head;
            
            return true;
        }
        else if(this.head.data == existedData){ // head가 내가 찾는 데이터일 경우
            Node<T> newHead = new Node<>(addData); // 신규 데이터로 새로운 노드 생성
            newHead.next = this.head; // 새로운 노드의 next 포인터에 head를 넣어서 맨 앞으로 옮긴다.
            this.head = newHead; // head를 교체한다.
            
            return true;
        } else {
            Node<T> node = this.head; // node는 현재커서 노드
            while(node!=null){ // 임의 노드 데이터 검색을 위한 while문
                if(node.data == existedData){ // 데이터를 찾았다면
                    Node<T> nodePrev = node.prev; // 현재 서치한 노드의 앞쪽노드
                    nodePrev.next = new Node<T>(addData); // nodePrev의 next 포인터와 새롭게 생성한 노드를 연결한다.
                    nodePrev.next.next = node; // 새로운 노드의 next 포인터와 기존 node를 연결한다.

                    nodePrev.next.prev = nodePrev; // 새로운 노드의 prev 포인터와 nodePrev를 연결한다.
                    node.prev = nodePrev.next; // 기존 노드의 prev 포인터와 새롭게 생성한 노드를 연결한다.

                    return true; // 메소드 종료
                }
                else { // 데이터를 못찾았다면 다음노드를 찾는다.
                    node = node.next;
                }
            }
            return false; // 임의 노드를 검색하지 못했다면 false를 반환한다.
        }
    }
}


