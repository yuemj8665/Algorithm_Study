package review;

import java.util.ArrayList;

public class HeapReview {

    /**
     * 힙은 데이터에서 최댓값과 최소값을 찾기 위한 완전 이진트리
     * 우선순위 큐와 같이 최대값과 최소값을 구하기 위한 자료구조이다.
     * 우선순위 큐란? : 각각의 데이터를 넣을 때 우선순위를 같이 기재해서 놓고 빼낼때에는 우선순위가 가장 높은것부터(최대값부터) 뽑는다.
     * 구현해야 할 것
     * 1. 생성자
     * 2. move_up : 자식노드를 기준으로 부모노드와 비교하여 while문 회전
     * 3. move_down : 부모노드를 기준으로 자식노드와 비교하여 while문 회전
     * 4. insert : 데이터 삽입
     * 5. pop : 맨 위쪽 노드(가장 큰 노드) 삭제
     * 특이사항 : 계산 복잡도를 떨어뜨리기 위해서 0번 인덱스는 null로 두고 시작한다.
     */

    public ArrayList<Integer> heapArray = null;

    /**
     * 생성자
     * @param data
     */
    public HeapReview(Integer data) {
        heapArray = new ArrayList<>();
        heapArray.add(null); // 특이사항 : 계산 복잡도를 떨어뜨리기 위해서 0번 인덱스는 null로 두고 시작한다.
        heapArray.add(data);
    }

    /**
     * move_up : 자식노드를 기준으로 부모노드와 비교하여 while문 회전
     * @param inserted_data
     * @return
     */
    public boolean move_up(Integer inserted_data) {

        return true;
    }

    /**
     * move_down : 부모노드를 기준으로 자식노드와 비교하여 while문 회전
     * @param poped_data
     * @return
     */
    public boolean move_down(Integer poped_data) {
        return true;

    }

    /**
     * insert : 데이터 삽입
     * @param data
     * @return
     */
    public boolean insert(Integer data) {
        return true;
    }

    /**
     * pop : 맨 위쪽 노드(가장 큰 노드) 삭제
     * @return
     */
    public Integer pop() {
        return 0;
    }



    public static void main(String[] args) {

    }
}
