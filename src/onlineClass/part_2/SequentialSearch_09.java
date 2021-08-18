package onlineClass.part_2;

import java.util.ArrayList;

public class SequentialSearch_09 {

    public int search(ArrayList<Integer> dataList, int data) {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i) == data) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 임의 배열이 있을 때 원하는 데이터의 위치를 리턴하는 순차 탐색 알고리즘 작성 해보기.
     * 원하는 데이터가 리스트에 없을 경우 -1을 리턴
     * Math.random()메서드를 사용해서, 0과 100 사이의 랜덤 값을 10개 가진 testData를 만들기.
     */

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testData.add((int) (Math.random() * 100));
        }

        SequentialSearch_09 ss = new SequentialSearch_09();
        int searchIndex = ss.search(testData, 5);
        System.out.println(searchIndex);


    }

}
