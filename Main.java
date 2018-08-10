package AlgoStudyGroup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int result = 0;
    for (int i = 0; i < n; i++) {
      Set<Integer> checker = new HashSet<>();

      char beforeCh = '/';
      String str = br.readLine();
      int strLength = str.length();
      boolean isGroupWord = false;
      for (int j = 0; j < strLength; j++) {

        if (checker.contains((int) str.charAt(j)) && beforeCh != str.charAt(j)) {
          isGroupWord = false;
          break;
        } else if ((beforeCh == str.charAt(j)) && checker.contains((int) str.charAt(j)) || !checker
            .contains((int) str.charAt(j))) {
          isGroupWord = true;
        }
        checker.add((int) str.charAt(j));
        beforeCh = str.charAt(j);

      }
      if (isGroupWord) {
        result++;
      }


    }

    bw.write(String.valueOf(result));

    bw.flush();
    bw.close();
    br.close();
  }
}
