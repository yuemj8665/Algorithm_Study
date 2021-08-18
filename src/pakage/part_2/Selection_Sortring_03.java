package pakage.part_2;

import java.util.ArrayList;
import java.util.Collections;

public class Selection_Sortring_03 {
    public static class SortringPractice {
        /**
         * * 데이터가 두 개 일때
         *   - 예: dataList = [9, 1]
         *     - dataList[0] > dataList[1] 이므로 dataList[0] 값과 dataList[1] 값을 교환
         * * 데이터가 세 개 일때
         *   - 예: dataList = [9, 1, 7]
         *     - 처음 한번 실행하면, 1, 9, 7 이 됨
         *     - 두 번째 실행하면, 1, 7, 9 가 됨
         * * 데이터가 네 개 일때
         *   - 예: dataList = [9, 3, 2, 1]
         *     - 처음 한번 실행하면, 1, 3, 2, 9 가 됨
         *     - 두 번째 실행하면, 1, 2, 3, 9 가 됨
         *     - 세 번째 실행하면, 변화 없음
         */

        /**
         * 데이터가 2개이래 생각해보자.
         *
         * @param datalist
         * @return
         */
        public ArrayList<Integer> mySortring2(ArrayList<Integer> datalist) {
            if (datalist.get(0) < datalist.get(1)) {
                Collections.swap(datalist, 0, 1);
            }
            return datalist;
        }

        /**
         * 데이터가 3개 이상일떄 선택정렬
         * @param datalist
         * @return
         */
        public ArrayList<Integer> mySortring3(ArrayList<Integer> datalist) {
            boolean sorting = false;
            int count = 0;
            for (int i = 0; i < datalist.size(); i++) {
                for (int k = i+1; k < datalist.size(); k++) {
                    if (datalist.get(i) > datalist.get(k)) {
                        Collections.swap(datalist,i,k);
                        sorting=true;
                        count++;
                    }
                }
                if (sorting = false) {
                    break;
                }
            }
            System.out.println("회전 수 : " + count);
            return datalist;
        }

        /**
         * 강의에서 만든 내용
         * 차이점 : 내가 한 내용은 가장 작은 값을 비교한게 아닌 그냥 처음부터 끝까지 전부 비교했다.
         * 효율성에서 떨어진다.
         */
        public ArrayList<Integer> sort(ArrayList<Integer> dataList){
            int lowest; // 가장 작은 인덱스를 찾기 위해 변수선언
            for (int stand = 0; stand < dataList.size() - 1; stand++) {
                lowest = stand; // 가장 작은 숫자부터 인덱스 정렬을 위해 우선 가장 앞쪽에 lowest를 넣는다
                for (int index = stand + 1; index < dataList.size(); index++) { // 이후 인덱스 시작부터 찾는다.
                    if (dataList.get(lowest) > dataList.get(index)) { // 찾다가 현재 lowest가 가지고있는 값보다 작다면
                        lowest = index; // lowest를 가지고온다.
                    }
                }
                Collections.swap(dataList, lowest, stand); // 이후 swap
            }
            return dataList;
        }
    }



    public static void main(String[] args) {
        SortringPractice sp = new SortringPractice();

        // 데이터가 2개일 떄 테스트
        ArrayList<Integer> dataList1 = new ArrayList<>();
        dataList1.add(1);
        dataList1.add(2);
        System.out.println("dataList1 sotring2 전 : " + dataList1);
        sp.mySortring2(dataList1);
        System.out.println("dataList1 sotring2 후 : " + dataList1);

        ArrayList<Integer> dataList2 = new ArrayList<>();
        dataList2.add(2);
        dataList2.add(1);
        System.out.println("sorting2 sotring2 전 : " + dataList2);
        sp.mySortring2(dataList2);
        System.out.println("sorting2 sotring2 후 : " + dataList2);

        // 데이터가 3개 이상일 때 테스트
        ArrayList<Integer> dataList3 = new ArrayList<>();
        dataList3.add(9);
        dataList3.add(1);
        dataList3.add(2);
        dataList3.add(3);
        System.out.println("sorting3 sotring3 전 : " + dataList3);
        sp.mySortring3(dataList3);
        System.out.println("sorting3 sotring3 후 : " + dataList3);

        ArrayList<Integer> dataList4 = new ArrayList<>();
        dataList4.add(1);
        dataList4.add(2);
        dataList4.add(3);
        dataList4.add(9);
        System.out.println("sorting4 sotring4 전 : " + dataList4);
        sp.mySortring3(dataList4);
        System.out.println("sorting4 sotring4 후 : " + dataList4);

        ArrayList<Integer> dataList5 = new ArrayList<>();
        dataList5.add(9);
        dataList5.add(1);
        dataList5.add(4);
        dataList5.add(5);
        dataList5.add(8);
        dataList5.add(2);
        dataList5.add(0);
        dataList5.add(3);

        System.out.println("sorting5 sotring5 전 : " + dataList5);
        sp.mySortring3(dataList5);
        System.out.println("sorting5 sotring5 후 : " + dataList5);

        /**
         * 100개의 List를 정렬한다.
         */
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }
        SortringPractice sSort = new SortringPractice();
        sSort.sort(testData);
        System.out.println(testData);

    }
}
