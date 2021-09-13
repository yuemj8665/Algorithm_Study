package algorithmPractice.baekjoon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BaekJoon_3052 {
    /**
     * 두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다.
     * 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
     */

    /**입력
     * 첫째 줄부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다. 이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.
     */

    /**
     * 출력
     * 첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.
     */

    public static class Solution_01 {
        public void solution_01 () { // 실패
            Scanner sc = new Scanner(System.in);
            int number[] = new int[10];
            int b[] = new int[10];
            for (int i = 0; i < number.length; i++) {
                number[i] = sc.nextInt();

            }

            for (int i = 0; i < b.length; i++) {
                b[i] = number[i] % 42;
            }

            Arrays.sort(b);
            System.out.println(b.length);
        }

        public void solution_02 () {
            Scanner sc = new Scanner(System.in);
            int number[] = new int[10];
            int b[] = new int[10];
            for (int i = 0; i < number.length; i++) {
                number[i] = sc.nextInt();

            }
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0; i < b.length; i++) {
                b[i] = number[i] % 42;
                hashSet.add(b[i]);
            }
            System.out.println(hashSet.size());
        }
    }

    public static void main(String[] args) {
        Solution_01 solution_01 = new Solution_01();
        // solution_01.solution_01();
        solution_01.solution_02();

    }
}
