package AlgoStudyGroup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RGB거리_dp {

  static int[][] rgbCost;


  public static int[] calculateMinCost(int a_1, int b, int bannedColor) {

    int check = -1;
    int result = Integer.MAX_VALUE;
    for (int k = 0; k < 3; k++) {
      for (int l = 0; l < 3; l++) {
        if (k != l && k != bannedColor) {

          if (result > rgbCost[a_1][k] + rgbCost[b][l]) {
            result = rgbCost[a_1][k] + rgbCost[b][l];
            check = l;
          }


        }
      }
    }

    return new int[]{result, check};
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    rgbCost = new int[n][3];

    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        rgbCost[i][j] = Integer.parseInt(str[j]);
      }
    }

    int[] minCostDp = new int[n];

    minCostDp[0] = Integer.MAX_VALUE;
    for (int i = 0; i < 3; i++) {
      minCostDp[0] = Math.min(minCostDp[0], rgbCost[0][i]);
    }
    if (n == 1) {
      bw.write(String.valueOf(minCostDp[0]));
      bw.flush();
      bw.close();
      br.close();
      return;
    }

    int[] bannedColor = new int[n];
    //-1 = 금지된컬러 없음
    int[] arr = calculateMinCost(0, 1, -1);
    minCostDp[1] = arr[0];
    bannedColor[1] = arr[1];
    if (n == 2) {
      bw.write(String.valueOf(minCostDp[1]));
      bw.flush();
      bw.close();
      br.close();
      return;
    }

    if (n > 2) {
      arr = calculateMinCost(1, 2, bannedColor[0]);
      minCostDp[2] = minCostDp[0] + arr[0];
      bannedColor[2] = arr[1];
    }
    int answer = Integer.MAX_VALUE;
    for (int i = 2; i < n; i++) {
      arr = calculateMinCost(i - 1, i, bannedColor[i - 2]);
      answer = minCostDp[i - 2] + arr[0];
      bannedColor[i] = arr[1];
      minCostDp[i] = answer;
    }

    bw.write(String.valueOf(answer));

    bw.flush();
    bw.close();
    br.close();
  }
}
