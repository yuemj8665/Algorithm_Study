package onlineClass.part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra_13 {
    public static class Edge implements Comparable<Edge> {
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
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

    public static class DijkstraPath {
        /**
         *
         * @param graph : 그래프 정보를 인자로 받음
         * @param start : 어느 노드에서 시작 할 것인가
         * @return
         */
        public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph // 그래프 정보를 인자로 받는다
                , String start ) { // 어떤 노드에서 시작인지
            Edge edgeNode, adjacentNode;
            int currentDistance, weight, distance;
            String currentNode, adjacent;
            ArrayList<Edge> nodeList;
            HashMap<String, Integer> distances = new HashMap<>();
            for (String key : graph.keySet()) {
                distances.put(key, Integer.MAX_VALUE);
            }
            distances.put(start, 0);
            // 여기까지 왔으면 첫 배열인 A : 0, 나머지 무한대의 값이 들어간다.

            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(new Edge(distances.get(start),start));

            // 알고리즘 작성
            while (priorityQueue.size() > 0) { // 우선순위 큐를 더이상 검토 할 크기가 없을 때까지 반복
                edgeNode = priorityQueue.poll(); //
                currentDistance = edgeNode.distance; // A를 기준으로 들어온 노드까지의 거리
                currentNode = edgeNode.vertex; // A를 기준으로 들어온 노드

                // 저장되어있는 최단거리보다 현재노드~목표노드 까지의 거리가 더 큰 경우, 굳이 진행 시킬 이유가 없이 넘어가면 된다.
                if (distances.get(currentNode) < currentDistance) {
                    continue;
                }
                //
                nodeList = graph.get(currentNode);

                for (int i = 0; i < nodeList.size(); i++) {
                    adjacentNode = nodeList.get(i); // 인접한 목표노드
                    adjacent = adjacentNode.vertex;
                    weight = adjacentNode.distance; // 현재 노드를 기준으로 목표 노드까지의 거리
                    // A노드를 기준으로 목표 노드까지의 거리 = A노드~현재노드의 거리 + 현재노드~목표노드의 거리
                    distance = currentDistance + weight;

                    // 현재 저장되어있는 최단거리보다 현재 계산된 최단거리가 더 짧을 경우
                    if (distance < distances.get(adjacent)) {
                        // 최단거리를 갱신해준다.
                        distances.put(adjacent, distance);
                        // 갱신 후에 객체를 다시 priorityQueue에 넣어야 해서 객체로 만들어 넣어준다.
                        priorityQueue.add(new Edge(distance, adjacent));
                    }
                }
            }

            // 여기까지 오면 각 노드를 목표로 최단거리를 가진 값이 들어간다.
            return distances;
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

        // 다익스트라 구현
        DijkstraPath dijkstraPath = new DijkstraPath();
        System.out.println(dijkstraPath.dijkstraFunc(graph, "A"));
        
    }
}
