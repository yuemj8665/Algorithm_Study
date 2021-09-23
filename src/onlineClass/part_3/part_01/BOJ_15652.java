package onlineClass.part_3.part_01;

import java.util.Scanner;

public class BOJ_15652 {
    /**
     * N개 중 중복을 허용하여 M개를 고르기
     * https://www.acmicpc.net/problem/15652
     *
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     *
     * 1부터 N까지 자연수 중에서 M개를 고른 수열
     * 같은 수를 여러 번 골라도 된다.
     * 고른 수열은 비내림차순이어야 한다.
     * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
     *
     * 입력
     * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     *
     * 출력
     * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
     * 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     */
    static Scanner sc = new Scanner(System.in);
    static StringBuffer sb = new StringBuffer();

    static int n, m;
    static int[] selected;

    static void inputParam() {
        n = sc.nextInt();
        m = sc.nextInt();
        selected = new int[m + 1];
    }

    static void rec_func(int k) {
        if (k == m + 1) { // m까지의 숫자를 전부 탐색 했을 때,
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else { // 아직 탐색이 덜 될 때
            int start = selected[k-1];
            if (start == 0) {
                start = 1;
            }
            for (int c = start; c <= n; c++) {
                selected[k] = c;
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        inputParam();
        rec_func(1);
        System.out.println(sb);

    }
}
