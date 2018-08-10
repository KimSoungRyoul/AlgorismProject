package AlgoStudyGroup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 아스키코드활용문제 {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] alphabetArr = new int[128];

    Arrays.fill(alphabetArr, -1);

    String charArr = br.readLine();

    for (int i = 0; i < charArr.length(); i++) {
      if (alphabetArr[(int) charArr.charAt(i)] == -1) {
        alphabetArr[(int) charArr.charAt(i)] = i;
      }

    }
    for (int i = 97; i <= 122; i++) {
      bw.write(String.valueOf(alphabetArr[i] + " "));
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
