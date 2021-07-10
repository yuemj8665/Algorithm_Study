package part_1;

public class Tree_07 {
    public static class NodeMgmt{
        Node head = null;
        public class Node{ // 이진 탐색 트리 기준으로
            Node left; // 현재 노드보다 작은 자식 노드
            Node right; // 현재 노드보다 큰 자식 노드
            int value; // 노드의 값
            public Node(int data) {
                this.value = data;
                this.left = null;
                this.right = null;
            }
        }

        /**
         * Data를 받아 Node를 생성한다.
         * @param data
         * @return
         */
        public boolean insertNode(int data){
            // Case 1 : Node가 하나도 없을 때
            if (this.head == null) { // 현재 노드가 null일 경우
                this.head = new Node(data); // 그냥 그 데이터로 노드를 새로 하나 만든다.
            } else {
                // Case 2 : Node가 하나 이상 들어가 있을 때
                Node findNode = this.head; // 현재 노드
                while(true){
                    // Case 2-1 : 현재 Node의 왼쪽 Node에 들어가야 할 때
                    if (data < findNode.value) { // 데이터가 현재 노드의 값보다 작을때는 왼쪽으로 들어간다.
                        if (findNode.left != null) { // 들어가기 전, 왼쪽 자식 노드가 있는지?
                            findNode = findNode.left; // 있으면 왼쪽 자식 노드로 커서를 옮긴다
                            // 왼쪽 자식으로 커서를 옮기고 나서 다음 또 다시 순차적으로 내려가 이진 탐색 트리를 지켜낸다.
                        } else { // 왼쪽 자식 노드가 없다면
                            findNode.left = new Node(data); // 해당 위치에 데이터를 가지고 자식노드를 생성한다.
                            break; // 노드 생성하면 while문 종료한다
                        }
                    } else { // 데이터가 현재 노드의 값보다 클 때에는 오른쪽으로 들어간다.
                        // Case 2-2 : 현재 Node의 오른쪽 Node에 들어가야 할 때
                        if (findNode.right != null) { // 들어가기 전 오른쪽에 자식 노드가 있는지?
                            findNode = findNode.right; // 있으면 오른쪽 자식 노드로 커서를 옮긴다.
                            // 오른쪽 자식으로 커서를 옮기고 나서 또 다시 순차적으로 내려가 이진 탐색 트리를 지켜낸다.
                        } else { // 오른쪽 자식 노드가 없다면
                            findNode.right = new Node(data); // 해당 위치에 데이터를 가지고 자식 노드를 생성
                            break; // 노드 생성 후 while문 종료
                        }
                    }
                }
            }
            return true; // 성공적으로 생성 후 true 반환
        }

        /**
         * 데이터를 가지고 Node를 검색한다.
         * @param data
         * @return
         */
        public Node search(int data){
            // Case 1 : Node가 하나도 없을 시
            if (this.head == null) { // 검색 할 노드가 없은 null 리턴시ㅣㄴ다.
                return null;
            } else {
                // Case 2 : Node가 하나 이상 있을 시
                Node findNode = this.head; // 현재 노드
                while (findNode != null) { // 검색 시작
                    if (findNode.value == data) { // 현재 노드의 값이 data일 경우
                        return findNode; // 현재 노드를 return
                    } else if (data < findNode.value) { // 현재 노드의 값과 data 값의 비교
                        findNode = findNode.left; // 작다면 왼쪽으로 간 후 검색
                    } else {
                        findNode = findNode.right; // 크다면 오른쪽으로 간 후 검색
                    }
                }
                return null;
            }
        }

        public boolean delete(int value) {
            boolean searched = false;
            Node currParentNode = this.head;
            Node currNode = this.head;

            if (this.head == null) { // 코너 케이스 1 : Node가 하나도 없을 때
                return false;
            } else { // 코너 케이스 2 : Node가 단지 하나만 있고, 해당 Node가 삭제 할 Node일때
                if (this.head.value == value
                        && this.head.left == null
                        && this.head.right == null) {
                    this.head = null;
                    return true;
                }
            }
            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }
            if (searched == false) {
                return false;
            }
            // 여기까지 실행 된다면
            // currNode에는 해당 데이터를 가지고있는 Node,
            // currParentNode에는 해당 데이터를 가지고있는 Node의 부모 Node가 된다.

            // Case 1 : 삭제 할 Node가 leaf Node 인 경우,
            if (currNode.left == null && currNode.right == null) {
                if (value < currParentNode.value) {
                    currParentNode.left = null;
                    currNode = null;
                } else {
                    currParentNode.right = null;
                    currNode = null;
                }
                return true;
            } else if (currNode.left != null && currNode.right == null) {
                // Case 2-1 : 삭제 할 Node가 Child Node를 한 개 가지고 있을 경우 (왼쪽에 있을 경우)
                if (value < currNode.value) {
                    currParentNode.left = currNode.left;
                    currNode = null;
                } else {
                    currParentNode.right = currNode.left;
                    currNode = null;
                }
                return true;
            } else if (currNode.left == null && currNode.right != null) {
                // Case 2-2 : 삭제 할 Node가 Child Node를 한 개 가지고 있을 경우 (오른쪽에 있을 경우)
                if (value < currParentNode.value) {
                    currParentNode.left = currNode.right;
                    currNode = null;
                } else {
                    currParentNode.right = currNode.right;
                    currNode = null;
                }
                return true;
            }
            // Case 3 : 삭제 할 Node가 Child Node를 두 개 가지고 있을 경우
            // 전략 1. 삭제 할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키도록 한다.
            // 전략 2. 삭제 할 Node의 왼쪽 자식 중, 가장 큰 값을 삭제할 Node의 Parent Node가 가리키도록 한다.
            // 강의에서는 전략 1을 가지고 설명하였다.

            // Case 3-1 : 삭제 할 Node가 Parent Node의 왼쪽에 있고, 삭제 할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 Child Node가 없을 때
            else {
                // 삭제 할 Node가 부모 Node의 왼쪽에 있을 때
                if (value < currParentNode.value) {
                    Node changeNode = currNode.right;
                    Node changeParentNode = currNode.right;
                    while (changeNode.left != null) {
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }
                    // 여기까지 실해 된다면
                    // changeNode에는 삭제 할 Node의 오른쪽 Node중에서 가장 작은 값을 가진 Node가 들어있게 됨
                    // changeParentNode는 changeNode의 부모노드가 되어있음

                    if (changeNode != null) {
                        // Case 3-1-2 : changeNode의 오른쪽 child Node가 있을 때
                        changeParentNode.left = changeNode.right;
                    } else {
                        // Case 3-1-1 : changeNode의 child Node가 없을 때
                        changeParentNode.left = null;
                    }

                    // currParentNode의 왼쪽 child Node에 삭제 할 Node의 오른쪽 자식 중
                    // 가장 작은 값을 가진 changeNode를 연결한다.
                    currParentNode.left = changeNode;
                    // parentNode의 왼쪽 child Node가 현재, changeNode이고,
                    // changeNode의 왼쪽/오른쪽 Child Node를 모두 삭제할 currNode의 기존 왼쪽/오른쪽으로 변경한다.
                    changeNode.right = currNode.right;
                    changeNode.left = currNode.left;

                    currNode = null;
                }
                // Case 3-2 : 삭제 할 Node가 Parent Node의 왼쪽에 있고, 삭제 할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 Child Node가 있을 때
                else {
                    Node changeNode = currNode.right;
                    Node changeParentNode = currNode.right;
                    while (changeNode.left != null) {
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }
                    // 여기까지 실해 된다면
                    // changeNode에는 삭제 할 Node의 오른쪽 Node중에서 가장 작은 값을 가진 Node가 들어있게 됨
                    // changeParentNode는 changeNode의 부모노드가 되어있음

                    if (changeNode != null) {
                        // Case 3-1-2 : changeNode의 오른쪽 child Node가 있을 때
                        changeParentNode.left = changeNode.right;
                    } else {
                        // Case 3-1-1 : changeNode의 child Node가 없을 때
                        changeParentNode.left = null;
                    }

                    // currParentNode의 오른쪽 child Node에 삭제 할 Node의 오른쪽 자식 중
                    // 가장 작은 값을 가진 changeNode를 연결한다.
                    currParentNode.right = changeNode;
                    // parentNode의 왼쪽 child Node가 현재, changeNode이고,
                    // changeNode의 왼쪽/오른쪽 Child Node를 모두 삭제할 currNode의 기존 왼쪽/오른쪽으로 변경한다.
                    changeNode.right = currNode.right;
                    changeNode.left = currNode.left;
                    currNode = null;
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        /**
         * 	2
         * 		3
         * 			4
         * 				6
         * 	모양의 이진 탐색 트리를 생성
         */
        NodeMgmt myTree = new NodeMgmt();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }
}
