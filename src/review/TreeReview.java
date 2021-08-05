package review;

import part_1.Tree_07;

public class TreeReview {
    public static class nodeMGMT {
        Node head = null;

        /**
         * Node : 이진탐색트리를 기준으로
         * left : 부모노드보다 작은 노드
         * right : 부모노드보다 큰 노드
         * value : 값
         */
        public class Node {
            Node left;
            Node right;
            int data;

            public Node(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        /**
         * 만들 메소드
         * 1. insertNode : Data를 받아 Node를 생성한다.
         * 2. searchNode : Data를 받아 Node를 검색한다.
         * 3. deleteNode : Data를 받아 Node를 삭제한다.
         */

        /**
         * 1. insertNode : Data를 받아 Node를 생성한다.
         * @param data
         * @return
         */
        public boolean insertNode(int data) {
            /**
             * 여러개의 케이스를 생각 해보자.
             * 1. Node가 아예없었을 때
             * 2. Node가 한개 이상 있었을 떄
             * 2-1 현재 노드보다 data가 작을 떄
             * 2-2 현재 노드보다 data가 클 떄
             */
            if (this.head == null) { // 1. Node가 아예없었을 때
                this.head = new Node(data); //
            } else { // 2. Node가 한개 이상 있었을 떄
                Node node = this.head;
                while (true) {
                    if (node.data < data) { // 2-1 현재 노드보다 data가 작을 떄
                        if (node.left != null) {
                            node = node.left;
                        } else {
                            node.left = new Node(data);
                            break;
                        }
                    } else { // 2-2 현재 노드보다 data가 클 떄
                        if (node.right != null) {
                            node = node.right;
                        } else {
                            node.right = new Node(data);
                            break;
                        }
                    }
                }
            }
            return true;
        }

        /**
         * 2. searchNode : Data를 받아 Node를 검색한다.
         * @param data
         * @return
         */
        public Node searchNode(int data) {
            if (this.head == null) {
                return null;
            } else {
                Node node = this.head;
                while (node != null) {
                    if (node.data == data) {
                        return node;
                    } else if (node.data > data) {
                        node = node.left;
                    } else {
                        node = node.right;
                    }
                }
                return null;
            }
        }

        /**
         * 3. deleteNode : Data를 받아 Node를 삭제한다.
         * @param data
         * @return
         */
        public boolean deleteNode(int data) {
            boolean searched = false;
            Node currentNode = this.head;
            Node currentParentNode = this.head;

            /**
             * 케이스를 생각 해보자.
             * 1. 노드가 하나도 없을 떄
             * 2. 노드가 단 하나만 있으면서 해당 노드가 삭제 할 노드일 때
             * 3. 그 외 아래 탐색 시작.
             *
             */
            if (this.head == null) { // 1. 노드가 하나도 없을 떄
                return false;
            } else if (this.head.data == data
                    && this.head.left == null
                    && this.head.right == null) {
                this.head = null;
                return true;
            }
            while (currentNode != null) {
                if (currentNode.data == data) {
                    searched = true;
                    break;
                } else if (currentNode.data > data) {
                    currentParentNode = currentNode;
                    currentNode = currentNode.left;
                } else {
                    currentParentNode = currentNode;
                    currentNode = currentNode.right;
                }
            }

            if (searched == false) {
                return false;
            }

            /**
             * 여기까지 왔으면
             * currentNode는 내가 찾던 노드,
             * cuurentParentNode는 내가 찾던 노드의 부모노드가 된다.
             */

            /**
             * 또 다시 경우의 수가 생긴다.
             * 1. 삭제 할 노드의 자식이 없다
             * 2. 삭제 할 노드의 자식노드가 있다.
             * 2-1 자식 노드가 left
             * 2-2 자식 노드가 right
             * 3. 삭제 할 노드의 자식노드가 left, right 둘다 있다.
             */

            // 1. 삭제 할 노드의 자식이 없다
            if (currentNode.left == null && currentNode.right == null) {
                if (data < currentParentNode.data) {
                    currentParentNode.left = null;
                    currentNode = null;
                } else {
                    currentParentNode.right = null;
                    currentNode = null;
                }
                return true;
                // 2. 삭제 할 노드의 자식노드가 있다.
            } else if (currentNode.left != null && currentNode.right == null) { // 2-1 자식 노드가 left
                // 이 부분은 약간 이해 할 수가 없음.
                // currentNode.left에 노드가 있다고 하고 들어온게
                // } else if (currentNode.left != null && currentNode.right == null) { <- 이 else if문인데,
                // currentNode.left는 이진트리 특성상 무조건 currentPraentNode.right보다 작다는걸 의미함.
                // 그럼 무조건 parentNode보다 높을 텐데..?
                //
                // 다시 생각해보니 parentNode.right도 currentNode가 될 수 있다는걸 알았다.
                // 그렇게 생각하면 아래 소스가 맞는 것 같다.
                // 역시 그림을 그려가면서 해야 이해가 빠르다.
                if (data < currentParentNode.data) { // 삭제 할 데이터가 부모노드보다 작다면
                    currentParentNode.left = currentNode.left;
                    currentNode = null;
                } else {
                    currentParentNode.right = currentNode.left;
                    currentNode = null;
                }
                return true;
            } else if (currentNode.left == null && currentNode.right != null) {
                if (data < currentParentNode.data) {
                    currentParentNode.left = currentNode.right;
                    currentNode = null;
                } else {
                    currentParentNode.right = currentNode.right;
                    currentNode = null;
                }
                return true;
            } else {
                // 3. 삭제 할 노드의 자식노드가 left, right 둘다 있다.
                // 3-1. currentNode가 ParentNode보다 작다면(왼쪽이라면),
                // currentNode < data(삭제 노드보다 오른쪽 자식) 중 가장 작은 녀석을 ParentNode와 연결시킨다.
                // 3-2. currentNode가 ParentNode보다 작다면(왼쪽이라면),
                // currentNode > data(삭제 노드보다 왼쪽 자식) 중 가장 큰 녀석을 ParentNode와 연결 시킨다.

                if (data < currentParentNode.data) { // 왼쪽에 있다
                    // 3-1. currentNode가 ParentNode보다 작다면(왼쪽이라면),
                    Node changeCurrentNode = currentNode.right;
                    Node changeParentNode = currentNode.right;
                    while (changeCurrentNode.left != null) {
                        changeParentNode = changeCurrentNode;
                        changeCurrentNode = changeCurrentNode.left;
                    }
                    // 이곳까지 전진하게 된다면,
                    // changeCurrentNode에는 currentNode의 오른쪽 node중, 가장 작은 Node가 들어가게 된다.
                    // changeParentNode에는 changeNode의 부모 node가 들어가있다.

                    if (changeCurrentNode.right != null) { // 가장 작은 노드의 오른쪽 자식이 있다면,
                        // 가장 작은 노드이기 때문에 left는 없을것이다.
                        changeParentNode.left = changeCurrentNode.right;
                    } else {
                        changeCurrentNode.left = null;
                    }

                    // currentNode < data(삭제 노드보다 오른쪽 자식) 중 가장 작은 녀석을 ParentNode와 연결시킨다.
                    currentParentNode.left = changeCurrentNode;
                    changeCurrentNode.right = currentNode.right;
                    changeCurrentNode.left = currentNode.left;

                    currentNode = null;
                } else {  // 3-2. currentNode가 ParentNode보다 작다면(왼쪽이라면),
                    Node changeCurrentNode = currentNode.right;
                    Node changeParentNode = currentNode.right;
                    while (changeCurrentNode.left != null) {
                        changeParentNode = changeCurrentNode;
                        changeCurrentNode = changeCurrentNode.left;
                    }

                    // 이곳까지 전진하게 된다면,
                    // changeCurrentNode에는 currentNode의 오른쪽 node중, 가장 작은 Node가 들어가게 된다.
                    // changeParentNode에는 changeNode의 부모 node가 들어가있다.

                    if (changeCurrentNode.right != null) { // 가장 작은 노드의 오른쪽 자식이 있다면,
                        // 가장 작은 노드이기 때문에 left는 없을것이다.
                        changeParentNode.left = changeCurrentNode.right;
                    } else {
                        changeCurrentNode.left = null;
                    }

                    // currentNode < data(삭제 노드보다 오른쪽 자식) 중 가장 작은 녀석을 ParentNode와 연결시킨다.
                    currentParentNode.right = changeCurrentNode;
                    changeCurrentNode.right = currentNode.right;
                    changeCurrentNode.left = currentNode.left;

                    currentNode = null;
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
        nodeMGMT myTree = new nodeMGMT();
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
        System.out.println(myTree.deleteNode(15));
        System.out.println("HEAD: " + myTree.head.data);
        System.out.println("HEAD LEFT: " + myTree.head.left.data);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.data);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.data);

        System.out.println("HEAD RIGHT: " + myTree.head.right.data);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.data);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.data);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.data);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.data);
    }
}
