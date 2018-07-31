package AlgoStudyGroup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*

https://www.acmicpc.net/problem/13460


스타트링크에서 판매하는 어린이용 장남감 중에서 가장 인기가 많은 제품은 구슬 탈출이다.
구슬 탈출은 직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는 게임이다.
보드의 세로 크기는 N, 가로 크기는 M이고, 편의상 1×1크기의 칸으로 나누어져 있다. 가장 바깥 행과 열은 모두 막혀져 있고,

보드에는 구멍이 하나 있다. 빨간 구슬과 파란 구슬의 크기는 보드에서 1×1크기의 칸을 가득 채우는 사이즈이고, 각각 하나씩 들어가 있다.
게임의 목표는 빨간 구슬을 구멍을 통해서 빼내는 것이다. 이 때, 파란 구슬이 구멍에 들어가면 안된다.
이 때, 구슬을 손으로 건드릴 수는 없고, 중력을 이용해서 이리 저리 굴려야 한다.
왼쪽으로 기울이기,
오른쪽으로 기울이기,
위쪽으로 기울이기,
아래쪽으로 기울이기
와 같은 네 가지 동작이 가능하다.

각각의 동작에서 공은 동시에 움직인다.

빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다.

빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다.
빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다.
또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다.
기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.

보드의 상태가 주어졌을 때, 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램을 작성하시오.
*/

/*
input

7 7
#######
#...RB#
#.#####
#.....#
#####.#
#O....#
#######

output

5


*/

public class 삼성구슬탈출문제 {

  static Map<String, Node> nodeMap = new HashMap<>();

  static String blueLocation = "";
  static String redLocation = "";

  static String holeLocation = "";

  static Node failNode = new Node();

  //static int cnt=0;

  public static int move(String color, String ballLocation, String direction) {

    // 공만 움직임... 지형지물은 안움직이게

    switch (direction) {
      case "up": {
        // 벽이 아니면 계속 이동
        while ('.' == (nodeMap.get(nodeMap.get(ballLocation).up).state)) {

          // System.out.println(nodeMap.get(nodeMap.get(ballLocation).left).location);
          if ((nodeMap.get(nodeMap.get(ballLocation).up).location.equals(blueLocation) && color
              .equals("red"))
              || (nodeMap.get(nodeMap.get(ballLocation).up).location.equals(redLocation)) && color
              .equals("blue")) {

            String nextLocation = nodeMap.get(nodeMap.get(ballLocation).up).location;
            String nextNextLocation = nodeMap.get(nextLocation).up;
            if (nodeMap.get(nextNextLocation).state == '.') {
              if (color.equals("red")) {
                redLocation = nextLocation;
                blueLocation = nextNextLocation;
                ballLocation = redLocation;
              } else {
                blueLocation = nextLocation;
                redLocation = nextNextLocation;
                ballLocation = blueLocation;
              }
            } else {
              break;
            }

          } else {
            ballLocation = nodeMap.get(ballLocation).up;
          }

          if (ballLocation == holeLocation && color.equals("blue")) {
            return -1;
          } else if (ballLocation == holeLocation && color.equals("red")) {
            return 1;
          }

        }
        if (color.equals("blue")) {
          blueLocation = ballLocation;
        }

        if (color.equals("red")) {
          redLocation = ballLocation;
        }
        break;
      }

      case "down": {
        // 벽이 아니면 계속 이동
        while ('.' == (nodeMap.get(nodeMap.get(ballLocation).down).state)) {

          // System.out.println(nodeMap.get(nodeMap.get(ballLocation).left).location);
          if ((nodeMap.get(nodeMap.get(ballLocation).down).location.equals(blueLocation) && color
              .equals("red"))
              || (nodeMap.get(nodeMap.get(ballLocation).down).location.equals(redLocation)) && color
              .equals("blue")) {

            String nextLocation = nodeMap.get(nodeMap.get(ballLocation).down).location;
            String nextNextLocation = nodeMap.get(nextLocation).down;
            if (nodeMap.get(nextNextLocation).state == '.') {
              if (color.equals("red")) {
                redLocation = nextLocation;
                blueLocation = nextNextLocation;
                ballLocation = redLocation;
              } else {
                blueLocation = nextLocation;
                redLocation = nextNextLocation;
                ballLocation = blueLocation;
              }
            } else {
              break;
            }

          } else {
            ballLocation = nodeMap.get(ballLocation).down;
          }

          if (ballLocation == holeLocation && color.equals("blue")) {
            return -1;
          } else if (ballLocation == holeLocation && color.equals("red")) {
            return 1;
          }
        }
        if (color.equals("blue")) {
          blueLocation = ballLocation;
          //return -1;
        }

        if (color.equals("red")) {
          redLocation = ballLocation;
          //return 1;
        }

        break;
      }
      case "left": {
        while ('.' == (nodeMap.get(nodeMap.get(ballLocation).left).state)) {

          // System.out.println(nodeMap.get(nodeMap.get(ballLocation).left).location);
          if ((nodeMap.get(nodeMap.get(ballLocation).left).location.equals(blueLocation) && color
              .equals("red"))
              || (nodeMap.get(nodeMap.get(ballLocation).left).location.equals(redLocation)) && color
              .equals("blue")) {

            String nextLocation = nodeMap.get(nodeMap.get(ballLocation).left).location;
            String nextNextLocation = nodeMap.get(nextLocation).left;
            if (nodeMap.get(nextNextLocation).state == '.') {
              if (color.equals("red")) {
                redLocation = nextLocation;
                blueLocation = nextNextLocation;
                ballLocation = redLocation;
              } else {
                blueLocation = nextLocation;
                redLocation = nextNextLocation;
                ballLocation = blueLocation;
              }
            } else {
              break;
            }

          } else {
            ballLocation = nodeMap.get(ballLocation).left;
          }

          if (ballLocation == holeLocation && color.equals("blue")) {
            return -1;
          } else if (ballLocation == holeLocation && color.equals("red")) {
            return 1;
          }

        }
        if (color.equals("blue")) {
          blueLocation = ballLocation;
          //return -1;
        }

        if (color.equals("red")) {
          redLocation = ballLocation;
          //return 1;
        }
        break;
      }
      case "right": {

        while ('.' == (nodeMap.get(nodeMap.get(ballLocation).right).state)) {

          // System.out.println(nodeMap.get(nodeMap.get(ballLocation).left).location);
          if ((nodeMap.get(nodeMap.get(ballLocation).right).location.equals(blueLocation)
              && color.equals("red"))
              || (nodeMap.get(nodeMap.get(ballLocation).right).location.equals(redLocation))
              && color.equals("blue")) {

            String nextLocation = nodeMap.get(nodeMap.get(ballLocation).right).location;
            String nextNextLocation = nodeMap.get(nextLocation).right;
            if (nodeMap.get(nextNextLocation).state == '.') {
              if (color.equals("red")) {
                redLocation = nextLocation;
                blueLocation = nextNextLocation;
                ballLocation = redLocation;
              } else {
                blueLocation = nextLocation;
                redLocation = nextNextLocation;
                ballLocation = blueLocation;
              }
            } else {
              break;
            }

          } else {
            ballLocation = nodeMap.get(ballLocation).right;
          }

          if (ballLocation == holeLocation && color.equals("blue")) {
            return -1;
          } else if (ballLocation == holeLocation && color.equals("red")) {
            return 1;
          }

        }
        if (color.equals("blue")) {
          blueLocation = ballLocation;
          //return -1;
        }

        if (color.equals("red")) {
          redLocation = ballLocation;
          //return 1;
        }

        break;
      }

    }
    return 0;
  }

  public static int moveTwoBall(String direction, int cnt) {

    if (cnt > 10) {
      return -1;
    }
    int checkNum = move("red", redLocation, direction);
    int checkNum2 = move("blue", blueLocation, direction);

    if (checkNum == 1 || checkNum2 == 1) {
      return cnt;
    } else if (checkNum == -1 || checkNum2 == -1) {
      return -1;
    }
    cnt++;

    List<String> directionList = Arrays.asList("left", "right", "down", "up");
    for (String dire : directionList) {
      cnt = moveTwoBall(dire, cnt);
    }
    return cnt;
  }

  public static int soluntion() {

    int cnt = 0;

    List<String> directionList = Arrays.asList("left", "right", "down", "up");

    for (String dire : directionList) {
      cnt = moveTwoBall(dire, cnt);
    }



    /*

      if ((cnt=moveTwoBall("left", cnt)) > 0) return cnt;
      if ((cnt=moveTwoBall("down", cnt)) > 0)return cnt;
      if ((cnt=moveTwoBall("right", cnt))>0) return cnt;
      if((cnt=moveTwoBall("down", cnt))>0) return cnt;
*/

    return -1;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String initInfo = br.readLine();

    int row = Integer.parseInt(initInfo.substring(0, initInfo.indexOf(' ')));
    int column = Integer.parseInt(initInfo.substring(initInfo.indexOf(' ') + 1, initInfo.length()));

    // System.out.println(row + " " + column);

    failNode.state = 'F';

    // input값으로  Node 정의
    for (int col = 0; col < column; col++) {
      String line = br.readLine();
      for (int ro = 0; ro < row; ro++) {

        Node node = new Node();
        node.location = Arrays.toString(new int[]{col, ro});
        node.state = line.charAt(ro);

        if (node.state == 'R') {
          redLocation = Arrays.toString(new int[]{col, ro});

          node.state = '.';
        } else if (node.state == 'B') {
          blueLocation = Arrays.toString(new int[]{col, ro});
          node.state = '.';
        } else if (node.state == 'O') {
          holeLocation = Arrays.toString(new int[]{col, ro});
          node.state = 'O';
        }

        nodeMap.put(Arrays.toString(new int[]{col, ro}), node);
      }
    }

    // 상하좌우 노드 연결
    for (int col = 0; col < column; col++) {
      for (int ro = 0; ro < row; ro++) {

        Node node = nodeMap.get(Arrays.toString(new int[]{col, ro}));

        if (ro - 1 >= 0) {
          node.left = Arrays.toString(new int[]{col, ro - 1});
        } else {
          node.left = "noLaction";
        }
        if (ro + 1 < row) {
          node.right = Arrays.toString(new int[]{col, ro + 1});
        } else {
          node.right = "noLaction";
        }
        if (col - 1 >= 0) {
          node.up = Arrays.toString(new int[]{col - 1, ro});
        } else {
          node.up = "noLaction";
        }
        if (col + 1 < column) {
          node.down = Arrays.toString(new int[]{col + 1, ro});
        } else {
          node.down = "noLaction";
        }
      }
    }

    //System.out.println(nodeMap.toString());

    //System.out.print("이동 전 blue : " + blueLocation + " :::");
    //System.out.println("이동 전 red : " + redLocation);

    System.out.println(soluntion());

    //System.out.print("이동 후 blue: " + blueLocation + ":::");
    //System.out.println("이동 후 red : " + redLocation);
  }

  public static class Node {

    String location;

    char state;

    String up = null;
    String down = null;
    String right = null;
    String left = null;

    @Override
    public String toString() {
      return "Node{" + "state=" + state + '}';
    }
  }
}
