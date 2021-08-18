package onlineClass.part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Dijkstra_13 {
    public static class Edge implements Comparable<PriorityQueue_class.Edge> {
        public int distance;
        public String vertex;

        public Edge(int distance, String vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }

        public String toString() {
            return "vertex : " + this.vertex + ", distance : " + this.distance;
        }

        @Override
        public int compareTo(PriorityQueue_class.Edge o) {
            return this.distance - o.distance;
        }
    }


    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        for (String key : graph.keySet()) {
            System.out.println(key);
            System.out.println(graph.get(key));
        }
        ArrayList<Edge> nodeList = graph.get("A");
        for (int index = 0; index < nodeList.size(); index++) {
            System.out.println(nodeList.get(index));
        }
    }
}
