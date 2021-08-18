package review.part1;

import java.util.ArrayList;

public class StackReview {
    /**
     * 연습해보기
     * - JAVA ArrayList 클래스를 활용해서 스택을 다루는 push, pop 기능 구현해보기
     * - pop 기능 호출 시, 스택에 데이터가 없을 경우, null 을 리턴하도록 함
     * - 다양한 데이터 타입을 다룰 수 있도록, Java Genric 타입 문법을 활용해보기
     */
    public static void main(String[] args) {
        class myStack<T> {
            ArrayList<T> list = new ArrayList<>();

            public void push(T data) {
                list.add(data);
            }

            public T pop(){
                if (list.size() == 0) {
                    return null;
                } else {
                    return list.remove(list.size()-1);

                }
            }
        }

        myStack<Integer> ms = new myStack<>();

        ms.push(1);
        ms.push(2);
        ms.push(3);

        System.out.println(ms.pop());

    }
}
