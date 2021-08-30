package review.part_2;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSortringReview {

    /**
     * 선택 정렬
     * 선택정렬이란
     * 1. 주어진 데이터 중 최소값을 찾는다
     * 2. 해당 최소값을 데이터의 맨 앞에 위치한 값과 교체
     * 3. 맨 앞의 위치를 뺀 나머지데이터를 동일한 방법으로 교체
     * >> 각각의 데이터가 저장되어있는 배열이 았다고 가정하기.
     */

    /**
     * * 데이터가 두 개 일때
     * - 예: dataList = [9, 1]
     * - dataList[0] > dataList[1] 이므로 dataList[0] 값과 dataList[1] 값을 교환
     * * 데이터가 세 개 일때
     * - 예: dataList = [9, 1, 7]
     * - 처음 한번 실행하면, 1, 9, 7 이 됨
     * - 두 번째 실행하면, 1, 7, 9 가 됨
     * * 데이터가 네 개 일때
     * - 예: dataList = [9, 3, 2, 1]
     * - 처음 한번 실행하면, 1, 3, 2, 9 가 됨
     * - 두 번째 실행하면, 1, 2, 3, 9 가 됨
     * - 세 번째 실행하면, 변화 없음
     */

    /**
     * 데이터가 두 개 일때
     * 예: dataList = [9, 1]
     * @param ary
     * @return
     */
    public ArrayList<Integer> sotring_data2 (ArrayList<Integer> ary) {
        if (ary.get(0) > ary.get(1)) {
            Collections.swap(ary, 0, 1);
        }

        return ary;
    }

    /**
     * 데이터가 세 개 일때
     * 예: dataList = [9, 1, 7]
     * @param ary
     * @return
     */
    public ArrayList<Integer> sotring_data3(ArrayList<Integer> ary) {
        // 더 이상의 회전을 막기위한 변수
        boolean compl = false;

        // 배열의 0번부터 비교, 마지막 인덱스는 전부 회전되어있으므로 볼 필요가 없다.
        for (int i = 0; i < ary.size(); i++) {
            for (int k = i + 1; k < ary.size(); k++) {
                if (ary.get(i) > ary.get(k)) {
                    Collections.swap(ary, i, k);
                    compl = true;
                }
            }
            if (compl == false) {
                break;
            }
        }
        return ary;
    }

    /**
     * 데이터가 네 개 이상일 때
     * 예: dataList = [9, 3, 2, 1]
     * @param ary
     * @return
     */
    public ArrayList<Integer> sotring_data(ArrayList<Integer> ary) {
        // 가장 작은 숫자의 인덱스를 구함
        int lowest;
        // 리스트의 처음부터 끝까지의 회전
        for (int i = 0; i < ary.size() - 1; i++) {
            // 가장 작은 현재 인덱스
            lowest = i;
            // 리스트+1번 인덱스를 찾는다.
            for (int k = i + 1; k < ary.size(); k++) {
                // 가장 작은 인덱스와 비교한다.
                if (ary.get(lowest) > ary.get(k)) {
                    // 더 작다면 니가 제일 작다
                    lowest = k;
                }
            }
            // 교체하고 다음 인덱스로.
            Collections.swap(ary, lowest, i);
        }
        return ary;
    }


    public static void main(String[] args) {
        SelectionSortringReview selectionSortringReview = new SelectionSortringReview();
        ArrayList<Integer> ary1 = new ArrayList<>();
        ary1.add(9);
        ary1.add(2);

        selectionSortringReview.sotring_data2(ary1);
        System.out.println(ary1);

        ArrayList<Integer> ary2 = new ArrayList<>();
        ary2.add(9);
        ary2.add(1);
        ary2.add(2);

        selectionSortringReview.sotring_data3(ary2);
        System.out.println(ary2);

        // 데이터가 3개 이상일 때 테스트
        ArrayList<Integer> dataList3 = new ArrayList<>();
        dataList3.add(9);
        dataList3.add(1);
        dataList3.add(2);
        dataList3.add(3);
        System.out.println("sorting3 sotring3 전 : " + dataList3);
        selectionSortringReview.sotring_data(dataList3);
        System.out.println("sorting3 sotring3 후 : " + dataList3);

    }
}
