package part_1;

import java.util.ArrayList;
import java.util.Collections;

public class Heap_08 {
    public ArrayList<Integer> heapArray = null;

    public Heap_08 (Integer data) {
        heapArray = new ArrayList<>();
        heapArray.add(null); // 계산 복잡도를 떨어뜨리기 위해서 0번 인덱스는 null로 두겠다.
        heapArray.add(data); // 위 코드로 1번 인덱스부터 들어간다.
    }

    /**
     * 자식노드를 기준으로 부모노드와 비교하여 while문을 회전시킨다.
     * @param inserted_idx
     * @return
     */
    public boolean move_up(Integer inserted_idx){
        if (inserted_idx <= 1) {
            return false;
        }
        Integer parent_idx = inserted_idx / 2;
        if (this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) { // 부모노드랑 자식노드랑 값을 비교한다.
            return true; // 자식노드가 크면 true를 반환하여 while문을 돌리게끔 한다.
        } else {
            return false;
        }
    }

    public boolean insert(Integer data) {
        Integer inserted_idx,parent_idx;
        if (heapArray == null) { // heapArray가 없으면 새로 생성한다.
            heapArray = new ArrayList<>();
            heapArray.add(null);
            heapArray.add(data);
            return true;
        }
        this.heapArray.add(data);
        inserted_idx = this.heapArray.size() - 1;

        while (this.move_up(inserted_idx)) { // 데이터가 추가가 되면 맨 마지막 노드에 생성되므로, 숫자가 더 크다면 부모노드와 교체해야한다.
            parent_idx=inserted_idx / 2; // 부모노드를 찾아서
            Collections.swap(this.heapArray,inserted_idx,parent_idx); // 숫자가 더 크다면 Collections의 swap을 이용하여 바꾼다.
            inserted_idx=parent_idx; // 이후 교체 마무리까지.
        }
        return true;
    }

    /**
     * 부모 노드를 기준으로 아래 자식노드와 비교하여 while문을 회전시킨다.
     * @param popped_idx
     * @return
     */
    public boolean move_down(Integer popped_idx){ // 부모노드를 기준으로 자식노드와 비교한다.
        Integer left_child_popped_idx, right_child_popped_idx;
        left_child_popped_idx = popped_idx * 2; // 부모노드의 왼쪽자식 노드는 부모노드*2
        right_child_popped_idx = popped_idx * 2 + 1; // 부모노드의 오른쪽자식 노드는 부모노드*2+1

        // CASE1 : 왼쪽 자식 노드도 없을 때 ( 자식 노드가 하나도 없을 때 )
        if (left_child_popped_idx >= this.heapArray.size()) { // 왼쪽 노드가 그나마 제일 마지막에 했는데 없어서 그냥 false반환
            return false;
        } // CASE 2 : 오른쪽 자식 노드만 없을 때
        else if (right_child_popped_idx >= this.heapArray.size()) {
            if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) { // 부모노드와 왼쪽 값을 비교
                return true;
            } else {
                return false;
            }
        }
        // CASE 3 : 왼쪽/오른쪽 자식노드가 모두 있을 때
        else { // 왼쪽 값이 오른쪽 값보다 클경우
            if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) { // 부모노드와 왼쪽 값을 비교함
                    return true;
                } else {
                    return false;
                }
            } else { // 오른쪽 값이 왼쪽보다 클경우
                if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) { // 부모노드와 오른쪽 값을 비교한다.
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * 맨 위쪽(가장 큰 값을 가진) 노드 삭제
     * @return returned_data (가장 높이있는 값을 삭제)
     */
    public Integer pop(){
        Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;
        if (this.heapArray == null) {
            return null;
        } else {
            returned_data = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
            this.heapArray.remove(this.heapArray.size() - 1);
            popped_idx = 1;

            while (this.move_down(popped_idx)) { // 아래쪽 노드와 비교하여 루프를 돌려서
                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx *2  + 1;
                // CASE 1 : 오른쪽 자식 노드만 없을 때
                if (right_child_popped_idx >= this.heapArray.size()) {
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) { // 부모노드가 아래와 비교해서 작다면
                        Collections.swap(heapArray, popped_idx, left_child_popped_idx); // 서로 위치를 바꾸고
                        popped_idx = left_child_popped_idx; // 다시 탐색 시작
                    }

                } else { // CASE 2 : 왼쪽 오른쪽 자식노드가 모두 있을 떄
                    if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) { // 왼쪽노드가 오른쪽보다 크면서
                        if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) { // 부모값이 작다면
                            Collections.swap(heapArray, popped_idx,left_child_popped_idx); // 회전
                            popped_idx = left_child_popped_idx; // 다시 탐색 시작
                        }
                    } else { // 왼쪽보다 오른쪽 노드가 더 크면서
                        if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) { // 부모값이 크다면
                            Collections.swap(heapArray,popped_idx,right_child_popped_idx); // 회전
                            popped_idx = right_child_popped_idx; // 다시 탐색 시작
                        }
                    }
                }
            }
            return returned_data; // 꼭대기를 리턴한다.
        }
    }

    public static void main(String[] args) {
        Heap_08 heap_test = new Heap_08(1);
        System.out.println(heap_test.heapArray);

        Heap_08 heap_test_2 = new Heap_08(1);
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

        Heap_08 heapTest = new Heap_08(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);

        System.out.println(heapTest.heapArray);


        heapTest.pop();
        System.out.println(heapTest.heapArray);
    }
}
