package AlgoStudyGroup.programmers_work_list;
/*

문제 설명
앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.

예를들면, 문자열 s가 abcdcba이면 7을 return하고 abacde이면 3을 return합니다.

제한사항
문자열 s의 길이 : 2500 이하의 자연수
문자열 s는 알파벳 소문자로만 구성



*/

public class 가장긴펠린드롬_dp {

  public static void main(String[] args) {

    가장긴펠린드롬_dp ex = new 가장긴펠린드롬_dp();

    // 3 을 리턴해야됨
    System.out.println(ex.solution("abacde"));
    System.out.println(ex.solution("abcdcba"));

    // 4
    System.out.println(ex.solution("cdedvabbav"));

    System.out.println(ex.solution("udabbaduhdhdf"));

    System.out.println(ex.solution("asdf"));

    System.out.println(ex.solution("efqqfehijaaaaa"));
  }

  public int solution(String s) {

    int col = s.length();
    int row = col;

    int answer = 1;

    // i 부터 j 까지 펠린드 룸인가? 아니면 -1  맞으면 1
    boolean[][] dpArr = new boolean[col + 1][row + 1];

    // 구간길이 2 와 3일때를 팰룸여부를 미리 조사
    for (int a = 2; a < 5; a++) {
      for (int strIdx = 0; strIdx <= s.length() - a; strIdx++) {

        String subStr = s.substring(strIdx, strIdx + a);
        boolean isPalRoom = false;

        for (int c = 0; c < subStr.length(); c++) {
          if (subStr.charAt(c) != subStr.charAt(subStr.length() - c - 1)) {
            isPalRoom = false;
            break;

          } else {
            isPalRoom = true;
          }
        }
        if (isPalRoom) {
          answer = Math.max(answer, subStr.length());
          dpArr[strIdx][strIdx + a - 1] = true;
        }
      }
    }

    // 구간의 길이가 3~a인경우 dpArr활용
    for (int a = 3; a < col; a++) {

      if (a % 2 != 0) {
        for (int i = 0; i <= col - a + 1; i++) {

          if (dpArr[i][i + a - 1] && (i - 1) >= 0 && (i + a) < col) {
            // i-1 ,j+1 이 배열 범위 안벗어나면?
            // 양옆의 char을 검사해서 dpArr에 검사값 저장
            if (s.charAt(i - 1) == s.charAt(i + a)) {
              dpArr[i - 1][i + a] = true;
              answer = Math.max(answer, a + 2);
            }
          }
        }
      } else {

        for (int i = 0; i < col - a + 1; i++) {

          if (dpArr[i][i + a - 1] && (i + a) < col && (i - 1) >= 0) {
            // i-1 ,j+1 이 배열 범위 안벗어나면?
            // 양옆의 char을 검사해서 dpArr에 검사값 저장
            if (s.charAt(i - 1) == s.charAt(i + a)) {
              dpArr[i - 1][i + a] = true;
              answer = Math.max(answer, a + 2);
            }
          }
        }
      }
    }

    return answer;
  }
}
