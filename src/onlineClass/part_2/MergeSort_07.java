package onlineClass.part_2;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort_07 {
    /**
     * 우선 작은 부분부터 작성하여 하나씩 구현하기
     */
    // 배열을 앞 뒤 두 배열로 짜르는 코드 작성해보기
    public void splitArray(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) { // 자를게 없으므로 그냥 아무것도 안한다.
            return ; // 바로 메소드 return 시켜서 종료한다.
        }
        int medium = dataList.size() / 2; // ArrayList를 절반으로 나누기 위해 인덱스를 결정한다.
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        // subList = 0부터 medium-1 인덱스 번호까지 해당 배열 아이템을 서브 배열로 추출한다
        leftArr = new ArrayList<Integer>(dataList.subList(0, medium));
        // 그리고 나머지 넣기
        rightArr = new ArrayList<Integer>(dataList.subList(medium, dataList.size()));

        System.out.println(leftArr);
        System.out.println(rightArr);
        }

    // mergeSplitFunc 메소드(재귀용법) 틀 만들기
    /**
     * 만약 배열 개수가 한개이면 해당 값 그대로 리턴
     * 그렇지 않으면 배열을 앞, 뒤로 나눈다.
     * leftArr = mergeSplitFunc 앞
     * rightArr = mergeSplitFunc 뒤
     *
     * @param dataList
     * @return mergeFunc(leftArr,rightArr) 메소드
     */
    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        // 중간까지는 기존에 만든 subList를 사용했지만,
        // 이번건 반복하여 최대갯수로 쪼개기 위해 재귀함수를 사용한다.
        // 재호출 재호출 재호출.. 함으로써 최대 갯수로 쪼개어 정렬을 한다.
        leftArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
        rightArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));

        // 로그 표출용 printf
        System.out.printf("mergeSplitFunc | leftArr  | %s \r\n",leftArr);
        System.out.printf("mergeSplitFunc | rightArr | %s \r\n",rightArr);

        return mergeFunc(leftArr,rightArr);
    }

    /**
     * 목표: leftArr와 rightArr의 배열을 정렬하면서 합침. mergedList라는 이름으로 return하기.
     * leftArr와 rightArr는 이미 정렬된 상태, 또는 하나이다.
     *
     * 과정:
     * ArrayList만들기
     * leftPoint, rightPoint = 0
     * Case 1 : leftPoint, rightPoint가 둘다 있을 떄
     * Case 2 : rightPoint만 없을 시, 나머지 leftList에 있는 데이터를 그대로 mergedList 뒤에 넣음
     * Case 3 : leftPoint만 없을 시, 나머지 rightPoint에 있는 데이터를 그대로 mergedList 뒤에 넣음
     * @param leftArr
     * @param rightArr
     * @return
     */
    private ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        // Case 1 : leftPoint, rightPoint가 둘다 있을 떄
        while (leftArr.size() > leftPoint && rightArr.size() > rightPoint) {
            // 작은 쪽을 우리가 return하려는 list에 추가시켜준다.
            if (leftArr.get(leftPoint) < rightArr.get(rightPoint)) {
                mergedList.add(leftArr.get(leftPoint));
                leftPoint++;
            } else {
                mergedList.add(rightArr.get(rightPoint));
                rightPoint++;
            }
        }

        // Case 2 : rightPoint만 없을 시, 나머지 leftList에 있는 데이터를 그대로 mergedList 뒤에 넣음
        // 여기까지 왔으면 right가 없는 조건으로 while문 안으로 들어간다.
        while (leftArr.size() > leftPoint) {
            mergedList.add(leftArr.get(leftPoint));
            leftPoint++;
        }

        // Case 3 : leftPoint만 없을 시, 나머지 rightPoint에 있는 데이터를 그대로 mergedList 뒤에 넣음
        // 여기까지 왔으면 left가 없는 조건으로 while문 안으로 들어간다.
        while (rightArr.size() > rightPoint) {
            mergedList.add(rightArr.get(rightPoint));
            rightPoint++;
        }

        // 로그 표출용 printf
        System.out.printf("mergeFunc | mergedList | %s \r\n",mergedList);
        return mergedList;
    }

    public static void main(String[] args) {
        MergeSort_07 ms = new MergeSort_07();
        ms.splitArray(new ArrayList<Integer>(Arrays.asList(4,1,2,6,7,8,3,5)));
        ms.splitArray(new ArrayList<Integer>(Arrays.asList(4,1,2,6,7,8,3)));

        MergeSort_07 msTest = new MergeSort_07();
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            dataList.add((int) (Math.random() * 100));
        }
        msTest.mergeSplitFunc(dataList);

    }
}

