package review;

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

            return true;
        }
    }

}
