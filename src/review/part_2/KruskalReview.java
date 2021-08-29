package review.part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class KruskalReview {
    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    public String find(String node) {
        // path compresion 기법
        // 부모노드를 찾기위해 한번에 넘기기 위한 기법
        if (this.parent.get(node) != node) {
            this.parent.put(node, find(this.parent.get(node)));
        }
        return this.parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        // union-by-rank
        if (this.rank.get(root1) > this.rank.get(root2)) {
            this.parent.put(root2, root1);
        } else {
            this.parent.put(root1, root2);
            if (this.rank.get(root1) == this.rank.get(root2)) {
                this.rank.put(root2, this.rank.get(root2) + 1);
            }
        }
    }

    public void makeSet(String node) {
        this.parent.put(node, node);
        this.rank.put(node, 0);
    }

    public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<>();
        Edge currentEdge;

        // 1. 초기화
        for (int i = 0; i < vertices.size(); i++) {
            makeSet(vertices.get(i));
        }

        // 2. 간선 weight 기반 sort
        Collections.sort(edges);

        // 여기까지 오면 edges에 weight를 기준으로 정렬되어있다.
        for (int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);

            // 3. 사이클이 있는지 확인
            if (find(currentEdge.nodeV) != find(currentEdge.nodeU)) {
                union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }

        return mst;
    }

    public static class Edge implements Comparable<Edge> {
        int weight;
        String nodeV, nodeU;

        public Edge(int weight, String nodeV, String nodeU) {
            this.weight = weight;
            this.nodeV = nodeV;
            this.nodeU = nodeU;
        }

        public String toString() {
            return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {

        ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<Edge>();
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

        KruskalReview kObject = new KruskalReview();
        System.out.println(kObject.kruskalFunc(vertices, edges));
    }
}
