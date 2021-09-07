package onlineClass.part_2;

import java.nio.file.Path;
import java.util.HashMap;

public class Prim_Improved_17 {

    public static class Path {
        public int weight;
        public String node1;
        public String node2;

        public Path(int weight, String node1, String node2) {
            this.weight = weight;
            this.node1 = node1;
            this.node2 = node2;
        }

        public String toString() {
            return "(" + this.weight + ", " + this.node1 + ", " + this.node2 + ")";
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

    }

}
