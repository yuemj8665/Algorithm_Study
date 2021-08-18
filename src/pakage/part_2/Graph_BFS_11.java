package pakage.part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Graph_BFS_11 {

    /**
     * 우선 두가지의 큐(quere)를 만든다.
     * visited : 방문한다. 탐색한 노드. 방문하는 노드의 순서를 저장한다.
     * needVisit : 탐색이 필요한 노드
     */
    public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisited = new ArrayList<>();
        int count = 0;

        needVisited.add(startNode);
        while (needVisited.size() > 0) {
            count++;
            String node = needVisited.remove(0);
            if (!visited.contains(node)) {
                visited.add(node);
                needVisited.addAll(graph.get(node));
            }
        }
        System.out.println(count);
        return visited;
    }


    public static void main(String[] args) {
        // graph를 map과 ArrayList를 저장한다.
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

        System.out.println(graph);

        ArrayList<String> aList = new ArrayList<>();
        aList.add("A");
        aList.add("B");
        String node = aList.remove(0);
        System.out.println(aList);
        System.out.println(node);
        System.out.println(aList.contains("A"));

        aList.add("C");
        aList.addAll(graph.get("A"));

        System.out.println(aList);

        Graph_BFS_11 bfs = new Graph_BFS_11();
        System.out.println(bfs.bfsFunc(graph, "A"));
    }
}
