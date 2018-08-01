package AlgoStudyGroup.kakao_qualifying;

public class 캠핑_bruteForce {


  public static void main(String[] args) {

    캠핑_bruteForce ex = new 캠핑_bruteForce();

    //int[][] data = new int[][] {{0, 0}, {0, 2}, {1, 1}, {2, 0}};

    int[][] data = new int[][]{{0, 0}, {0, 3}, {2, 1}, {3, 3}, {4, 0}};

    System.out.println(ex.solution(5, data));
  }

  public int solution(int n, int[][] data) {
    int answer = 0;

    for (int i = 0; i < n; i++) {
      int[] pair1 = data[i];
      for (int j = i; j < n; j++) {
        int[] pair2 = data[j];
        if (pair1[0] != pair2[0] && pair1[1] != pair2[1]) {
          answer++;
          boolean checkbit = true;
          for (int k = 0; k < n; k++) {
            int[] pair3 = data[k];
            int colMin = Math.min(pair1[0], pair2[0]);
            int colMax = Math.max(pair1[0], pair2[0]);
            int rowMin = Math.min(pair1[1], pair2[1]);
            int rowMax = Math.max(pair1[1], pair2[1]);

            if (
                ((colMin < pair3[0] && pair3[0] < colMax)
                    && (rowMin < pair3[1] && pair3[1] < rowMax))

                ) {
              answer--;
              checkbit = false;
              break;
            }
          }
          printLog(checkbit, pair1, pair2);

        }
      }
    }

    return answer;
  }

  private void printLog(boolean checkbit, int[] pair1, int[] pair2) {
    if (checkbit) {
      System.out.println(pair1[0] + ", " + pair1[1]);
      System.out.println(pair2[0] + ", " + pair2[1]);
      System.out.println("--------");
    }
  }
}
