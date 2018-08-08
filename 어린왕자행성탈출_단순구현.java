package AlgoStudyGroup;

import java.util.Scanner;

public class 어린왕자행성탈출_단순구현 {

  public static int solution(int[] startLoc, int[] endLoc, int[][] planets) {

    int result = 0;

    //System.out.println(planets.length);
    for (int i = 0; i < planets.length; i++) {

      if ((planets[i][2] >= getDistance(startLoc, planets[i]))
          && (planets[i][2] >= getDistance(endLoc, planets[i]))) {

      } else if ((planets[i][2] >= getDistance(startLoc, planets[i]))
          || (planets[i][2] >= getDistance(endLoc, planets[i]))) {

        result++;
      }
    }

    return result;
  }

  public static double getDistance(int[] loc, int[] planet) {
    return Math.sqrt(Math.pow((loc[0] - planet[0]), 2) + Math.pow((loc[1] - planet[1]), 2));
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {

      int[] startLoc = new int[]{sc.nextInt(), sc.nextInt()};
      int[] endLoc = new int[]{sc.nextInt(), sc.nextInt()};

      int plantesCnt = sc.nextInt();
      int[][] planets = new int[plantesCnt][3];

      for (int ii = 0; ii < plantesCnt; ii++) {
        int[] planetLoc = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        planets[ii] = planetLoc;
      }

      /*System.out.println("--행성 정보 --");
      for(int k=0;k<plantesCnt;k++){

      System.out.println(Arrays.toString(planets[k]));*/

      System.out.println(solution(startLoc, endLoc, planets));
    }
  }
}
