package AlgoStudyGroup.kakao_qualifying;

import java.util.Arrays;
import java.util.Comparator;

public class 캠핑 {

  public static void main(String[] args) {

    캠핑 ex = new 캠핑();

    // int[][] data = new int[][] {{0, 0}, {0, 2}, {1, 1}, {2, 0}};

    int[][] data = new int[][]{{0, 0}, {2, 1}, {0, 3}, {3, 3}, {4, 0}};

    System.out.println(ex.solution(5, data));
  }

  public int solution(int n, int[][] data) {
    int answer = 0;

    Arrays.sort(
        data,
        new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            if (((Comparable) o1[0]).compareTo(o2[0]) > 0) {
              return 1;
            } else if (((Comparable) o1[0]).compareTo(o2[0]) == 0) {
              if (((Comparable) o1[1]).compareTo(o2[1]) > 0) {
                return 1;
              } else {
                return -1;
              }
            } else {
              return -1;
            }
          }
        });

    int[][] checkData = new int[n][n];

    for (int i = 0; i < n; i++) {
      int[] pair1 = data[i];
      for (int j = i; j < n; j++) {
        int[] pair2 = data[j];
        if (pair1[0] != pair2[0] && pair1[1] != pair2[1]) {

          boolean checkbit = true;

          // pair1과 pair2사이 말뚝이 있으면 1 모르면 0 없으면 -1

          // 말뚝이 없으면
          if (checkData[i][j] == -1) {
            answer++;
            checkbit = true;
          } else if (checkData[i][j] == 0) {
            // 모르면 검사 실시

            for (int k = 0; k < n; k++) {
              int[] pair3 = data[k];
              int colMin = Math.min(pair1[0], pair2[0]);
              int colMax = Math.max(pair1[0], pair2[0]);
              int rowMin = Math.min(pair1[1], pair2[1]);
              int rowMax = Math.max(pair1[1], pair2[1]);

              if (((colMin < pair3[0] && pair3[0] < colMax)
                  && (rowMin < pair3[1] && pair3[1] < rowMax))) {
                checkbit = false;
                checkData[i][j] = 1;

                /*for(int r=j;r<n;r++){
                  if(data[][])
                }*/

                break;
              } else {
                checkbit = true;
                checkData[i][j] = -1;
              }
            }
            if (checkbit) {
              answer++;
            }
          } else if (checkData[i][j] == 1) {
            // 말뚝있으면 바로 for문 탈출
            break;
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
