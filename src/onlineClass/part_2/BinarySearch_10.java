package onlineClass.part_2;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch_10 {
    public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        /**
         * 예외케이스를 위에서 모두 다룬다.
         */
        if (dataList.size() == 1 && searchItem == dataList.get(0)) {
            // dataList가 1개만 들어가있으면서 해당 데이터라면 true
            return true;
        }
        if (dataList.size() == 1 && searchItem != dataList.get(0)) {
            // dataList가 1개만 들어가있으면서 해당 데이터가 아니라면 false
            return false;
        }
        if (dataList.size() == 0) {
            // dataList가 아예 없다면 false
            return false;
        }

        int medium = dataList.size() / 2;
        if (searchItem == dataList.get(medium)) {
            // dataList를 반으로 나누었을때 해당 값이면 true
            return true;
        } else {
            // 여기서부터 최종적인 알고리즘 시작
            // 반복하여 자르고 자르고 자르고.. 재귀함수를 사용한다.
            // subList를 활용하여 반토막씩 보낸다.
            if (searchItem < dataList.get(medium)) {
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(0, medium)), searchItem);
            } else {
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), searchItem);
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

        BinarySearch_10 bs = new BinarySearch_10();
        System.out.println(bs.searchFunc(testData,4));
    }
}
