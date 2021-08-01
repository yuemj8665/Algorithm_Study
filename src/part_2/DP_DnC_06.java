package part_2;

public class DP_DnC_06 {
    /**
     * 피보나치 수열: n값을 입력 받아 다음과 같이 계산 됨
     * n을 입력 받았을 때 피보나치 수열로 결과값을 출력하기
     * Fn = 0, if n=0;
     * Fn = 1, if n=1;
     * Fn = F(n-1) + F(n-2), if n>1;
     *
     * 우선 재귀함수를 이용하여 해결해보자.
     */
    public int fibonacciRecursive_call(int n) {
        if (n <= 1) {
            return n; // 피보나치 수열은 1 이하는 본인 값을 가지므로 입력 받은 값을 리턴한다.
        }  else { // 그 외에는 규칙에 맞게 재귀함수 호출을 이용하여 리턴한다.
            return fibonacciRecursive_call(n-1)+fibonacciRecursive_call(n-2);
        }
    }

    /**
     * 동적계획법을 이용한 피보나치 수열 이해하기
     *
     * 피보나치 수열: n값을 입력 받아 다음과 같이 계산 됨
     * n을 입력 받았을 때 피보나치 수열로 결과값을 출력하기
     * Fn = 0, if n=0;
     * Fn = 1, if n=1;
     * Fn = F(n-1) + F(n-2), if n>1;
     *
     * @param n
     * @return
     */
    public int dynamicFunc(int n) {
        Integer[] cache = new Integer[n+1];
        cache[0] = 0;
        cache[1] = 1;
        for (int index = 2; index < n + 1; index++) {
            // 이전에 사용했던 값을 입력 한 후 재활용 하여다시 사용한다 (Memoiztion)
            cache[index] = cache[index - 1] + cache[index - 2];
        }
        return cache[n];
    }



    public static void main(String[] args) {
        DP_DnC_06 test = new DP_DnC_06();
        int fibonacciTest;
        fibonacciTest = test.fibonacciRecursive_call(9);
        System.out.println(fibonacciTest);

        int dynamicTest;
        dynamicTest = test.dynamicFunc(9);
        System.out.println(dynamicTest);

    }
}
