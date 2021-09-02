package review.part_2;

import java.util.ArrayList;

public class MergeSortingReview {
    /**
     * - 재귀용법을 사용하는 정렬 알고리즘
     * 1. 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
     * 2. 각 부분 리스트를 재귀적으로 다시 합병 정렬을 이용해 정렬한다.
     * 3. 두 부분 리스트를 하나의 정렬된 리스트로 합병한다.
     * <p>
     * - 병합 정렬은 두 가지 단계를 거친다.
     * 1. 끝없이 분할하는 분할 정복
     * - 문제를 나눌 수 없을 때까지 나누어서 각각을 풀면서 다시 합병하여 문제의 답을 얻는 알고리즘
     * - 하향식 접근법으로, 상위의 해답을 구하기 위해 아래로 내려가면서 하위의 해답을 구하는 방식
     * - 일반적으로 재귀함수로 표현한다.
     * - 문제를 잘게 쪼갤때, 부분 문제는 서로 중복하지 않는다.
     * - 에) 병합 정렬, 퀵 정렬 등
     * 2. 병합 시 각각의 데이터를 비교하여 정렬하여 병합한다.
     * - 병합 할 때 각각의 데이터의 포인터를 두고, 가리키는 데이터끼리 비교하여 작은것부터 정렬시킨다.
     */

    /**
     * 우선 나누는 메소드 연습하기.
     * @param dataList
     */
    public void divied(ArrayList<Integer> dataList) {
        // 왼쪽/오른쪽 List 생성
        ArrayList<Integer> leftArr, rightArr;
        
        if (dataList.size() <= 1) {
            return ;
        }
        // 반으로 나누기 위함
        int medium = dataList.size() / 2;

        // 반으로 나눈 데이터에서 왼쪽/오른쪽
        leftArr = new ArrayList<>(dataList.subList(0, medium));
        rightArr = new ArrayList<>(dataList.subList(medium, dataList.size()));

        System.out.println("왼쪽 리스트 : " + leftArr);
        System.out.println("오른쪽 리스트 : " + rightArr);

    }

    // mergeSplitFunc 메소드(재귀용법) 틀 만들기
    /**
     * 만약 배열 개수가 한개이면 해당 값 그대로 리턴
     * 그렇지 않으면 배열을 앞, 뒤로 나눈다.
     * leftArr = mergeSplitFunc 앞
     * rightArr = mergeSplitFunc 뒤
     *
     * @param dataList
     * @return
     */
    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        // 만약 들어온 리스트의 size가 1개 이하라면 그대로 반환한다.
        if (dataList.size() <= 1) {
            return dataList;
        }

        int medium = dataList.size() / 2;
        ArrayList<Integer> leftArr, rightArr;

        leftArr = new ArrayList<>(dataList.subList(0, medium));
        rightArr = new ArrayList<>(dataList.subList(medium, dataList.size()));

        return mergeFunc(leftArr, rightArr);
    }

    /**
     *
     * @param leftArr
     * @param rightArr
     * @return
     */
    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        ArrayList<Integer> mergedList = new ArrayList<>();



        return null;
    }


}
