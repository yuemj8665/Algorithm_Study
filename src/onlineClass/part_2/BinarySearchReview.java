package onlineClass.part_2;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchReview {
    /**
     * 이진 탐색이란?
     * - 탐색할 자료를 둘로 나누어 해당 데이터가 있을만한 곳을 탐색하는 방법.
     * - 정렬이 되어있어야 한다. 순차 탐색은 정렬이 필요없다.
     */

    public boolean sbinarySearch(ArrayList<Integer> dataList, int data) {
        /**
         * 예외케이스를 생각하기
         * 1. 사이즈가 1일때 찾은 데이터가 그 데이터 일 경우
         * 2. 사이즈가 1일때 찾은 데이터가 그 데이터가 아닐 경우
         * 3. 사이즈가 아예 없는 경우
         * 4. 정상적인 실행
         *
         */

        if (dataList.size() == 1 && dataList.get(0) == data) {
            return true;
        }
        if (dataList.size() == 1 && dataList.get(0) != data) {
            return false;
        }
        if (dataList.size() == 0) {
            return false;
        }

        int medium = dataList.size() / 2;
        if (dataList.get(medium) == data) {
            return true;
        } else {
            if (data < dataList.get(medium)) {
                return this.sbinarySearch(new ArrayList<Integer>(dataList.subList(0, medium)), data);
            } else {
                return this.sbinarySearch(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), data);
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int index = 0; index < 100; index++) {
            testData.add((int) (Math.random() * 100));
        }

        Collections.sort(testData);
        System.out.println(testData);

        BinarySearchReview bs = new BinarySearchReview();
        System.out.println(bs.sbinarySearch(testData,4));
    }
}
