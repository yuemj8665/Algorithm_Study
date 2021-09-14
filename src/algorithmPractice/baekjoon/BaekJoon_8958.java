package algorithmPractice.baekjoon;

import java.util.Scanner;

public class BaekJoon_8958 {
    /**
     * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
     * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
     * "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
     * OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
     */

    /**
     * 입력
     * 첫째 줄에 테스트 케이스의 개수가 주어진다.
     * 각 테스트 케이스는 한 줄로 이루어져 있고,
     * 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.
     */

    /**
     * 출력
     * 각 테스트 케이스마다 점수를 출력한다.
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String[] oxoxox = new String[number];
        for (int i = 0; i < number; i++) {
            oxoxox[i] = sc.next();
        }
        // 여기까지 오면 입력은 받았다.

        for (int i = 0; i < oxoxox.length; i++) { // oxoxox의 갯수만큼 회전
            int total = 0;
            int sum = 0;
            for (int k = 0; k < oxoxox[i].length(); k++) { // oxoxox의 인덱스 안에 있는 String값을 쪼개어 순환한다.
                if (String.valueOf(oxoxox[i].charAt(k)).equals("O")) { // O 체크
                    sum++; // O라면, 점수1점 추가
                    total += sum; // 추가 한 점수를 total에 모은다.
                } else { // X인 경우
                    sum = 0; // 점수를 0으로 초기화한다
                }
            }
            System.out.println(total); // 마지막으로 total을 찍어준다.
        }
    }
}
