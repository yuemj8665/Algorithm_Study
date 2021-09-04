package review.part_2;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSotringReview {

    /**
     * Quick Sort는 기준점을 정하고 그 기점으로 좌측, 우측으로 나누어 리스트로 정렬 한 뒤
     * 리스트를 합쳐서 리턴한다.
     * 리스트를 쪼개고 쪼개고 쪼개서 사용하는 재귀용법
     * @param dataList
     * @return
     */
    public ArrayList<Integer> quickSort(ArrayList<Integer> dataList) {
        if (dataList.size() < 1) { // 더이상 쪼갤 리스트가 없을 때 그 값 리턴.
            return dataList;
        }
        int pivot = dataList.get(0); // 기준점은 0번 인덱스
        ArrayList<Integer> leftArr = new ArrayList<>(); // 기준점의 왼쪽
        ArrayList<Integer> rightArr = new ArrayList<>(); // 기준점의 오른쪽

        for (int i = 1; i < dataList.size(); i++) { // 0번 인덱스는 기준점이므로 1번 인덱스부터 비교 시작
            if (dataList.get(i) < pivot) { // 기준점과 값을 비교
                leftArr.add(dataList.get(i)); // 기준점보다 값이 작으면 왼쪽
            } else {
                rightArr.add(dataList.get(i)); // 크면 오른쪽
            }
        }

        ArrayList<Integer> resultArr = new ArrayList<>();
        resultArr.addAll(this.quickSort(leftArr)); // 왼쪽으로 들어간 리스트를 다시 재호출하여 다시 나눈다.
        resultArr.addAll(Arrays.asList(pivot)); // 기준점은 넣어줘야함
        resultArr.addAll(this.quickSort(rightArr)); // 오른쪽도

        return resultArr;
    }
    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();
        Integer[] testArray = {2, 15, 16, 17, 17, 19, 21, 21, 21, 22, 23, 24, 24, 0, 0, 0, 1, 1, 2, 3, 4, 6, 6, 7, 9, 9, 10, 11, 12, 15, 16, 17, 17, 19, 21, 21, 21, 22, 23, 24, 24, 26, 27, 28, 29, 30, 31, 33, 34, 71, 72, 74, 74, 75, 76, 77, 81, 81, 82, 83, 84, 84, 84, 84, 86, 87, 88, 88, 91, 91, 35, 35, 35, 38, 39, 41, 42, 43, 44, 47, 48, 2, 3, 4, 6, 6, 7, 9, 9, 10, 11, 12, 15, 16, 17, 48, 48, 54, 54, 56, 57, 59, 60, 60, 61, 62, 63, 65, 66, 66, 66, 67, 69, 69, 69, 71, 72, 74, 74, 75, 76, 77, 81, 81, 82, 83, 84, 84, 84, 84, 86, 87, 88, 88, 91, 91, 93, 93, 94, 94, 94, 95, 95, 96, 97, 98, 98, 99};

        testList.addAll(Arrays.asList(testArray));
        QuickSotringReview qs = new QuickSotringReview();
        System.out.println(qs.quickSort(testList));
    }
}
