package AlgoStudyGroup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class 정수삼각형 {

  static int[][] arr;
  static int[][] dp;
  static int n;

  static int maxNum = 0;

  public static int addNumNexLine(int i, int j) {

    if (i == n - 1) {
      return arr[i][j];
    }

    if (dp[i][j] != -1) {
      dp[i + 1][j] = Math.max(dp[i][j] + arr[i + 1][j], dp[i + 1][j]);
      dp[i + 1][j + 1] = Math.max(dp[i][j] + arr[i + 1][j + 1], dp[i + 1][j + 1]);
    } else {
      dp[i + 1][j] = arr[i][j] + addNumNexLine(i + 1, j);
      dp[i + 1][j + 1] = arr[i][j] + addNumNexLine(i + 1, j + 1);
    }

    maxNum = dp[i][j];

    return maxNum;
  }

  public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = sc.nextInt();

    arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    // for (int k = 0; k < n; k++) System.out.println(Arrays.toString(arr[k]) + "\n");

    dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    addNumNexLine(0, 0);

    bw.write(String.valueOf(maxNum));

    bw.flush();
    bw.close();
    sc.close();
  }
}
