package review.part_2;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSortingReview {
    public ArrayList<Integer> QuickSorting(ArrayList<Integer> dataList) {
        if (dataList.size() < 1) {
            return dataList;
        }

        // 퀵소팅을 위한 기준점
        int pivot = dataList.get(0);
        // 기준점 왼쪽, 오른쪽 list
        ArrayList<Integer> leftArray = new ArrayList<>();
        ArrayList<Integer> rightArray = new ArrayList<>();

        for (int i = 1; i < dataList.size(); i++) {
            // 기준점과 받은 dataList의 각 항을 비교하여 큰 숫자는 오른쪽에 넣는다
            if (dataList.get(i) > pivot) {
                rightArray.add(dataList.get(i));
                
            } else { // 나머지는 왼쪽에 넣는다.
                leftArray.add(dataList.get(i));
            }
        }

        // 결과 List를 만든다
        ArrayList<Integer> resultList = new ArrayList<>();
        // 결과 List를 재귀함수로 다시 leftArray로 퀵소팅
        resultList.addAll(this.QuickSorting(leftArray));
        // 기준점을 넣고
        resultList.addAll(Arrays.asList(pivot));
        // 결과 List를 재귀함수로 다시 rightArray로 퀵소팅
        resultList.addAll(this.QuickSorting(rightArray));

        return resultList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(7);
        QuickSortingReview quickSortingReview = new QuickSortingReview();
        System.out.println(quickSortingReview.QuickSorting(list));
    }
}
