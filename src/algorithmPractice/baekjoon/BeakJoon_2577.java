package algorithmPractice.baekjoon;

import java.util.Scanner;

public class BeakJoon_2577 {
    /**
     * 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
     * 예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다
     */

    // 입력
    // 첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 크거나 같고, 1,000보다 작은 자연수이다.

    // 출력
    // 첫째 줄에는 A × B × C의 결과에 0 이 몇 번 쓰였는지 출력한다.
    // 마찬가지로 둘째 줄부터 열 번째 줄까지 A × B × C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int number0 = 0;
        int number1 = 0;
        int number2 = 0;
        int number3 = 0;
        int number4 = 0;
        int number5 = 0;
        int number6 = 0;
        int number7 = 0;
        int number8 = 0;
        int number9 = 0;

        String result = String.valueOf(a * b * c);

        for (int i = 0; i < result.length(); i++) {
            switch (Integer.parseInt(String.valueOf(result.charAt(i)))) {
                case 0: number0++; break;
                case 1: number1++; break;
                case 2: number2++; break;
                case 3: number3++; break;
                case 4: number4++; break;
                case 5: number5++; break;
                case 6: number6++; break;
                case 7: number7++; break;
                case 8: number8++; break;
                case 9: number9++; break;
            }
        }
        System.out.println(number0);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);
        System.out.println(number4);
        System.out.println(number5);
        System.out.println(number6);
        System.out.println(number7);
        System.out.println(number8);
        System.out.println(number9);
    }
}
