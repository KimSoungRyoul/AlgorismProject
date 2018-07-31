package AlgoStudyGroup.kakao_qualifying;

public class 보행자천국 {

  static final int ZERO_FREE = 0;
  static final int ONE_NOT_ALLOWED = 1;
  static final int TWO_ONLY_STRAIGHT = 2;
  int MOD = 20170805;

  // col,ro에 갈수있는 경로Cnt 를 모아두는 배열
  int[][] dpArr_right = new int[501][501];
  int[][] dpArr_down = new int[501][501];

  public static void main(String[] args) {

    int[][] cityMap =
        new int[][]{
            {0, 2, 0, 0, 0, 2},
            {0, 0, 2, 0, 1, 0},
            {1, 0, 0, 2, 2, 0}
        };

   /* int[][] cityMap =
        new int[][] {
          {0, 0, 0},
          {0, 0, 0},
          {0, 0, 0}
        };
*/
    보행자천국 ex = new 보행자천국();

    System.out.println(ex.solution(3, 6, cityMap));
  }

  public int solution(int m, int n, int[][] cityMap) {
    int answer = 0;
    dpArr_right[1][1] = 1;
    dpArr_down[1][1] = 1;

    for (int col = 1; col <= m; col++) {

      for (int ro = 1; ro <= n; ro++) {

        if (cityMap[col - 1][ro - 1] == ZERO_FREE) {

          dpArr_right[col][ro] =
              (dpArr_right[col][ro] + dpArr_right[col][ro - 1] + dpArr_down[col - 1][ro]) % MOD;

          dpArr_down[col][ro] =
              (dpArr_down[col][ro] + dpArr_right[col][ro - 1] + dpArr_down[col - 1][ro]) % MOD;

          // System.out.println(dpArr_right[col][ro] + ", " + dpArr_down[col][ro]);
        } else if (cityMap[col - 1][ro - 1] == TWO_ONLY_STRAIGHT) {

          dpArr_down[col][ro] = dpArr_down[col - 1][ro] % MOD;
          dpArr_right[col][ro] = dpArr_right[col][ro - 1] % MOD;

          // System.out.println(dpArr_right[col][ro] + ", " + dpArr_down[col][ro]);
        } else {

          dpArr_right[col][ro] = 0;
          dpArr_down[col][ro] = 0;

          //  System.out.println(dpArr_right[col][ro] + ", " + dpArr_down[col][ro]);
        }
      }
    }

    answer = dpArr_down[m][n];

    return answer;
  }
}
