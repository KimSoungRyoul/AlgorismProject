package AlgoStudyGroup.programmers_work_list.nighttime_index;

import java.util.Arrays;


public class 야근지수 {

  public long solution(int n, int[] works) {
    long answer = 0;

    int worksSize = works.length;

    // 배열 정렬
    Arrays.sort(works);

    while (n > 0) {
      if (works[worksSize - 1] == 0) {
        break;
      }

      works[worksSize - 1]--;
      n--;

      Arrays.sort(works);
    }

    for (int i = 0; i < worksSize; i++) {
      answer += works[i] * works[i];
    }

    return answer;
  }
}
