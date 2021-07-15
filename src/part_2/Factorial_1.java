package part_2;

public class Factorial_1 {
    /**
     * 공간복잡도
     * n에 따라서 함수 전체의 크기는 변경되지않는다.
     * 그래서 공간 복잡도는 O(1)
     * > 공간 복잡도 계산은 실제 알고리즘 실행 시 사용되는 저장 공간을 계산하면 됨
     * @param n
     * @return
     */
    public int FactorialFunc1(int n) {
        int fac = 1;
        for (int index = 2; index < n; index++) {
            fac = fac * index;
        }
        return fac;
    }

    /**
     * 재귀함수를 이용하였으므로 n에 따라 변수 n이 n개 만들어지게 된다.
     * factorial 함수를 재귀함수로 1까지 호출하였을 경우 n부터 1까지 스택이 쌓이게 된다.
     * 공간 복잡도는 O(n)
     * @param n
     * @return
     */
    public int FactorialFunc2(int n){
        if (n > 1) {
            return n * FactorialFunc2(n - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Factorial_1 f = new Factorial_1();

        System.out.println(f.FactorialFunc1(5));


    }
}
