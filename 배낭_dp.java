package AlgoStudyGroup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 배낭_dp {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int n = Integer.valueOf(input[0]);
    int k = Integer.valueOf(input[1]);

    int[] value = new int[n + 1];
    int[] weight = new int[n + 1];

    for (int i = 1; i < n + 1; i++) {
      String[] str = br.readLine().split(" ");
      weight[i] = Integer.parseInt(str[0]);
      value[i] = Integer.parseInt(str[1]);
    }

    // n개의 물건을 무게 k만큼 담았을때 value 값을 저장
    int[][] answer = new int[n + 1][k + 1];

    for (int i = 1; i <= n; i++) {

      for (int j = 1; j <= k; j++) {
        if (j - weight[i] < 0) {
          answer[i][j] = Math.max(answer[i - 1][j], answer[i][j - 1]);
        } else {
          answer[i][j] = Math.max(answer[i - 1][j - weight[i]] + value[i], answer[i - 1][j]);
        }
      }
    }
    bw.write(String.valueOf(answer[n][k]));

    bw.flush();
    bw.close();
    br.close();
  }
}
