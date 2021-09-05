package review.part_2;

import onlineClass.part_2.SequentialSearch_09;

import java.util.ArrayList;

public class SequentialSearchReview {
    public int sequentialSearch(ArrayList<Integer> dataList, int data) {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i) == data) {
                return i;
            } else {
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testData.add((int) (Math.random() * 100));
        }

        SequentialSearchReview ss = new SequentialSearchReview();
        int searchIndex = ss.sequentialSearch(testData, 5);
        System.out.println(searchIndex);
    }
}
