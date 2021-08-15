package part_2;

import java.util.Arrays;
import java.util.Comparator;

public class Greedy_Algorithm_13 {
    /**
     * - 문제 2) 부분 배낭 문제 (Fractional Knapsack Problem) (프로젝트: CH27_KNAPSACK)
     *     - 무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
     *     - 가치를 무게로 나누면 무게 당 가치가 나온다.
     *         - 각 물건은 무게(w)와 가치(v)로 표현될 수 있음
     *         - 물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음, 그래서 Fractional Knapsack Problem 으로 부름
     *             - Fractional Knapsack Problem 의 반대로 물건을 쪼개서 넣을 수 없는 배낭 문제도 존재함 (0/1 Knapsack Problem 으로 부름)
     *
     * 전략 :
     *  무게 대비 가치를 전부 계산 후, 계산한 결과를 가치가 높은 순으로 정렬,
     *  그 중 하나씩 무게 제한에서 빼내어 무게 제한이 0이 될때까지 회전
     */
    /**
     *
     * @param objectList : 무게와 가치를 2차원 배열로
     * @param capacity : 무게 제한인 k인 배낭
     */
    public void knapsackFunc(Integer[][] objectList, double capacity) {
        // 최대 가치
        double totalValue = 0.0;
        // 물건을 쪼개서 넣을 때 몇퍼센트 들어가는지 저장하는 변수
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] objectItem1, Integer[] objectItem2){
                /**
                 * 2차원 배열인 objectList의 "무게 당 가치"를 위해서,
                 * Integer의 배열을 사용한다.
                 * objectItem[0]은 해당 아이템의 무게, objectItem[1]은 해당 아이템의 가치가 되어,
                 * objectItem[1] / objectItem[0] 을 하게되면 가치를 무게로 나누게 된다.
                 * 그러면 무게당 가치가 나오고, 해당 무게당 가치를 정렬하는 것이 이 메소드의 핵심.
                 */
                return (objectItem2[1] / objectItem2[0]) - (objectItem1[1]/objectItem1[0]) ;
            }
        });

        for (int i = 0; i < objectList.length; i++) {
            // 가방의 남은 공간이 특정 인덱스의 무게보다 많을 경우, 그러니까 쪼갤 필요가 없는 경우,
            if ((capacity - (double) objectList[i][0]) > 0) {
                capacity -= (double) objectList[i][0];
                totalValue += (double) objectList[i][1];
                System.out.printf("무게 : %s, 가치 : %s \r\n",objectList[i][0],objectList[i][1]);
            } else { // 가방 공간이 모잘라서 쪼개야 하는 경우
                // 남은 가방 용량에 어느정도 들어갈 수 있는지 쪼개본다.
                fraction = capacity / (double) objectList[i][0];
                // 비율과 가치를 곱하면 마지막에 넣은걸 볼 수 있다.
                totalValue += (double) objectList[i][1] * fraction;
                System.out.printf("무게 : %s, 가치 : %s, 비율 : %.2f \r\n",objectList[i][0],objectList[i][1],fraction);
                // else문으로 들어오면 결국 마지막에 남은 공간을 전부 채웠기 때문에 for문에 더 이상 남아있을 필요가 없다.
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치 : "+totalValue);
    }

    public static void main(String[] args) {
        Greedy_Algorithm_13 ga = new Greedy_Algorithm_13();
        // 무게와 가치를 2차원 배열로 먼저 나열
        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };

        ga.knapsackFunc(objectList,30.0);
    }
}
