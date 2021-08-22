package review.part_1;

public class SingleLinkedListReview {
    private static final String DUBBLELINE = "============================================";

    /**
     * 싱글 링크드리스트는 각각의 노드로 이루어져 있다.
     * 각 노드는 포인터를 가지고 있으며, 포인터는 본인 노드의 뒤쪽의 데이터(주소 값을 가지고있다)
     * 그렇기떄문에 삽입, 삭제 시 약간의 수고가 필요하다.
     * 각각의 경우는 우선 링크드 리스트 구조를 만들고 분류하기로 한다.
     *
     * 사용한 메소드 나열하기
     * addNode          : 노드 추가
     * printAll         : 노드 데이터, 주소 값 전체 출력
     * search           : 노드 검색
     * addNodeInside    : 노드 중간 삽입
     * delNode          : 노드 삭제
     */

    public static void main(String[] args) {
        SingleLinkedList<Integer> myLinkedList = new SingleLinkedList<>();
        // 데이터 추가
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.addNode(4);
        myLinkedList.addNode(5);
        // 데이터 출력
        myLinkedList.printAll();

        System.out.println(DUBBLELINE);
        // 데이터 삽입
        myLinkedList.addNodeInside(8,3);
        // 데이터 출력
        myLinkedList.printAll();

        System.out.println(DUBBLELINE);
        // 데이터 삭제
        myLinkedList.delNode(4);
        // 데이터 출력
        myLinkedList.printAll();

    }


}

/**
 * SingleLinkedList 생성자. Node라는 class로 보기 쉽게 만듬
 * 해당 생성자에 데이터가 들어가고, 추가가 된다면 포인터에 다음 노드를 추가하게끔 해야한다.
 * @param <T>
 */
class SingleLinkedList<T>{
    public Node<T> head = null;
    public class Node<T>{
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * 생성자를 만들었으니 해야 할일을 생각한다.
     * 1. 노드 전체 출력 메소드
     * 2. 노드 추가 메소드
     * 3. 노드 삽입 시 사용 할 검색 메소드
     * 4. 노드 삭제 메소드
     * 5. 노드 중간삽입 메소드
     */

    /**
     * 1. 노드 전체 출력 메소드
     */
    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data+"(데이터) : "+node+"(주소값)");
            while (node.next != null) { // 다음 노드가 없을떄까지
                // 노드에 다음 노드를 넣고, 계속 전진시킨다.
                node = node.next;
                System.out.println(node.data+"(데이터) : "+node+"(주소값)");
            }
        }
    }

    /**
     * 2. 노드 추가 메소드
     * 노드를 단순히 뒤에 이어붙인다.
     * @param data
     */
    public void addNode(T data) {
        if (head == null) { // 헤드가 없다는건 노드가 아예 존재하지않았다는 것
            head = new Node<T>(data); // 그래서 새로 생성해주고 해당 값을 head로 한다.
        } else { // 그 외의 경우에는 이미 생성되어있는 노드가 있다는 것이다.
            Node<T> node = this.head;
            while (node.next != null) { // 노드의 데이터가 없을떄까지 전진시킨다.
                node = node.next;
            }
            // 여기까지 전진한 노드는 포인터에 다음 노드값이 없을 것이다.
            node.next = new Node<T>(data); // 추가해주면 완료.
        }
    }

    /**
     * 3. 노드 삽입 시 사용 할 검색 메소드
     * 중도삽입 하기 전 우선 검색을 먼저 해야된다.
     * @param data
     * @return
     */
    public Node<T> search(T data) {
        if (head == null) { // head가 없으면 그냥 노드자체가 없기때문에
            return null; // null을 리턴한다.
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                if (node.data == data) { // 전잔하다가 node의 값과 검색하려는 값이 같은걸 찾으면
                    return node; // 해당 노드를 리턴
                } else { // 노드 데이터가 원하는게 아니라면
                    node = node.next; // 노드를 전진시킨다.
                }
            }
            // 리스트를 한바퀴 돌아서 못찾으면 그냥 null 반환
            return null;
        }
    }

    /**
     * 4. 노드 삭제 메소드
     * SingleLinkedList의 삭제는 단순 삭제가 아닌
     * 삭제 전 앞쪽 노드와 뒷 노드를 이어주는 과정이 필요하다.
     * 예) 0-1-2-3 에서 2를 삭제한다면 1과 3을 이어줘야 한다.
     * @param isData
     * @return 성공 시 true, 실패 시 false
     */
    public Boolean delNode(T isData) {
        if (head == null) {
            return false;
        } else {
            Node<T> node = this.head;
            /**
             * 노드 삭제에는 두 가지 경우의 수가 있다.
             * 1. 삭제 하는 데이터가 head인가
             * 2. head가 아닌가
             */
            if (node.data == isData) { // 1. 삭제 하는 데이터가 head인가
                this.head = node.next; // 이 경우 단순히 head에 다음 node를 덮어씌우면 된다.
                return true;
            } else { // 2. head가 아닌가
                // 이 경우 해당 데이터를 찾아야 한다.
                while (node.next != null) {
                    if (node.next.data == isData) { // node의 다음 데이터가 찾은 데이터면
                        node.next = node.next.next; // 찾은 데이터의 다음 노드를 이어준다.
                        return true;
                    } else {
                        node = node.next;
                    }
                }
                // 여기까지 찾았는데 반환하지 못했다면 그냥 못찾아서 실패한경우이므로 false를 리턴
                return false;
            }
        }

    }

    /**
     * 5. 노드 중간삽입 메소드
     * @param data : 넣을 데이터
     * @param isData : 어디다 넣을 것인가 검색 할 데이터
     */
    public void addNodeInside(T data,T isData) {
        // 우선 어디다 넣을건지 찾아보자
        Node<T> searchNode = this.search(isData);
        if (searchNode == null) { // 노드를 못찾았다
            this.addNode(data); // 그럼 그냥 맨 끝에 추가한다.
        } else {
            Node<T> nextNode = searchNode.next; // 우선 찾은 노드의 뒤쪽 노드를 변수로 저장
            searchNode.next = new Node<T>(data); // 새로운 노드를 추가
            searchNode.next.next = nextNode; // 새로운 노드와 방금 저장했던 노드와 연결해준다.
        }

    }


}

