package onlineClass.part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Kruskal_Algorithm_15 {

    public static class Edge implements Comparable<Edge> {
        public int weight;
        public String nodeV;
        public String nodeU;

        public Edge(int weight, String nodeV, String nodeU) {
            this.weight = weight;
            this.nodeU = nodeU;
            this.nodeV = nodeV;
        }

        public String toString() {
            return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        // Union-Find 알고리즘작성
        /**
         * 정보 :
         * 1. 각각의 노드는 자신의 부모 노드를 알아야 한다.
         * 2. 각각의 노드는 자신이 몇단계(Rank)에 있는지 알고있어야 됨
         * 3. 각각의 노드는 자신이 루트노드라면 자신의 부모노드는 자신이라는걸 알고있어야 한다.
         */
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Integer> rank = new HashMap<>();

        // U-F 알고리즘은 Union이라는 메소드와 Find라는 메소드가 존재하고있다.

        /**
         * Union메소드는 node라는 인자를 넣으면 인자의 루트 노드를 가져오는 것이다.
         * @param node
         * @return
         */
        public String find(String node) {
            // 본래 지금까지 우리가 배운걸 고려하면 부모의 부모의 부모의..
            // 단계별로 올라가서 찾아야 하기때문에 재귀용법을 사용해야 한다.
//          if (parent.get(node) != node) {
//              return find(parent.get(node));
//          }
            // path compreesion 기법은 곧바로 루트노드로 옮기기 위해서 각각의 rank를 낮추는 기능을 한다.
            //
            if (parent.get(node) != node) {
                // put을 사용하여 각각의 부모노드를 계속해서 찾아가서 재귀용법으로 호출하기때문에
                // 하나의 루트노드에 각각의 같은 단계를 가진 노드가 완성이 된다.
                parent.put(node, find(parent.get(node)));
            }
            return parent.get(node);
        }

        public void union(String nodeV, String nodeU) {
            String root1 = find(nodeV);
            String root2 = find(nodeU);

            // 두 노드가 연결될떄 사이클이 안생긴다고 우선 가정하자.
            // Union-by-rank 기법
            // 조건이 2가지
            // 1. 높이가 다를 때에는 높이가 큰 쪽에 붙기
            // 2. 높이가 같을 때에는 한쪽을 높이를 높혀준 후에 붙기
            if (rank.get(root1) > rank.get(root2)) {
                parent.put(root2,root1);
            } else {
                parent.put(root1, root2);
                if (rank.get(root1) == rank.get(root2)) {
                    rank.put(root2, rank.get(root2) + 1);
                }

            }
        }

        /**
         * Union-Find 메소드를 사용하기 위해서 n개의 원소가 개별 집합으로 이뤄지도록 초기화 한다.
         * 그렇게되면 rank를 각각 0으로 초기화해야한다.
         * @param node
         */
        public void makeSet(String node) {
            parent.put(node, node);
            rank.put(node, 0);
        }

        /**
         * Kruskal's Algorithm 작성하기
         * 1. 초기화
         * 2. 간선을 weight를 기준으로 정렬
         * 3. 가장 작은 weight부터 반복문을 돌려 간선을 연결할 때 사이클이 생기는지 체크(각각의 root노드가 같은지 판단)
         * 4. 사이클이 안생긴다면, union메소드를 사용하여 연결
         * 5. 연결한 리스트를 모아서 리턴하면 최소신장트리 완성
         * @param vertices
         * @param edges
         * @return
         */
        public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges) {
            ArrayList<Edge> mst = new ArrayList<>();
            Edge currentEdge;
            int weight;
            String nodeV, nodeU;

            // 1.초기화하기
            for (int index = 0; index < vertices.size(); index++) {
                makeSet(vertices.get(index)); // 노드 초기화
            }

            // 2. 간선을 weight를 기준으로 정렬
            Collections.sort(edges);

            // 3. 가장 작은 weight부터 반복문을 돌려 간선을 연결할 때 사이클이 생기는지 체크(각각의 root노드가 같은지 판단)
            for (int i = 0; i < edges.size(); i++) {
                // 해당 상황에서 sort가 되어있으므로, weight가 가장 작은 값부터 들어있다.
                currentEdge = edges.get(i);
                // 노드의 루트부분이 같지 않다면 사이클이 돌지않는것임으로
                if (find(currentEdge.nodeV) != find(currentEdge.nodeU)) {
                    // 4. 사이클이 안생긴다면, union메소드를 사용하여 연결
                    union(currentEdge.nodeV, currentEdge.nodeU);
                    // 리턴 할 리스트에 추가 한다.
                    mst.add(currentEdge);
                }
            }
            return mst;
        }



    }

    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        System.out.println(vertices);
        System.out.println(edges);
    }

}
