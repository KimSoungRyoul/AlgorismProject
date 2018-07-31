package 알고리즘스터디.카카오예선문제;

import java.util.Arrays;

public class 카카오프랜즈컬러링북 {

  /*
  1. 0이 아닌 영역을 찾는다
  2.


  */

  boolean[][] checkPicture = new boolean[101][101];

  public static void main(String[] args) {

    카카오프랜즈컬러링북 ex = new 카카오프랜즈컬러링북();

    int[][] picture = new int[100][100];

    picture[99][99] = 3;

    picture[98][98] = 0;
    picture[99][98] = 1;
    picture[99][97] = 1;

    picture[98][99] = 1;

    picture[0][99] = 3;
    picture[0][98] = 3;

    picture[0][99] = 4;

    picture[99][0] = 3;
    picture[99][1] = 3;

    picture[99][3] = 4;

    int[] result = ex.solution(100, 100, picture);

    System.out.println(result[0] + " " + result[1]);
  }

  public int[] solution(int column, int row, int[][] picture) {
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;

    for (int i = 0; i < column + 1; i++) {
      Arrays.fill(this.checkPicture[i], false);
    }

    for (int col = 0; col < column; col++) {
      for (int ro = 0; ro < row; ro++) {
        if (this.checkPicture[col][ro] == false) {

          if (col == 98 && ro == 98) {
            System.out.println("---");
          }

          if (picture[col][ro] != 0) {
            numberOfArea++;
            int areaSize = 0;
            if ((areaSize = areaCheck(++areaSize, col, ro, picture, column, row)) > 0) {
              maxSizeOfOneArea = Math.max(areaSize, maxSizeOfOneArea);
            }
          }
        }
      }
    }

    int[] answer = new int[2];
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;
    return answer;
  }

  public int areaCheck(int areaSize, int col, int ro, int[][] picture, int maxCol, int maxRow) {

    this.checkPicture[col][ro] = true;

    if (col > 0) {
      if (picture[col][ro] == picture[col - 1][ro] && this.checkPicture[col - 1][ro] == false) {

        areaSize = areaCheck(++areaSize, col - 1, ro, picture, maxCol, maxRow);
      }
    }

    if (col < maxCol - 1) {
      // System.out.println("colNum: "+col);
      if (picture[col][ro] == picture[col + 1][ro] && this.checkPicture[col + 1][ro] == false) {

        areaSize = areaCheck(++areaSize, col + 1, ro, picture, maxCol, maxRow);
      }
    }

    if (ro > 0) {
      if (picture[col][ro] == picture[col][ro - 1] && this.checkPicture[col][ro - 1] == false) {

        areaSize = areaCheck(++areaSize, col, ro - 1, picture, maxCol, maxRow);
      }
    }

    if (ro < maxRow - 1) {
      if (picture[col][ro] == picture[col][ro + 1] && this.checkPicture[col][ro + 1] == false) {

        areaSize = areaCheck(++areaSize, col, ro + 1, picture, maxCol, maxRow);
      }
    }

    return areaSize;
  }
}
