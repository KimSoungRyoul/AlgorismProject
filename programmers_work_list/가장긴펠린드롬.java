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

public class 가장긴펠린드롬 {

  public static void main(String[] args) {

    가장긴펠린드롬 ex = new 가장긴펠린드롬();
//3
    System.out.println(ex.solution("abacde"));
    //7
    System.out.println(ex.solution("abcdcba"));

    // 4
    System.out.println(ex.solution("cdedvabbav"));
//8
    System.out.println(ex.solution("udabbaduhdhdf"));
//1
    System.out.println(ex.solution("asdf"));
  }

  public int solution(String s) {

    int col = s.length();
    int row = s.length();

    int answer = 0;

    for (int a = 0; a < col + 1; a++) {

      for (int b = a + 1; b < row + 1; b++) {
        String subStr = s.substring(a, b);

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
        }
      }
    }

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    // System.out.println("Hello Java");

    return answer;
  }
}
