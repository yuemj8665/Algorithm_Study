package part_2;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSorting_4 {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        // 삽입 정렬은 두 번쨰 인덱스부터 정렬을 시작 하므로, 최종 인덱스의 -1번 회전시킨다.
        for (int index = 0; index < dataList.size() - 1; index++) {
            // index2 -> 본인과 본인 앞쪽을 비교해야 하는 숫자.
            // 인덱스는 무조건 0 이상이고, 본인 앞쪽을 계속해서 탐색하기 위해 인덱스를 점점 감소시킨다.
            for (int index2 = index + 1; index2 > 0; index2--) { // 앞쪽과 비교했는데 더이상 비교할것이 없거나(index2 > 0),
                if (dataList.get(index2) < dataList.get(index2 - 1)) {
                    Collections.swap(dataList, index2, index2 - 1);
                } else { // 값이 더 크다면 앞으로 이동 할 이유가 없으니 break로 빠져나온다.
                    break;
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dataList.add((int)(Math.random()*100));
        }
        InsertionSorting_4 is = new InsertionSorting_4();
        is.sort(dataList);
        System.out.println(dataList);
    }

}
