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
            Edge currentEdge, poppedEdge, adjacentEdgeNode;
            ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
            PriorityQueue<Edge> priorityQueue;

            ArrayList<String> connectedNodes = new ArrayList<String>();
            ArrayList<Edge> mst = new ArrayList<Edge>();
            HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<>();
            for (int index = 0; index < edges.size(); index++) {
                currentEdge = edges.get(index);
                if (!adjacentEdges.containsKey(currentEdge)) {
                    adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
                }
                if (!adjacentEdges.containsKey(currentEdge)) {
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
            connectedNodes.add(startNode);
            candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
            priorityQueue = new PriorityQueue<Edge>();
            for (int index = 0; index < candidateEdgeList.size(); index++) {
                priorityQueue.add(candidateEdgeList.get(index));
            }
            while (priorityQueue.size() > 0) {
                poppedEdge = priorityQueue.poll();
                if (!connectedNodes.contains(poppedEdge.node2)) {
                    // 해당 Edge를 mst에 추가한다
                    connectedNodes.add(poppedEdge.node2);
                    mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));
                    adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());
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
