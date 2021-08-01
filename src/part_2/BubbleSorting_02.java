package part_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BubbleSorting_02 {
    public static class BubbleSort{
        /**
         * 데이터가 4개 이상일때 버블정렬하기
         * 특이점 :
         * n개의 리스트가 있는 경우 최대 n-1번의 로직을 적용한다.
         * 로직을 1번 적용할 때마다 가장 큰 숫자가 뒤에서부터 1개씩 결정된다.
         * 로직이 경우에따라 일찍 끝날 수도있다.
         * 따라서 로직을 적용할때 한번도 데이터가 교환된 적이 없다면 이미 정렬된 상태이므로 더이상 로직을 반복 적용할 필요가 없다.
         *
         * @param dataList : 정렬 전 dataList
         * @return dataList : 정렬 후 dataList
         */
        public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
            for (int i = 0; i < dataList.size() - 1; i++) { // n개의 리스트가 있는 경우 최대 n-1번의 로직을 적용한다.
                // 로직을 적용할때 한번도 데이터가 교환된 적이 없다면
                // 이미 정렬된 상태이므로 더이상 로직을 반복 적용할 필요가 없다.
                boolean swap = false;
                for (int index = 0; index < dataList.size() - 1 - i; index++) { // 마지막 데이터는 회전 할 이유가 없음
                    if (dataList.get(index) > dataList.get(index + 1)) { // 인덱스와 그 뒤 인덱스를 비교한다.
                        Collections.swap(dataList,index,index+1); // 앞쪽 인덱스가 더 크다면 둘을 교환한다.
                        swap = true; // 회전을 한번 진행했으니 이젠 끝까지 확인해봐야 한다.
                    }
                }
                if (swap == false) { // 첫 교환이 아예 없었다면
                    break; // 이미 정렬이 된 상태이므로 로직을 적용 할 필요가 없이 빠져나온다.
                }
            }
            return dataList; // 정렬 된 dataList를 반환한다.
        }
    }

    public static void main(String[] args) {
        // 데이터가 2개일때 버블정렬을 해보자.
        ArrayList<Integer> dataList2 = new ArrayList<>();
        dataList2.add(4);
        dataList2.add(2);

        if (dataList2.get(0)>dataList2.get(1)) {
            Collections.swap(dataList2,0,1);
        }
        System.out.println(dataList2);

        // 데이터가 3개일때 버블정렬을 해보자.
        ArrayList<Integer> dataList3 = new ArrayList<>();
        dataList3.add(9);
        dataList3.add(2);
        dataList3.add(4);
        for (int i = 0; i < dataList3.size(); i++) {
            if (i != dataList3.size()-1) {
                if (dataList3.get(i) > dataList3.get(i + 1)) {
                    Collections.swap(dataList3,i,i+1);
                }
            }
        }
        System.out.println(dataList3);

        // 랜덤숫자 지정해서 검증하기
        ArrayList<Integer> dataList10 = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int value = random.nextInt(100);
            dataList10.add(value);
        }
        BubbleSort bs = new BubbleSort();
        bs.sort(dataList10);

        System.out.println(dataList10);
    }
}
