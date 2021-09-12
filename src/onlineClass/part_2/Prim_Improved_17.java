package onlineClass.part_2;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prim_Improved_17 {

    public static class Path {
        public int weight;
        public String node1;
        public String node2;

        public Path(String node1, String node2, int weight) {
            this.weight = weight;
            this.node1 = node1;
            this.node2 = node2;
        }

        public String toString() {
            return "(" + this.node1 + ", " + this.node2 + ", " + this.weight + ")";
        }
    }

    public static class Edge implements Comparable<Edge> {
        public String node;
        public int weight;

        public Edge(String node, int weight) {
            this.weight = weight;
            this.node = node;
        }

        public String toString() {
            return "(" + this.weight + ", " + this.node + ")";
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static class PrimPath {
        public ArrayList<Path> imporvedPrimFunc(HashMap<String,HashMap<String,Integer>> graph, String startNode) {
            ArrayList<Path> mst = new ArrayList<>();
            PriorityQueue<Edge> keys = new PriorityQueue<>();
            HashMap<String, String> mstPath = new HashMap<>(); // 어느 노드에서 어느 노드로 연결된다는 변수
            HashMap<String, Edge> keysObject = new HashMap<>();
            HashMap<String, Integer> linkedEdges = new HashMap<>();

            Edge poppedEdge;
            Edge linkedEdge;
            Edge edgeObject;

            Integer totalWeight=0;

            // 다익스트라 알고리즘 처럼 전체 노드에 대해서 최대값, 스타트 노드는 0으로 셋팅한다.
            for (String key : graph.keySet()) {
                if (key == startNode) { // 스타트면 0으로
                    edgeObject = new Edge(key, 0);
                    mstPath.put(key, key);
                } else { // 그 외에는 최대값
                    edgeObject = new Edge(key, Integer.MAX_VALUE);
                    mstPath.put(key, null);
                }
                keys.add(edgeObject);
                keysObject.put(key, edgeObject);
            }
            // 여기까지 오면 key들은 각각의 정보들이 keys에 들어가게 된다.
            // 0또는 최대값이 들어가있을 것이다.

            // 가장 작은 녀석부터 파악한다.
            while (keys.size() > 0) {
                poppedEdge = keys.poll(); // 1개씩 뽑으면서 제거
                keysObject.remove(poppedEdge.node); // keysObject에선 제거가 안되니 수동으로 제거해준다.
                // 해당 노드정보를 mst에 집어넣는다.
                mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));
                totalWeight += poppedEdge.weight; // 간선의 합 표현.
                linkedEdges = graph.get(poppedEdge.node); // 들어온 그래프의 인접 간선들의 정보를 들고있다.

                for (String adjacent : linkedEdges.keySet()) {
                    if (keysObject.containsKey(adjacent)) {
                        linkedEdge = keysObject.get(adjacent);
                        if (linkedEdges.get(adjacent) < linkedEdge.weight) {
                            linkedEdge.weight = linkedEdges.get(adjacent);
                            mstPath.put(adjacent, poppedEdge.node);
                            keys.remove(linkedEdge);
                            keys.add(linkedEdge);
                        }
                    }
                }
            }
            System.out.println(totalWeight);
            return mst;
        }
    }

    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> mygraph = new HashMap<>();
        HashMap<String, Integer> edges;
        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("D", 5);
        mygraph.put("A", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 7);
        edges.put("D", 9);
        edges.put("C", 8);
        edges.put("E", 7);
        mygraph.put("B", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 8);
        edges.put("E", 5);
        mygraph.put("C", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 5);
        edges.put("B", 9);
        edges.put("E", 7);
        edges.put("F", 6);
        mygraph.put("D", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("C", 5);
        edges.put("D", 7);
        edges.put("F", 8);
        edges.put("G", 9);
        mygraph.put("E", edges);

        edges = new HashMap<String, Integer>();
        edges.put("D", 6);
        edges.put("E", 8);
        edges.put("G", 11);
        mygraph.put("F", edges);

        edges = new HashMap<String, Integer>();
        edges.put("E", 9);
        edges.put("F", 11);
        mygraph.put("G", edges);

        PrimPath pObject = new PrimPath();

        System.out.println(pObject.imporvedPrimFunc(mygraph,"A"));

    }

}
