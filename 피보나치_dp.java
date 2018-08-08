package AlgoStudyGroup;

import java.util.Arrays;
import java.util.Scanner;

public class 피보나치_dp {

  public static String fibo(int n) {

    int[][] dp = new int[2][n + 1];

    Arrays.fill(dp[0], -1);
    Arrays.fill(dp[1], -1);

    if (n == 0) {
      return "1 0";
    } else if (n == 1) {
      return "0 1";
    }
    dp[0][0] = 1;
    dp[0][1] = 0;

    dp[1][0] = 0;
    dp[1][1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[0][i] = dp[0][i - 1] + dp[0][i - 2];
      dp[1][i] = dp[1][i - 1] + dp[1][i - 2];
    }

    return dp[0][n] + " " + dp[1][n];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {

      System.out.println(fibo(sc.nextInt()));
    }
  }
}
