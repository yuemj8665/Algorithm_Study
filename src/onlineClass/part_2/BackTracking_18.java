package onlineClass.part_2;

import java.util.ArrayList;

public class BackTracking_18 {
    public static class NQueen {

        /**
         *
         * @param n : 몇개의 Queen을 놓을 것인가
         * @param currentRow : 시작 row
         * @param currentCandidate : {#,#}
         */
        public void dfsFunc(Integer n, Integer currentRow, ArrayList<Integer> currentCandidate) {
            // 마무리가 되면 출력하는 코드
            if (currentRow == n) {
                System.out.println(currentCandidate);
                return ;
            }

            for (int i = 0; i < n; i++) {
                // 회전을 시킬 수 있는지 없는지를 판단한다.
                if(this.isAvailable(currentCandidate,i) == true){
                    currentCandidate.add(i);
                    // 재귀용법을 활용하여 다음 줄로 이동하여 다시 출력한다.
                    this.dfsFunc(n,currentRow+1,currentCandidate);
                    currentCandidate.remove(currentCandidate.size() - 1);
                }

            }
        }

        public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) {
            // 회전 가능한지 현재 candidate의 크기를 결정
            Integer currentRow = candidate.size();
            for (int i = 0; i < currentRow; i++) {
                if ((candidate.get(i) == currentCol)
                        || (Math.abs(candidate.get(i) - currentCol) == currentRow - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.dfsFunc(4,0,new ArrayList<>());
    }
}
