package jupyter;

import java.util.ArrayList;
import java.util.Collections;

public class Heap_08 {
    public ArrayList<Integer> heapArray = null;

    public Heap_08 (Integer data) {
        heapArray = new ArrayList<>();
        heapArray.add(null); // 계산 복잡도를 떨어뜨리기 위해서 0번 인덱스는 null로 두겠다.
        heapArray.add(data); // 위 코드로 1번 인덱스부터 들어간다.
    }

    public boolean move_up(Integer inserted_idx){
        if (inserted_idx <= 1) {
            return false;
        }
        Integer parent_idx = inserted_idx / 2;
        if (this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) {
            return true;
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

        while (this.move_up(inserted_idx)) {
            parent_idx=inserted_idx / 2;
            Collections.swap(this.heapArray,inserted_idx,parent_idx);
            inserted_idx=parent_idx;
        }
        return true;
    }



    public boolean move_down(Integer popped_idx){
        Integer left_child_popped_idx, right_child_popped_idx;
        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        // CASE1 : 왼쪽 자식 노드도 없을 때 ( 자식 노드가 하나도 없을 때 )
        if (left_child_popped_idx >= this.heapArray.size()) {
            return false;
        } // CASE 2 : 오른쪽 자식 노드만 없을 때
        else if (right_child_popped_idx >= this.heapArray.size()) {
            if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                return true;
            } else {
                return false;
            }
        }
        // CASE 3 : 왼쪽/오른쪽 자식노드가 모두 있을 때
        else {
            if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public Integer pop(){
        Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;
        if (this.heapArray == null) {
            return null;
        } else {
            returned_data = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
            this.heapArray.remove(this.heapArray.size() - 1);
            popped_idx = 1;

            while (this.move_down(popped_idx)) {
                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx *2  + 1;
                // CASE 1 : 오른쪽 자식 노드만 없을 때
                if (right_child_popped_idx >= this.heapArray.size()) {
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                        Collections.swap(heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                    // CASE 2 : 왼쪽 오른쪽 자식노드가 모두 있을 떄
                } else {
                    if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                        if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                            Collections.swap(heapArray, popped_idx,left_child_popped_idx);
                            popped_idx = left_child_popped_idx;
                        }
                    } else {
                        if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                            Collections.swap(heapArray,popped_idx,right_child_popped_idx);
                            popped_idx = right_child_popped_idx;
                        }
                    }
                }

            }
            return returned_data;
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
