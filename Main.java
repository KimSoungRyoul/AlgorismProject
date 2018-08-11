package AlgoStudyGroup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  /*
  피사노 주기
  주기의 길이가 P 이면, N번째 피보나치 수를 M으로 나눈 나머지는 N%P번째 피보나치 수를 M을 나눈 나머지와 같습니다.
M = 10k 일 때, k > 2 라면, 주기는 항상 15 × 10k-1 입니다. 이 사실을 모른다고 해도, 주기를 구하는 코드를 이용해서 문제를 풀 수 있습니다.

  */
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int num = Integer.parseInt(br.readLine());
    if (num == 0 || num == 1) {
      bw.write("1");
      bw.flush();
      bw.close();
      br.close();
      return;
    } else if (num == 2) {
      bw.write("2");
      bw.flush();
      bw.close();
      br.close();
      return;
    }

    int[] dp = new int[num + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= num; i++) {

      dp[i] = dp[i - 1] + dp[i - 2];
      dp[i] %= 10007;
    }

    bw.write(String.valueOf(dp[num]));

    bw.flush();
    bw.close();
    br.close();
  }
}
