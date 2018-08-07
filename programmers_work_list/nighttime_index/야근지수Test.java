package AlgoStudyGroup.programmers_work_list.nighttime_index;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class 야근지수Test {

  야근지수 ex = new 야근지수();


  @Test
  public void test1() {

    int[] work = new int[]{4, 3, 3};

    assertEquals(12L, ex.solution(4, work));

  }

  @Test
  public void test2() {

    int[] work = new int[]{2, 1, 2};

    assertEquals(6L, ex.solution(1, work));

  }

  @Test
  public void test3() {

    int[] work = new int[]{1, 1};

    assertEquals(0L, ex.solution(3, work));

  }


}
