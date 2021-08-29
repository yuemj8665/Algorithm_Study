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

    }
}
