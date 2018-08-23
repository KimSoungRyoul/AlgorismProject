package AlgoStudyGroup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class One으로만들기_dp {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int[] cache;

    cache = new int[n + 1];
    if (n < 4 && n != 1) {
      bw.write("1");
      bw.flush();
      bw.close();
      br.close();
      return;
    } else if (n == 1) {
      bw.write("0");
      bw.flush();
      bw.close();
      br.close();
      return;
    } else {
      cache[1] = 1;
      cache[2] = 1;
      cache[3] = 1;
    }

    for (int i = 4; i <= n; i++) {
      int result = Integer.MAX_VALUE;
      if (i % 3 == 0) {
        result = Math.min(result, cache[i / 3] + 1);
      }
      if (i % 2 == 0) {
        result = Math.min(result, cache[i / 2] + 1);
      }
      if (i - 1 > 0) {
        result = Math.min(result, cache[i] = cache[i - 1] + 1);
      }
      cache[i] = result;
    }

    bw.write(String.valueOf(cache[n]));

    bw.flush();
    bw.close();
    br.close();
  }
}
