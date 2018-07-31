package 알고리즘스터디.카카오예선문제.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import 알고리즘스터디.카카오예선문제.카카오프랜즈컬러링북;

public class 컬러링북테스트 {


  카카오프랜즈컬러링북 ex1 = new 카카오프랜즈컬러링북();


  @Test
  public void test1() {

    int[][] picture = new int[100][100];

    picture[99][99] = 1;
    picture[99][98] = 1;
    picture[99][97] = 1;
    picture[98][99] = 1;

    picture[0][99] = 3;
    picture[0][98] = 3;
    picture[0][99] = 4;

    int[] result = ex1.solution(100, 100, picture);

    //공간 갯수 3
    assertEquals(result[0], 3);
    //최대공간크기 4
    assertEquals(result[1], 4);
  }

  @Test
  public void test6() {

    int[][] picture = new int[100][100];

    picture[99][99] = 3;

    picture[98][98] = 0;
    picture[99][98] = 1;
    picture[99][97] = 1;

    picture[98][99] = 1;

    picture[0][99] = 3;
    picture[0][98] = 3;

    picture[0][99] = 4;

    picture[99][0] = 3;
    picture[99][1] = 3;
    picture[98][1] = 3;

    picture[99][3] = 4;

    int[] result = ex1.solution(100, 100, picture);

    //공간 갯수 3
    assertEquals(result[0], 7);
    //최대공간크기 4
    assertEquals(result[1], 3);
  }


  @Test
  public void test2() {

    int[][] picture = {
        {0, 1, 1, 0},
        {1, 1, 1, 1},
        {1, 2, 1, 1},
        {2, 1, 2, 1},
        {3, 0, 2, 3},
        {0, 3, 3, 0},
    };

    int[] result = ex1.solution(6, 4, picture);

    //공간 갯수 3
    assertEquals(result[0], 8);
    //최대공간크기 4
    assertEquals(result[1], 10);
  }


  @Test
  public void test3() {

    int[][] picture = {
        {1, 1, 1, 0, 0, 0, 1, 0, 0, 0},
        {1, 2, 2, 0, 0, 0, 1, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 1, 0, 0},
        {1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
        {0, 3, 5, 1, 0, 0, 0, 0, 0, 0},
        {3, 0, 0, 3, 3, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
        {7, 7, 7, 0, 0, 1, 1, 1, 0, 0},
        {7, 1, 7, 0, 0, 0, 1, 0, 1, 1},
        {7, 7, 7, 0, 0, 0, 1, 1, 1, 0},
    };

    int[] result = ex1.solution(10, 10, picture);

    //공간 갯수 3
    assertEquals(result[0], 13);
    //최대공간크기 4
    assertEquals(result[1], 10);
  }


  @Test
  public void test4() {

    int[][] picture = {
        {0, 1},
        {1, 0}
    };

    int[] result = ex1.solution(2, 2, picture);

    //공간 갯수 2
    assertEquals(result[0], 2);
    //최대공간크기 1
    assertEquals(result[1], 1);
  }

  @Test
  public void test5() {

    int[][] picture = {
        {1}
    };

    int[] result = ex1.solution(1, 1, picture);

    //공간 갯수 2
    assertEquals(result[0], 1);
    //최대공간크기 1
    assertEquals(result[1], 1);
  }


}
