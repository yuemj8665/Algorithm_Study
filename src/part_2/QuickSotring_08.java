package part_2;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSotring_08 {

    public static class Split {
        public void splitFunc(ArrayList<Integer> dataList) {
            if (dataList.size() < 1) {
                return ;
            }
            int pivot = dataList.get(0);
            ArrayList<Integer> leftList = new ArrayList<>();
            ArrayList<Integer> rightList = new ArrayList<>();

            for (int index = 1; index < dataList.size(); index++){
                if (dataList.get(index) > pivot) {
                    rightList.add(dataList.get(index));
                } else {
                    leftList.add(dataList.get(index));
                }
            }

            ArrayList<Integer> mergedArray = new ArrayList<>();
            mergedArray.addAll(leftList);
            mergedArray.addAll(Arrays.asList(pivot));
            mergedArray.addAll(rightList);
            System.out.println(mergedArray);
        }
    }

    public static class QuickSort {
        public ArrayList<Integer> quickSort(ArrayList<Integer> dataList) {
            if (dataList.size() < 1) {
                return dataList;
            }
            int pivot = dataList.get(0);
            ArrayList<Integer> leftArr = new ArrayList<>();
            ArrayList<Integer> rightArr = new ArrayList<>();

            for (int i = 1; i < dataList.size(); i++) {
                if (dataList.get(i) > pivot) {
                    rightArr.add(dataList.get(i));
                } else {
                    leftArr.add(dataList.get(i));
                }
            }
            ArrayList<Integer> resultList = new ArrayList<>();
            resultList.addAll(this.quickSort(leftArr));
            resultList.addAll(Arrays.asList(pivot));
            resultList.addAll(this.quickSort(rightArr));

            return resultList;
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(7);

        Split split = new Split();
        split.splitFunc(list);

        ArrayList<Integer> testList = new ArrayList<>();
        Integer[] testArray = {2, 15, 16, 17, 17, 19, 21, 21, 21, 22, 23, 24, 24, 0, 0, 0, 1, 1, 2, 3, 4, 6, 6, 7, 9, 9, 10, 11, 12, 15, 16, 17, 17, 19, 21, 21, 21, 22, 23, 24, 24, 26, 27, 28, 29, 30, 31, 33, 34, 71, 72, 74, 74, 75, 76, 77, 81, 81, 82, 83, 84, 84, 84, 84, 86, 87, 88, 88, 91, 91, 35, 35, 35, 38, 39, 41, 42, 43, 44, 47, 48, 2, 3, 4, 6, 6, 7, 9, 9, 10, 11, 12, 15, 16, 17, 48, 48, 54, 54, 56, 57, 59, 60, 60, 61, 62, 63, 65, 66, 66, 66, 67, 69, 69, 69, 71, 72, 74, 74, 75, 76, 77, 81, 81, 82, 83, 84, 84, 84, 84, 86, 87, 88, 88, 91, 91, 93, 93, 94, 94, 94, 95, 95, 96, 97, 98, 98, 99};

        testList.addAll(Arrays.asList(testArray));
        QuickSort qs = new QuickSort();
        System.out.println(qs.quickSort(testList));


    }
}
