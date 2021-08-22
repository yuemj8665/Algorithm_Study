package review.part_1;

import java.util.ArrayList;

public class QueueReview {
    /**
     * 연습해보기
     * <p>
     * - JAVA ArrayList 클래스를 활용해서 큐를 다루는 enqueue, dequeue 기능 구현해보기
     * - dequeue 기능 호출 시, 큐에 데이터가 없을 경우, null 을 리턴하도록 함
     * - 다양한 데이터 타입을 다룰 수 있도록, Java Genric 타입 문법을 활용해보기
     */

    public static class myqueue {

    }

    public static void main(String[] args) {
        class MyQueue<T>{
            private ArrayList<T> queue = new ArrayList<>();

            // enqueue
            public void enqueue(T data) {
                queue.add(data);
            }

            // dequeue
            public T dequeue() {
                if (queue.isEmpty()) {
                    return null;
                } else {
                    return queue.remove(0);
                }
            }
        }

        MyQueue<Integer> mq = new MyQueue<>();
        mq.enqueue(1);
        mq.enqueue(2);
        System.out.println("enqueue 후");
        System.out.println(mq);
        System.out.println("dequeue 3번 실행 후");
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
    }
}
