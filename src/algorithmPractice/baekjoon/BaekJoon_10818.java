package algorithmPractice.baekjoon;

import java.util.Scanner;

public class BaekJoon_10818 {
    /**
     * N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
     * 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
     * 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
     * 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
     *
     * 예제 입력1
     * 5
     * 20 10 35 30 7
     *
     * 예제 출력1
     * 7 35
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 첫째 줄 ( 정수의 갯수 )
        int a = scanner.nextInt();
        // 두번째 줄 ( 배열 )
        int[] arrayInt = new int[a];
        for (int i = 0; i < a; i++) {
            arrayInt[i] = Integer.parseInt(scanner.next());
        }
        // 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
        // 여기까지 오면 입력은 받는다
        // 이제 최소최대를 구해보자.

        int min = 1000000;
        int max = -1000000;

        for (int number : arrayInt) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        System.out.println(min +" "+ max);


    }
}
