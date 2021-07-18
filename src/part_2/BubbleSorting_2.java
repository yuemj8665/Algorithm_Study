package part_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BubbleSorting_2 {
    public static class BubbleSort{
        /**
         * 데이터가 4개 이상일때 버블정렬하기
         * 특이점 :
         * n개의 리스트가 있는 경우 최대 n-1번의 로직을 적용한다.
         * 로직을 1번 적용할 때마다 가장 큰 숫자가 뒤에서부터 1개씩 결정된다.
         * 로직이 경우에따라 일찍 끝날 수도있다.
         * 따라서 로직을 적용할때 한번도 데이터가 교환된 적이 없다면 이미 정렬된 상태이므로 더이상 로직을 반복 적용할 필요가 없다.
         *
         * @param dataList
         * @return
         */
        public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
            for (int i = 0; i < dataList.size() - 1; i++) {
                boolean swap = false;
                for (int index = 0; index < dataList.size() - 1 - i; index++) {
                    if (dataList.get(index) > dataList.get(index + 1)) {
                        Collections.swap(dataList,index,index+1);
                        swap = true;
                    }
                }
                if (swap == false) {
                    break;
                }
            }
            return dataList;
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
        for (int i = 0; i < 100; i++) {
            int value = random.nextInt(100);
            dataList10.add(value);
        }
        BubbleSort bs = new BubbleSort();
        bs.sort(dataList10);

        System.out.println(dataList10);
    }
}
