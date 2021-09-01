package review.part_2;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSotringReview {

    /**
     * - 데이터가 두 개일 때 삽입정렬
     * - 데이터 예시 list = [5,3]
     * - 3이 보다 작음으로 교환, 결과적으로 [3,5]가 됨
     * - 데이터가 세 개일 때 삽입정렬
     * - 데이터 예시 list = [5,3,2]
     * - 두 번째 인덱스부터 시작, 3이 더 작음으로 3이 앞으로 가게됨 [3,5,2]
     * - 세 번쨰 인덱스 시작, 2는 5보다 작고, 3보다도 작음 [2,3,5]
     * - think) 세 번쨰 인덱스 시작 시, 2와 5와 3을 비교할때에 앞자리와 비교하는 반복문을 사용하는 것 같다.
     * - 데이터가 네 개일 때 삽입정렬
     * - 데이터 예시 list = [5,3,2,4]
     * - 두 번째 인덱스부터 시작, 3이 더 작음으로 3이 앞으로 가게됨 [3,5,2,4]
     * - 세 번쨰 인덱스 시작, 2는 5보다 작고, 3보다도 작음 [2,3,5,4]
     * - 네 번쨰 인덱스 시작, 4는 5보다 작고 3보다 크므로 [2,3,4,5]
     * - think) 네 번쨰 인덱스가 3과 비교할때에는 어차피 앞쪽 인덱스와 더이상 비교를 할 이유가 없으니
     * false를 반환해서 앞자리와 비교하는 반복문을 끝내면 좋을 것 같다.
     * - think) 반복문을 생각해보자.
     *  1. 첫 dataList는 한번 회전 해야함.
     *  2. 첫 인덱스와 비교 할 인덱스가 필요함.
     *  3. 더이상 교환이 이루어지지 않으면 반복문을 끝내야한다.
     */

    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int i = 1; i < dataList.size()-1; i++) {
            for (int k = i+1; k > 0; k--) {
                if (dataList.get(k) < dataList.get(k-1)) {
                    Collections.swap(dataList, k, k-1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        InsertionSotringReview insertionSotringReview = new InsertionSotringReview();
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dataList.add((int)(Math.random()*100));
        }
        insertionSotringReview.sort(dataList);
        System.out.println(dataList);
    }
}
