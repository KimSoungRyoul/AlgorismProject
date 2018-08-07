package AlgoStudyGroup.dataStructure;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class 자료구조_연습 {

  public static void main(String[] args) {

    Set<Integer> tree;

    Integer[] data = new Integer[]{1, 35, 4, 63, 43, 52, 23, 6, 34, 63, 86};

    tree = new TreeSet<>(Arrays.asList(data));

    //Arrays.sort(data);

    System.out.println(Arrays.toString(tree.toArray()));
  }
}
