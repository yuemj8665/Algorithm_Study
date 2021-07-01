package jupyter;

public class SingleLinkedList_04 {
    private static final String DUBBLELINE = "============================================";
    public static void main(String[] args) {
        /**
         * 링크드 리스트 구조
         * 연결 리스트 라고함
         * 주석을 적을 떄, index번호로 구별하겠음. 0 == head가 될것
         * 
         * 사용한 메소드 나열하기
         * addNode          : 노드 추가
         * printAll         : 노드 데이터, 주소 값 전체 출력
         * search           : 노드 검색
         * addNodeInside    : 노드 중간 삽입
         * delNode          : 노드 삭제
         */

        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);

        node1.next = node2;
        Node head = node1;

        SingleLinkedList<Integer> myLinkedList = new SingleLinkedList<>();
        myLinkedList.addNode(1);
        System.out.println(myLinkedList.head.data+"(데이터) : "+myLinkedList.head+"(주소값)");
        myLinkedList.addNode(2);
        System.out.println(myLinkedList.head.next.data+"(데이터) : "+myLinkedList.head.next+"(주소값)");
        myLinkedList.addNode(3);
        System.out.println(myLinkedList.head.next.next.data+"(데이터) : "+myLinkedList.head.next.next+"(주소값)");

        System.out.println(DUBBLELINE);
        SingleLinkedList<Integer> myLinkedList2 = new SingleLinkedList<>();
        myLinkedList2.addNode(1);
        myLinkedList2.addNode(2);
        myLinkedList2.addNode(3);
        myLinkedList2.printAll();
        System.out.println(DUBBLELINE);
        myLinkedList2.addNodeInside(5,1);
        myLinkedList2.printAll();
        System.out.println(DUBBLELINE);
        myLinkedList2.addNodeInside(6,3);
        myLinkedList2.printAll();
        System.out.println(DUBBLELINE);
        myLinkedList2.addNodeInside(7,99);
        myLinkedList2.printAll();

        System.out.println(DUBBLELINE);

        SingleLinkedList<Integer> myLinkedList3 = new SingleLinkedList<>();
        myLinkedList3.addNode(1);
        myLinkedList3.addNode(2);
        myLinkedList3.addNode(3);
        myLinkedList3.addNode(4);
        myLinkedList3.addNode(5);
        myLinkedList3.printAll();
        System.out.println(DUBBLELINE);
        boolean delbool = myLinkedList3.delNode(3);
        System.out.println("삭제 : "+delbool);
        myLinkedList3.printAll();
        delbool = myLinkedList3.delNode(1);
        System.out.println("헤드삭제 : "+delbool);
        myLinkedList3.printAll();
        delbool = myLinkedList3.delNode(5);
        System.out.println("마지막 삭제 : "+delbool);
        myLinkedList3.printAll();
        delbool = myLinkedList3.delNode(99);
        System.out.println("없는 데이터 삭제 : "+delbool);
        myLinkedList3.printAll();



    }
}


class Node<T>{ // 단순생성자
    T data;
    Node<T> next = null;

    public Node(T data){
        this.data = data;
    }
}

class SingleLinkedList<T>{ // SingleLinkedList 생성자
    public Node<T> head = null;
    public class Node<T>{
        T data;
        Node<T> next = null;
        public Node(T data){
            this.data = data;
        }
    }

    /**
     * 입력 노드 데이터를 마지막 순서로 추가하는 메소드
     * 생성 후에 기존 마지막 노드를 새로 생성한 마지막 노드에 연결해주어야 한다.
     * @param data : 넣을 데이터
     */
    public void addNode(T data){
        if(head == null){ // head가 없다면 기존에 아무것도 없던 노드이니 단순 새로 생성하면 된다.
            head = new Node<T>(data);
        }
        else { // head가 있을 시 기존에 있던 노드에서 맨 뒤에 데이터를 추가해준다.
            Node<T> node = this.head;
            while(node.next!=null){ // 노드의 다음이 없다면 마지막이라는 것
                node = node.next;
            }
            node.next = new Node<T>(data); // 마지막을 찾아서 next에 새로운 데이터를 넣어 생성자를 호출한다
        }
    }

    /**
     * 노드 전체 출력 메소드
     */
    public void printAll(){
        if(head!=null){ // head가 없다면 그냥 없는 노드니 아무것도 출력하지 않는다.
            Node<T> node = this.head;
            System.out.println(node.data+"(데이터) : "+node+"(주소값)");
            while(node.next!=null){
                node = node.next;
                System.out.println(node.data+"(데이터) : "+node+"(주소값)");
            }
        }
    }

    /**
     * node 검색 메소드
     * @param data : 찾을 데이터
     * @return 노드 리턴, 없으면 null 반환
     */
    public Node<T> search(T data){
        if(this.head==null){ // head가 없다면 그냥 없는 노드니 null
            return null;
        } else {
            Node<T> node = this.head; // 노드 생성
            while(node != null){
                if(node.data == data){
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    /**
     * 노드 중간에 끼워넣는 메소드
     *
     * LinkedList의 노드 삽입은 단순 생성으로 끝나는 것이 아닌,
     * 0 - 1 - 2 순에서 1앞에 새로운 노드 3을 생성 시, 0 - 3 을 먼저 이어주고, 3 - 1 을 이어줘야 한다.
     * 결과적으로 0 - 3 - 1 - 2 가 된다.
     *
     * @param data : 끼워넣을 데이터
     * @param isData : 어느 부분에 넣을 것인가 검색 할 데이터
     */
    public void addNodeInside(T data,T isData){
        Node<T> searchedNode = this.search(isData);
        if(searchedNode == null){ // 검색하여 아무것도 없으면 맨 뒤에 추가한다.
            this.addNode(data);
        } else{
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);
            searchedNode.next.next = nextNode;
        }
    }

    /**
     * 노드를 삭제하는 메소드
     *
     * LinkedList의 노드 삭제는 단순 삭제로 끝나는것이 아닌,
     * 0 - 1 - 2 순에서 0 - 1 의 관계를 끊고 0 - 2 순으로 이어줘야 하는 작업이다.
     *
     * @param isData : 삭제 할 데이터
     * @return delete 성공 시 true, 실패 시 false return
     */
    public Boolean delNode(T isData){
        if(this.head == null) {
            return false;
        } else {
            Node<T> node = this.head;
            if(node.data == isData){ // head에 데이터를 삭제 할 경우
                this.head = this.head.next; // 그 다음 데이터를 head로 교체한다. 이 경우 기존 head는 삭제됨.
                return true;
            }
            else { // head가 아닌 값을 삭제 할 경우
                while (node.next!=null){ // 마지막 노드까지 검색한다.
                    if(node.next.data == isData){ // node의 데이터가 지울 데이터라면,
                        node.next = node.next.next; // node의 다음으로 이어준다.
                        return true;
                    }
                    node = node.next; // 데이터를 찾지 못해 다음 노드로 넘어가게 한다.(while문)
                }
                return false; // 끝까지 못찾으면 그냥 실패리턴한다.
            }

        }

    }

}
