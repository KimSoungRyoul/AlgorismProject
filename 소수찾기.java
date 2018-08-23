package AlgoStudyGroup;

import java.util.Scanner;

public class 소수찾기 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int result = 0;

    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      boolean isPrime = true;
      if (num == 1) {
        isPrime = false;
      }
      if (num == 0) {
        isPrime = false;
      }

      for (int j = 2; j < num; j++) {
        if (num % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (num == 2) {
        isPrime = true;
      }

      if (isPrime) {
        result++;
      }
    }

    System.out.println(result);

    sc.close();

    return;
  }
}
