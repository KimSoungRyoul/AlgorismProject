package AlgoStudyGroup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 더하기1_2_3 {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      int[] dp = new int[num + 1];
      if (num < 3) {
        dp = new int[4];
      }

      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 4;
      for (int j = 4; j <= num; j++) {
        if (j > 1) {
          dp[j] += dp[j - 1];
        }
        if (j > 2) {
          dp[j] += dp[j - 2];
        }
        if (j > 3) {
          dp[j] += dp[j - 3];
        }
      }
      bw.write(String.valueOf(dp[num] + "\n"));
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
