package AlgoStudyGroup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class 기본포맷 {

  public static String soluntion(String input) {

    return null;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {

      String[] strArr = br.readLine().split(" ");
      int size = Integer.parseInt(strArr[0]);
      double avg = 0;
      for (int j = 1; j < size + 1; j++) {
        avg += Double.parseDouble(strArr[j]);
      }
      avg /= size;

      double persent = 0.000;
      if (size == 1) {
        persent = 0.000;
      } else {
        for (int k = 1; k <= size; k++) {
          if (Double.parseDouble(strArr[k]) > avg) {
            persent++;
          }
        }
      }

      //double result = Double.parseDouble(String.format("%.3f", (double)(persent / size * 100)));
      double result = Math.round(persent * 100) / 100.0 / size * 100;

      DecimalFormat df = new DecimalFormat("##########0.0");
      if (df.format(result).equals(".000")) {
        bw.write("0.000%");
        if (!(n - 1 == i)) {
          bw.newLine();
        }
      } else {
        bw.write(df.format(result) + "%");
        if (!(n - 1 == i)) {
          bw.newLine();
        }
      }

    }

    bw.flush();
    bw.close();
    br.close();
  }
}
