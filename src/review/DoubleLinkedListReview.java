package review;

public class DoubleLinkedListReview<T> {
    /**
     * DoubleLinkedList는 SingleLinkedList와는 다르게 앞, 뒤의 데이터를 모두 가지고 연결되어있다.
     * 그래서 node.next처럼 뒤쪽 데이터를 가리키는 것 뿐만 아니라 node.prev처럼 뒤쪽 데이터를 가지고 오는 것도 있다.
     * 노드를 생성할 때, 삭제할 때, 검색할 때 조금 복잡해진다.
     *
     */
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }

    }

    /**
     * 우선 필요한 것을 생각해보자.
     * 1. 노드 전체 출력
     * 2. 노드 마지막에 추가하는 addNode
     * 3. 노드 데이터 검색(front)
     * 4. 노드 데이터 검색(tail)
     * 5. 임의 노드 앞에 노드를 추가하여 데이터를 삽입하는 메소드 만들기.
     */

    /**
     *  1. 노드 전체 출력
     */
    public void printf() {
        if (this.head != null) {
            Node<T> node = this.head;
            System.out.printf("주소값 : %s | 데이터 : %s\r\n",node,node.data);
            while (node.next != null) {
                node = node.next;
                System.out.printf("주소값 : %s | 데이터 : %s\r\n",node,node.data);
            }
        }
    }

    /**
     * 2. 노드 마지막에 추가하는 addNode
     * @param data
     * @return
     */
    public void addNode(T data) {
        if (this.head == null) { // head가 없다면 아예 생성되지 않은 노드임으로 노드를 새로 생성
            this.head = new Node<>(data);
            this.tail = this.head; // 이떄 노드는 하나밖에 없으니 head이자 tail이다.
        } else { // head가 있는 경우니 맨 뒤로 보내야된다.
            Node<T> node = this.head; 
            while (node.next != null) { // 포인터를 맨 뒤로 보내기 위해 무한회전
                node = node.next;
            } // 여기까지 오면 맨 뒤쪽 노드로 갔을 것이다.
            node.next = new Node<>(data); // 받은 데이터로 노드 신규 생성
            node.next.prev = node; // 신규 생성한 노드의 앞쪽 포인터는 기존 노드에 넣는다.
            this.tail = node.next; // 그리고 신규 생성한 노드는 끝에 생성되었기 떄문에 tail로 바꿔준다.
        }
    }

    /**
     * 3. 노드 데이터 검색(front)
     * @param data
     * @return
     */
    public T searchfromHead(T data) {
        if (this.head == null) { // 헤드 없으면 그냥 없는노드
            return null; // null return
        } else {
            Node<T> node = this.head;
            while (node.next != null) { // 원하는 노드를 찾기위한 while
                if (node.data == data) { // 해당 데이터를 찾았다면
                    return data; // 해당 데이터 반환
                } else {
                    node = node.next; // 아니라면 회전을 위한 노드전진
                }
            }
            // 여기까지 왔는데 못찾았다면 그냥 없는것.
            return null;
        }
    }

    /**
     * 4. 노드 데이터 검색(tail)
     * @param data
     * @return
     */
    public T searchfromTail(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while (node != null) {
                if (node.data == data) {
                    return data;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    /**
     * 5. 임의 노드 앞에 노드를 추가하여 데이터를 삽입하는 메소드 만들기.
     * 경우의 수는 세 가지 이다.
     * Case : 1 그냥 아예 노드가 없었을 경우
     * Case : 2 찾는 노드가 마침 head에 있을 경우
     * Case : 3 찾는 노드가 중간에 있을 경우
     * @param isData
     * @param data
     * @return
     */
    public boolean insertNode(T isData, T data) {
        // Case : 1 그냥 아예 노드가 없었을 경우
        if (this.head == null) { // addNode처럼 head가 없으면 그냥 새로운 노드를 생성한다.
            this.head = new Node<>(data);
            this.tail = this.head;
            return true;
        } else if (this.head.data == isData) { // Case : 2 찾는 노드가 마침 head에 있을 경우
            Node<T> newHeadNode = new Node<>(data); // 입력받은 데이터로 노드 생성
            newHeadNode.next = this.head; // 기존의 head는 신규 만들어진 head의 뒤쪽 포인터로 가게된다.
            this.head = newHeadNode; // 새로운 head로 넣는다.
            return true;
        } else { // Case : 3 찾는 노드가 중간에 있을 경우
            Node<T> node = this.head;
            while (node.next != null) { // 노드를 찾기위하여 while문
                if (node.data == isData) { // 내가 찾던 데이터다
                    // 내가 찾는 데이터의 앞쪽 포인터를 할당. nodePrev - new node - node 순으로 배치해야 한다.
                    Node<T> nodePrev = node.prev;
                    nodePrev.next = new Node<>(data); // 그러기 위해선 앞쪽 포인터와 새로 생성하는 노드를 연결한다.
                    nodePrev.next.next = node; // nodePrev.next == new node 이므로, new node와 현재 node를 연결한다.
                    nodePrev.next.prev = nodePrev; // new node와 nodePrev를 연결한다
                    node.prev = nodePrev.next; // 마지막으로 현재 node와 new node를 연결한다.
                    return true;
                } else { // 원하는 노드를 못찾았다면 노드 전진
                    node = node.next;
                }
            }
            // 여기까지 왔다면 그냥 원하는 노드를 못찾은 것이니, false 반환
            return false;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedListReview<Integer> myNode = new DoubleLinkedListReview<>();
        myNode.addNode(0);
        myNode.addNode(1);
        myNode.addNode(2);
        myNode.addNode(4);
        myNode.printf();

        System.out.println(myNode.searchfromHead(2));

        myNode.addNode(3);
        myNode.printf();

        myNode.insertNode(2,9);
        myNode.printf();

    }
}

