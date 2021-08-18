package onlineClass.part_2;

import java.util.PriorityQueue;

public class PriorityQueue_class {

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

    public static void main(String[] args) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(2, "A"));
        priorityQueue.add(new Edge(5, "B"));
        priorityQueue.add(new Edge(1, "C"));
        priorityQueue.add(new Edge(7, "D"));
        // PriorityQueue는 distance를 기준으로 정렬시켜준다.
        System.out.println(priorityQueue);
        // peek는 뽑기만 한다.
        priorityQueue.peek();
        // poll은 뽑아내면서 삭제시킨다.
        Edge edge1 = priorityQueue.poll();
        System.out.println(edge1);
        System.out.println(priorityQueue);
        // 데이터 사이즈 확인하기
        int a = priorityQueue.size();
        System.out.println(a);

    }

}
