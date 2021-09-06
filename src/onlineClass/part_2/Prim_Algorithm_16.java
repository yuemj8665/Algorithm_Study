package onlineClass.part_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prim_Algorithm_16 {
    public static class Edge implements Comparable<Edge> {
        public int weight;
        public String node1;
        public String node2;

        public Edge(int weight, String node1, String node2) {
            this.weight = weight;
            this.node1 = node1;
            this.node2 = node2;
        }

        public String toString() {
            return "(" + this.weight + ", " + this.node1 + ", " + this.node2 + ")";
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static class PrimPath {
        public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
            // 변수 초기화
            Edge currentEdge, poppedEdge, adjacentEdgeNode;
            ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
            PriorityQueue<Edge> priorityQueue;
            // 연결된 노드 집합
            ArrayList<String> connectedNodes = new ArrayList<String>();
            ArrayList<Edge> mst = new ArrayList<Edge>();
            // 모든 간선의 정보를 저장
            HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<>();

            // 받은 edge List의 숫자만큼 회전
            for (int index = 0; index < edges.size(); index++) {
                currentEdge = edges.get(index);
                if (!adjacentEdges.containsKey(currentEdge)) {
                    // startNode
                    adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
                }
                if (!adjacentEdges.containsKey(currentEdge)) {
                    // endNode
                    adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
                }
            }
            for (int index = 0; index < edges.size(); index++) {
                currentEdge = edges.get(index);
                currentEdgeList = adjacentEdges.get(currentEdge.node1);
                currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
                currentEdgeList = adjacentEdges.get(currentEdge.node2);
                currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
            }
            // 시작 노드를 넣는다.
            connectedNodes.add(startNode);
            candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
            // PriorityQueue를 사용하여 정렬
            priorityQueue = new PriorityQueue<Edge>();
            for (int index = 0; index < candidateEdgeList.size(); index++) {
                priorityQueue.add(candidateEdgeList.get(index));
            }
            // poll으로 뽑아내기때문에 size는 1개씩 줄어든다.
            while (priorityQueue.size() > 0) {
                // poll() 은 한개씩 뽑으면서 삭제한다.
                poppedEdge = priorityQueue.poll();
                // 뽑아낸 node가 포함이 안되어 있을 시(Cycle이 적용이 안되는 경우)
                if (!connectedNodes.contains(poppedEdge.node2)) {
                    // 해당 Edge를 mst에 추가한다
                    connectedNodes.add(poppedEdge.node2);
                    mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));
                    // endNode를 찾아 다시 adjacentEdgeNodes에 넣는다.
                    adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());
                    // 다시 adjacentEdgeNodes를 회전시켜 포함되어있는지 확인한다.
                    for (int index = 0; index < adjacentEdgeNodes.size(); index++) {
                        adjacentEdgeNode = adjacentEdgeNodes.get(index);
                        if (!connectedNodes.contains(adjacentEdgeNode.node2)) {
                            priorityQueue.add(adjacentEdgeNode);
                        }
                    }
                }

            }
            return mst;
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Edge(2, "A", "B"));
        priorityQueue.add(new Edge(5, "B", "D"));
        priorityQueue.add(new Edge(3, "C", "A"));

        while (priorityQueue.size() > 0) {
            System.out.println(priorityQueue.poll());
        }

        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>());
        graph.put("B", new ArrayList<Edge>());

        graph.containsKey("B");

        graph.getOrDefault("C", new ArrayList<Edge>());

        ArrayList<Edge> myedges = new ArrayList<>();
        myedges.add(new Edge(7, "A", "B"));
        myedges.add(new Edge(5, "A", "D"));
        myedges.add(new Edge(8, "B", "C"));
        myedges.add(new Edge(9, "B", "D"));
        myedges.add(new Edge(7, "D", "E"));
        myedges.add(new Edge(5, "C", "E"));
        myedges.add(new Edge(7, "B", "E"));
        myedges.add(new Edge(6, "D", "F"));
        myedges.add(new Edge(8, "E", "F"));
        myedges.add(new Edge(9, "E", "G"));
        myedges.add(new Edge(11, "F", "G"));

        PrimPath primPath = new PrimPath();
        System.out.println(primPath.primFunc("A", myedges));

    }
}
