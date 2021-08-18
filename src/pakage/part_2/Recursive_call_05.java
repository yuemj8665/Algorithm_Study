package pakage.part_2;

import java.util.ArrayList;

public class Recursive_call_05 {
    /**
     * 재귀용법의 이해
     * 예제를 풀어보며, 재귀용법을 이해해보기
     * 예제 : 팩토리얼을 구하는 알고리즘을 재귀용법을 활용하여 알고리즘 작성해보자.
     *     - 팩토리얼 :
     *         2! : 1 X 2,
     *         3! : 1 X 2 X 3
     *         4! : 1 X 2 X 3 X 4 ...
     * 아래 예제는 내가 한 것
     */
    int i = 1;
    int k = 1;
    public int Recursive_call(int data){
        if (i <= data) {
            k = k*i;
            i++;
            System.out.printf("i = %s, k= %s \r\n",i,k);
            Recursive_call(data);
        }
        return k;
    }

    /**
     * 팩토리얼 예제 답안
     * 일반적인 형태1
     * 시간 복잡도 : 일종의 n-1번의 반복문을 호출한 것과 동일하다. O(n-1)이므로, 둘다 O(n)
     * think) ;; 이렇게 간단히 되다니;; 역시 생각자체가 다른 듯 하다.
     *      그래도 어느정도는 이해가 되었다. 내가 한 내용은 일반적인 형태2가 되는 것 같다.
     *
     * @param n
     * @return
     */
    public int FactorialFunc1(int n){
        if (n > 1) {
            return n * this.FactorialFunc1(n - 1);
        } else {
            return 1;
        }
    }

    /**
     * 일반적인 형태2
     * @param n
     * @return
     */
    public int FactorialFunc2(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * FactorialFunc2(n - 1);
    }

    /**
     * 다음 메서드를 재귀 함수를 활용해서 완성해서 1부터 num까지의 곱이 출력되게 만드세요
     * @param num
     * @return
     */
    public int factorialTest1(int num) {
        if (num <= 1) {
            return num;  // 일반적인 로직상, 리턴값은 1로 작성해도 됨
        }
        return num * this.factorialTest1(num - 1);
    }

    /**
     * 숫자가 들어 있는 배열이 주어졌을 때, 배열의 합을 리턴하는 코드를 작성해보세요 (재귀용법을 써보세요)
     * tip :
     * public List<E> subList(int fromIndex, int toIndex)
     * fromIndex -> 서브셋이 시작 할 인덱스
     * toIndex -> 서브셋의 마지막 인덱스
     * 시작 인덱스서부터 마지막 인덱스까지의 ArrayList를 가져온다.
     * @param dataList
     * @return
     */
    public int factorialTest2(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            return 0;
        }
        // subList 메소드로 index는 점점 한개씩 줄어들어 결국 마지막 size는 0이 된다.
        // 0번 인덱스를 한개씩 더하게 되고, 0번 인덱스는 점점 삭제되니 결과적으로 계속해서 더하는 값이 된다.
        return dataList.get(0) + this.factorialTest2(new ArrayList<Integer>(dataList.subList(1,dataList.size())));
    }

    /**
     * - 정수 4를 1, 2, 3의 조합으로 나타내는 방법은 다음과 같이 총 7가지가 있음
     * - 정수 n이 입력으로 주어졌을 때, n을 1, 2, 3의 합으로 나타낼 수 있는 방법의 수를 구하시오
     * 1+1+1+1
     * 1+1+2
     * 1+2+1
     * 2+1+1
     * 2+2
     * 1+3
     * 3+1
     *
     * 힌트: 정수 n을 만들 수 있는 경우의 수를 리턴하는 함수를 f(n) 이라고 하면
     * f(n)은 f(n-1) + f(n-2) + f(n-3) 과 동일하다는 패턴 찾기
     * think) 이건 좀 어려웠다.. 문제 자체가 이해도 안되는게 있었음.
     */
    public int factorialTest3(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        return this.factorialTest3(n - 1) + this.factorialTest3(n - 2) + this.factorialTest3(n - 3);
    }


    public static void main(String[] args) {

        Recursive_call_05 rc = new Recursive_call_05();
        int testInt = rc.Recursive_call(5);
        System.out.println(testInt);

        int factorialTestInt1 = rc.FactorialFunc1(5);
        System.out.println(factorialTestInt1);

        int factorialTestInt2 = rc.FactorialFunc2(5);
        System.out.println(factorialTestInt2);

        /**
         * 서브셋 리스트 테스트
         */
        ArrayList<Integer> sublist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sublist.add(i);
        }
        System.out.println(sublist);
        System.out.println(sublist.subList(1,sublist.size()));

        int factorialTestInt3 = rc.factorialTest2(sublist);
        System.out.println(factorialTestInt3);

        int factorialTestInt4 = rc.factorialTest3(5);
        System.out.println(factorialTestInt4);
    }
}
