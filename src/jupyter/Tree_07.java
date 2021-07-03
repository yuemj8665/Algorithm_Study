package jupyter;

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
        myTree.insertNode(2);
        myTree.insertNode(3);
        myTree.insertNode(4);
        myTree.insertNode(6);

        NodeMgmt.Node testNode = myTree.search(3);
        System.out.println(testNode.value);
        System.out.println(testNode.right.value);
    }
}
