package review.part1;

import java.util.ArrayList;
import java.util.Collections;

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
     * @param inserted_index
     * @return
     */
    public boolean move_up(Integer inserted_index) {
        if (inserted_index <= 1) {
            return false;
        }

        Integer parent_index = inserted_index / 2;
        if (this.heapArray.get(inserted_index) > this.heapArray.get(parent_index)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * move_down : 부모노드를 기준으로 자식노드와 비교하여 while문 회전
     * 이 메소드에는 세 가지 케이스가 있다.
     * 1. 왼쪽 자식 노드 조차 없을때 (heap은 왼쪽부터 채워넣으므로, 왼쪽에도 없으면 오른쪽도 없다)
     * 2. 왼쪽 자식노드만 있고, 오른쪽은 없을 경우
     * 3. 둘다 있을 경우
     * @param poped_index
     * @return
     */
    public boolean move_down(Integer poped_index) {
        Integer left_child_poped_index;
        Integer right_child_poped_index;

        left_child_poped_index = poped_index * 2;
        right_child_poped_index = poped_index * 2 + 1;

        // Case 1 : 자식노드가 없을 때
        if (left_child_poped_index >= this.heapArray.size()) {
            return false;
        } else if (right_child_poped_index >= this.heapArray.size()) { // Case 2 : 오른쪽 자식 노드가 없을 때때
            if (this.heapArray.get(poped_index) < this.heapArray.get(left_child_poped_index)) {
                return true;
            } else {
                return false;
            }
        } else { // Case 3 : 양쪽 자식 둘 다 있을 경우
            // 왼쪽 값이 오른쪽 값보다 클 경우
            if (this.heapArray.get(left_child_poped_index) > this.heapArray.get(right_child_poped_index)) {
                if (this.heapArray.get(poped_index) < this.heapArray.get(left_child_poped_index)) {
                    return true;
                } else {
                    return false;
                }
            } else { // 오른쪽 값이 왼쪽 값보다 클 경우
                if (this.heapArray.get(poped_index) < this.heapArray.get(right_child_poped_index)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * insert : 데이터 삽입
     * @param data
     * @return
     */
    public boolean insert(Integer data) {
        Integer inserted_index, parent_index;
        if (heapArray == null) {
            heapArray = new ArrayList<>();
            heapArray.add(null);
            heapArray.add(data);
            return true;
        }
        this.heapArray.add(data);
        inserted_index = this.heapArray.size() - 1; // 0부터가 아니라 1부터시작하니까

        while (this.move_up(inserted_index)) {
            parent_index = inserted_index / 2;
            Collections.swap(this.heapArray, inserted_index, parent_index);
            inserted_index = parent_index;
        }
        return true;
    }

    /**
     * pop : 맨 위쪽 노드(가장 큰 노드) 삭제
     * @return
     */
    public Integer pop() {
        Integer returned_data, poped_index, left_child_poped_index, right_child_poped_index;
        if (this.heapArray == null) {
            return null;
        } else {
            /**
             * 상단의 데이터 삭제시, 가장 최하단부 왼쪽에 위치한 노드 (일반적으로 가장 마지막에 추가한 노드) 를 root 노드로 이동
             * root 노드의 값이 child node 보다 작을 경우, root 노드의 child node 중 가장 큰 값을 가진 노드와
             * root 노드 위치를 바꿔주는 작업을 반복함 (swap)
             */
            returned_data = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.size() - 1); // 가장 마지막 추가 한 노드를 root로 이동
            this.heapArray.remove(this.heapArray.size() - 1); // 마지막건 삭제
            poped_index = 1;

            while (this.move_down(poped_index)) {
                left_child_poped_index = poped_index * 2;
                right_child_poped_index = poped_index * 2 + 1;

                // Case 1 : 오른쪽 자식 노드가 없을때(왼쪽만 있을 경우)
                if (right_child_poped_index >= this.heapArray.size() - 1) {
                    if (this.heapArray.get(poped_index) < this.heapArray.get(left_child_poped_index)) {
                        Collections.swap(this.heapArray, poped_index, left_child_poped_index);
                        poped_index = left_child_poped_index;
                    }
                } else { // Case 2 : 왼쪽 오른쪽 다있을 경우
                    if (this.heapArray.get(left_child_poped_index) > this.heapArray.get(right_child_poped_index)) {
                        if (this.heapArray.get(poped_index) < this.heapArray.get(left_child_poped_index)) {
                            Collections.swap(this.heapArray, poped_index, left_child_poped_index);
                            poped_index = left_child_poped_index;
                        }
                    } else {
                        if (this.heapArray.get(poped_index) < this.heapArray.get(right_child_poped_index)) {
                            Collections.swap(this.heapArray, poped_index, right_child_poped_index);
                            poped_index = right_child_poped_index;
                        }
                    }
                }
            }
            return returned_data;
        }
    }

    public static void main(String[] args) {
        HeapReview heap_test = new HeapReview(1);
        System.out.println(heap_test.heapArray);

        HeapReview heap_test_2 = new HeapReview(1);
        heap_test_2.insert(1);
        heap_test_2.insert(2);
        heap_test_2.insert(3);
        heap_test_2.insert(4);
        heap_test_2.insert(5);
        heap_test_2.insert(6);

        System.out.println(heap_test_2.heapArray);

        ArrayList<Integer> heapArray = new ArrayList<>();
        heapArray.add(1);
        heapArray.add(2);
        System.out.println("교체 전 : "+heapArray);

        Collections.swap(heapArray,0,1);
        System.out.println("교체 후 : "+heapArray);

        HeapReview heapTest = new HeapReview(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        heapTest.insert(2);

        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);
    }
}
