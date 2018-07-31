package 알고리즘스터디;


public class Solution {

  public int solution(int n) {

    int MAX_LENGTH = 60_000;

    int dp[] = new int[MAX_LENGTH];

    dp[0] = 1;
    dp[1] = 2;

    for (int i = 2; i < n; i++) {

      dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007;

    }

    return dp[n - 1];
  }
}