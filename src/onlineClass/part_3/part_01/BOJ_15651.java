package onlineClass.part_3.part_01;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15651 {
    /**
     * //
     * <p>
     * N개 중에서 중복을 혀용해서 M개를 순서있게 나열한다.
     * BOJ 15651 - N과 M (3)
     * 난이도 2
     * https://www.acmicpc.net/problem/15651
     * <p>
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * - 1부터 N까지 자연수 중에서 M개를 고른 수열
     * - 같은 수를 여러 번 골라도 된다.
     * <p>
     * 입력
     * - 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
     * 출력
     * - 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
     * - 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     * - 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     * <p>
     * 시간복잡도, 공간복잡도 파악하기
     * N = 4, M = 3
     * 4*4*4 = 4^3 = 64
     * 시간 : O(N^M) = 7^7 = 82만
     */
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static void input() {
        FastReader fastReader = new FastReader();
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        selected = new int[M+1];
    }

    static int N,M;
    static int[] selected;
    // Recurrence Function(재귀함수)
    // 만약 M개를 전부 고르게 되었다 => 조건에 맞는 탐색을 한 가지 성공했다.
    // 아직 M개를 전부 고르지 못한 경우 => k번째부터 M번쨰 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    static void rec_func(int k) {
        if (k == M + 1) { // 모든 계산이 끝나 출력하는 경우
            // selected[1...M] 배열이 새롭게 탐색 된 결과
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
                sb.append('\n');
            }
        } else { //
            for (int candidate = 1; candidate <= N; candidate++) {
                selected[k] = candidate;
                // k+1번 ~ M번까지 모두 탐색해야 한다.
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }
}
