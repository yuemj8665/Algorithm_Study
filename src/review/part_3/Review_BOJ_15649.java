package review.part_3;

import java.util.Scanner;

public class Review_BOJ_15649 {
    /**
     * N개를 중복없이 M개를 순서있게 나열하기
     * https://www.acmicpc.net/problem/15649
     * <p>
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
     * <p>
     * 입력
     * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     * <p>
     * 출력
     * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
     * 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     */

    // 변수 선언
    static Scanner sc = new Scanner(System.in);
    static StringBuffer buffer = new StringBuffer();

    static int n;
    static int m;
    static int[] selected;
    static int[] used;

    static void inputParam() {
        n = sc.nextInt();
        m = sc.nextInt();
        selected = new int[m + 1];

    }

    static void rec_func(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) {
                buffer.append(selected[i]).append(' ');
            }
            buffer.append('\n');
        } else {
            for (int c = 1; c <= n; c++) {
                boolean isUsed = false;
                for(int i=1;i<=k;i++){
                    if (c == selected[i]) {
                        isUsed = true;
                    }
                }
                if (!isUsed) {
                    selected[k] = c;
                    rec_func(k + 1);
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        inputParam();
        rec_func(1);
        System.out.println(buffer.toString());
    }
}
