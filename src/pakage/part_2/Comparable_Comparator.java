package pakage.part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Comparable_Comparator {
    /**
     * - 문제 1) 동전문제
     * - 지불해야 하는 값이 4,720원 일 때, 1원, 50원, 100원, 500원의 동전으로 동전의 수가 가장 적게 지불하시오.
     * - 가장 큰 동전부터 최대한 지불해야 하는 값을 채우는 방식으로 구현 가능
     * - 탐욕 알고리즘으로 매 순간 최적이라고 생각되는 경우를 선택하면 된다.
     */
    public void coinFunc(Integer price, ArrayList<Integer> coinList) {
        Integer totalCoinCount = 0;
        Integer coinNum = 0;
        ArrayList<Integer> details = new ArrayList<>();
        for (int i = 0; i < coinList.size(); i++) {
            coinNum = price / coinList.get(i);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(i);
            details.add(coinNum);
            System.out.println(coinList.get(i) +"원 : "+coinNum+"개");
        }
        System.out.println("총 동전 갯수 : "+totalCoinCount);
    }

    /**
     * 1. Comparable을 사용하여 Arrays.sort() 메소드를 사용한다.
     */
    public static class Edge1 implements Comparable<Edge1> {
        public Integer distance;
        public String vertex;

        public Edge1(Integer distance, String vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }
        @Override
        public int compareTo(Edge1 o) {
            // 리턴에서 적는 순서에 따라 내림차순이냐 오름차순이냐 결정이 된다.
            // 현재는 내림차순으로 정렬한다.
            return o.distance - this.distance;
        }
    }

    public static class Edge2 {
        public Integer distance;
        public String vertex;

        public Edge2(Integer distance, String vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }
    }

    public static void main(String[] args) {
        Comparable_Comparator ga = new Comparable_Comparator();
        ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(500, 100, 50, 1));
        ga.coinFunc(4720,coinList);

        // 1. Comparable 인터페이스를 사용하여 Arrays.sort() 메소드를 구현한다.
        Edge1 edge1 = new Edge1(10,"A");
        Edge1 edge2 = new Edge1(12,"B");
        Edge1 edge3 = new Edge1(13,"C");
        Edge1[] edge1s = new Edge1[]{edge1, edge2, edge3};

        Arrays.sort(edge1s);
        for (int i = 0; i < edge1s.length; i++) {
            System.out.println(edge1s[i].distance);
        }

        // 2. Comparator 인터페이스 사용하여 Arrays.sort() 메소드를 구현한다.
        // 두 인터페이스를 같이 사용하더라도 Comparator 인터페이스를 기준으로 정렬이 된다.
        Edge2 edge4 = new Edge2(10,"A");
        Edge2 edge5 = new Edge2(12,"B");
        Edge2 edge6 = new Edge2(13,"C");
        Edge2[] edge2s = new Edge2[]{edge4, edge5, edge6};

        Arrays.sort(edge2s, new Comparator<Edge2>() {
            @Override
            public int compare(Edge2 o1, Edge2 o2) {
                // 내림차순 정렬한다. 반댓방향이면 오름차순이 된다.
                return o2.distance - o1.distance;
            }
        });
        for (int i = 0; i < edge2s.length; i++) {
            System.out.println(edge2s[i].distance);
        }
    }


}
