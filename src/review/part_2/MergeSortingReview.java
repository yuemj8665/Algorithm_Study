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
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        leftArr = this.mergeSplitFunc(new ArrayList<>(dataList.subList(0, medium)));
        rightArr = this.mergeSplitFunc(new ArrayList<>(dataList.subList(medium, dataList.size())));

        return mergeFunc(leftArr, rightArr);
    }

    /**
     * 목표: leftArr와 rightArr을 합쳐 mergedList을 만듦
     * LeftArr와 rightArr은 이미 정렬된 상태, 혹은 하나의 인덱스를 가지고있다.
     *
     * 과정:
     * leftpoint, rightpoint = 0;
     * Case 1 : leftpoint, rightpoint가 둘 다 있을 때
     * Case 2 : rightpoint만 없을 시, 나머지 leftList에 있는 데이터를 그대로 mergedList로 넣는다.
     * Case 3 : leftpoint만 없을 시, 나머지 rightList에 있는 데이터를 그대로 mergedList로 넣는다.
     *
     * @param leftArr
     * @param rightArr
     * @return
     */
    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        ArrayList<Integer> mergedList = new ArrayList<>();

        int leftpoint = 0;
        int rightpoint = 0;

        // Case 1 : leftpoint, rightpoint가 둘 다 있을 때
        while (leftArr.size() > leftpoint && rightArr.size() > rightpoint) {
            // 작은 숫자를 먼저 추가시켜준다
            if (leftArr.get(leftpoint) < rightArr.get(rightpoint)) {
                mergedList.add(leftArr.get(leftpoint));
                leftpoint++;
            } else {
                mergedList.add(rightArr.get(rightpoint));
                rightpoint++;
            }
        }

        // Case 2 : rightpoint만 없을 시, 나머지 leftList에 있는 데이터를 그대로 mergedList로 넣는다.
        // 여기까지 왔으면 right가 없는 조건으로 while문 안으로 들어간다.
        while (leftArr.size() > leftpoint) {
            mergedList.add(leftArr.get(leftpoint));
            leftpoint++;
        }

        while (rightArr.size() > rightpoint) {
            mergedList.add(rightArr.get(rightpoint));
            rightpoint++;
        }

        System.out.printf("mergefunc | mergedList | %s \r\n", mergedList);
        return mergedList;
    }

    public static void main(String[] args) {
        MergeSortingReview mergeSortingReview = new MergeSortingReview();
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            dataList.add((int) (Math.random() * 100));
        }
        mergeSortingReview.mergeSplitFunc(dataList);
    }


}
