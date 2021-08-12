package part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Graph_DFS_12 {
    /**
     * needVisit 스택과 visited큐 두개의 자료구조를 사용한다.
     * BFS는 2개의 큐를 사용한다는것과 다르다.
     */
    public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(needVisit.size() - 1); // Queue/Stack를 나누는 경로임
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }




    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<>();
        aList.add("A");
        aList.add("B");
        String node = aList.remove(aList.size() - 1);
        System.out.println(aList);
        System.out.println(node);
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        Graph_DFS_12 dfs = new Graph_DFS_12();
        System.out.println(dfs.dfsFunc(graph,"A"));
    }
}
