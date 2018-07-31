package AlgoStudyGroup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
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

public class 삼성구슬탈출문제2 {

  /*static Node blueLocation = new Node();
  static Node redLocation = new Node();

  static Node holeLocation = new Node();*/


  public static int move(String direction, int cnt, Map<String, Node> nodeMap) {
    cnt++;

    switch (direction) {
      case "up": {
        if (nodeMap.get("red").column < nodeMap.get("blue").column) {
          while (nodeMap.get(nodeMap.get("red").getLocStr()).up != '#') {
            if (nodeMap.get(nodeMap.get("red").getLocStr()).up == '.') {
              nodeMap = redUp(nodeMap, nodeMap.get("red"));
            } else if (nodeMap.get(nodeMap.get("red").getLocStr()).up == 'S') {
              return 0; // 성공
            } else if (nodeMap.get(nodeMap.get("red").getLocStr()).up == 'B') {
              if (nodeMap.get("blue").up == '.') {
                nodeMap = blueUp(nodeMap, nodeMap.get("blue"));
              } else {
                break;
              }
            }
          }
          while (nodeMap.get(nodeMap.get("blue").getLocStr()).up == '.') {
            nodeMap = blueUp(nodeMap, nodeMap.get("blue"));
          }

        } else {

          while (nodeMap.get(nodeMap.get("blue").getLocStr()).up != '#') {
            if (nodeMap.get(nodeMap.get("blue").getLocStr()).up == '.') {
              nodeMap = blueUp(nodeMap, nodeMap.get("blue"));
            } else if (nodeMap.get(nodeMap.get("blue").getLocStr()).up == 'S') {
              return -1; // 실패
            } else if (nodeMap.get(nodeMap.get("blue").getLocStr()).up == 'B') {
              if (nodeMap.get("red").up == '.') {
                nodeMap = redUp(nodeMap, nodeMap.get("red"));
              } else {
                break;
              }
            }
          }
          while (nodeMap.get(nodeMap.get("red").getLocStr()).up == '.') {

            nodeMap = redUp(nodeMap, nodeMap.get("red"));

            if (nodeMap.get(nodeMap.get("red").getLocStr()) == null) {
              break;
            }
          }
        }

        if (cnt == 10) {
          return -1;
        }
        pirntStage(nodeMap);

        if (nodeMap.get(nodeMap.get("red").getLocStr()).left != '#') {
          move("left", cnt, nodeMap);
        }
        if (nodeMap.get(nodeMap.get("red").getLocStr()).right != '#') {
          move("right", cnt, nodeMap);
        }

        if (nodeMap.get(nodeMap.get("blue").getLocStr()).left != '#') {
          move("left", cnt, nodeMap);
        }
        if (nodeMap.get(nodeMap.get("blue").getLocStr()).right != '#') {
          move("right", cnt, nodeMap);
        }

        break;
      }

      case "down": {
        if (nodeMap.get("red").column > nodeMap.get("blue").column) {
          while (nodeMap.get(nodeMap.get("red").getLocStr()).down != '#') {
            if (nodeMap.get(nodeMap.get("red").getLocStr()).down == '.') {
              nodeMap = redUp(nodeMap, nodeMap.get("red"));
            } else if (nodeMap.get(nodeMap.get("red").getLocStr()).down == 'S') {
              return 0; // 성공
            } else if (nodeMap.get(nodeMap.get("red").getLocStr()).down == 'B') {
              if (nodeMap.get("blue").down == '.') {
                nodeMap = blueDown(nodeMap, nodeMap.get("blue"));
              } else {
                break;
              }
            }
          }
          while (nodeMap.get(nodeMap.get("blue").getLocStr()).down == '.') {
            nodeMap = blueDown(nodeMap, nodeMap.get("blue"));
          }

        } else {

          while (nodeMap.get(nodeMap.get("blue").getLocStr()).down != '#') {
            if (nodeMap.get(nodeMap.get("blue").getLocStr()).down == '.') {
              nodeMap = blueDown(nodeMap, nodeMap.get("blue"));
            } else if (nodeMap.get(nodeMap.get("blue").getLocStr()).down == 'S') {
              return -1; // 실패
            } else if (nodeMap.get(nodeMap.get("blue").getLocStr()).down == 'B') {
              if (nodeMap.get("red").down == '.') {
                nodeMap = redDown(nodeMap, nodeMap.get("red"));
              } else {
                break;
              }
            }
          }
          while (nodeMap.get(nodeMap.get("red").getLocStr()).down == '.') {
            nodeMap = redDown(nodeMap, nodeMap.get("red"));
          }
        }

        if (cnt == 10) {
          return -1;
        }
        pirntStage(nodeMap);

        if (nodeMap.get(nodeMap.get("red").getLocStr()).right != '#') {
          move("right", cnt, nodeMap);
        }
        if (nodeMap.get(nodeMap.get("red").getLocStr()).left != '#') {
          move("left", cnt, nodeMap);
        }

        if (nodeMap.get(nodeMap.get("blue").getLocStr()).right != '#') {
          move("right", cnt, nodeMap);
        }
        if (nodeMap.get(nodeMap.get("blue").getLocStr()).left != '#') {
          move("left", cnt, nodeMap);
        }

        break;
      }

      case "right": {
        if (nodeMap.get("red").row > nodeMap.get("blue").row) {
          while (nodeMap.get(nodeMap.get("red").getLocStr()).right != '#') {
            if (nodeMap.get(nodeMap.get("red").getLocStr()).right == '.') {
              nodeMap = redRight(nodeMap, nodeMap.get("red"));
            } else if (nodeMap.get(nodeMap.get("red").getLocStr()).right == 'S') {
              return 0; // 성공
            } else if (nodeMap.get(nodeMap.get("red").getLocStr()).right == 'B') {
              if (nodeMap.get("blue").right == '.') {
                nodeMap = blueRight(nodeMap, nodeMap.get("red"));
              } else {
                break;
              }
            }
          }
          while (nodeMap.get(nodeMap.get("blue").getLocStr()).right == '.') {
            nodeMap = blueRight(nodeMap, nodeMap.get("blue"));
          }

        } else {

          while (nodeMap.get(nodeMap.get("blue").getLocStr()).right != '#') {
            if (nodeMap.get(nodeMap.get("blue").getLocStr()).right == '.') {
              nodeMap = blueRight(nodeMap, nodeMap.get("blue"));
            } else if (nodeMap.get(nodeMap.get("blue").getLocStr()).right == 'S') {
              return -1; // 실패
            } else if (nodeMap.get(nodeMap.get("blue").getLocStr()).right == 'B') {
              if (nodeMap.get("red").right == '.') {
                nodeMap = redRight(nodeMap, nodeMap.get("red"));
              } else {
                break;
              }
            }
          }
          while (nodeMap.get(nodeMap.get("red").getLocStr()).right == '.') {
            nodeMap = redRight(nodeMap, nodeMap.get("red"));
          }
        }

        if (cnt == 10) {
          return -1;
        }
        pirntStage(nodeMap);

        if (nodeMap.get(nodeMap.get("red").getLocStr()).up != '#') {
          move("up", cnt, nodeMap);
        }
        if (nodeMap.get(nodeMap.get("red").getLocStr()).down != '#') {
          move("down", cnt, nodeMap);
        }

        if (nodeMap.get(nodeMap.get("blue").getLocStr()).up != '#') {
          move("up", cnt, nodeMap);
        }
        if (nodeMap.get(nodeMap.get("blue").getLocStr()).down != '#') {
          move("down", cnt, nodeMap);
        }

        break;
      }

      case "left": {
        if (nodeMap.get("red").row < nodeMap.get("blue").row) {
          while (nodeMap.get(nodeMap.get("red").getLocStr()).left != '#') {
            if (nodeMap.get(nodeMap.get("red").getLocStr()).left == '.') {
              nodeMap = redLeft(nodeMap, nodeMap.get("red"));
            } else if (nodeMap.get(nodeMap.get("red").getLocStr()).left == 'S') {
              return 0; // 성공
            } else if (nodeMap.get(nodeMap.get("red").getLocStr()).left == 'B') {
              if (nodeMap.get("blue").left == '.') {
                nodeMap = blueLeft(nodeMap, nodeMap.get("blue"));
              } else {
                break;
              }
            }
          }
          while (nodeMap.get(nodeMap.get("blue").getLocStr()).left == '.') {
            nodeMap = blueLeft(nodeMap, nodeMap.get("blue"));
          }

        } else {

          while (nodeMap.get(nodeMap.get("blue").getLocStr()).left != '#') {
            if (nodeMap.get(nodeMap.get("blue").getLocStr()).left == '.') {
              nodeMap = blueLeft(nodeMap, nodeMap.get("blue"));
            } else if (nodeMap.get(nodeMap.get("blue").getLocStr()).left == 'S') {
              return -1; // 실패
            } else if (nodeMap.get(nodeMap.get("blue").getLocStr()).left == 'R') {
              if (nodeMap.get("red").left == '.') {
                nodeMap = redLeft(nodeMap, nodeMap.get("red"));
              } else {
                break;
              }
            }
          }
          while (nodeMap.get(nodeMap.get("red").getLocStr()).left == '.') {
            nodeMap = redLeft(nodeMap, nodeMap.get("red"));
          }
        }

        if (cnt == 10) {
          return -1;
        }
        pirntStage(nodeMap);

        if (nodeMap.get(nodeMap.get("red").getLocStr()).up != '#') {
          move("up", cnt, nodeMap);
        }
        if (nodeMap.get(nodeMap.get("red").getLocStr()).down != '#') {
          move("down", cnt, nodeMap);
        }

        if (nodeMap.get(nodeMap.get("blue").getLocStr()).up != '#') {
          move("up", cnt, nodeMap);
        }
        if (nodeMap.get(nodeMap.get("blue").getLocStr()).down != '#') {
          move("down", cnt, nodeMap);
        }

        break;
      }
    }

    return cnt;
  }

  public static Map<String, Node> redUp(Map<String, Node> nodeMap, Node redLocation) {

    //구슬이 있던위치 정리
    redLocation.state = '.';
    redLocation.up = 'R';
    nodeMap.put(redLocation.getLocStr(), redLocation);

    //구슬이 이동한위치 재정의
    redLocation.column--;
    redLocation = nodeMap.get(redLocation.getLocStr());

    redLocation.down = '.';
    redLocation.state = 'R';

    nodeMap.put(redLocation.getLocStr(), redLocation);
    nodeMap.put("red", redLocation);

    return nodeMap;
  }

  public static Map<String, Node> blueUp(Map<String, Node> nodeMap, Node blueLocation) {
    blueLocation.state = '.';
    blueLocation.up = 'B';
    nodeMap.put(blueLocation.getLocStr(), blueLocation);

    blueLocation.column--;
    blueLocation = nodeMap.get(blueLocation.getLocStr());

    blueLocation.down = '.';
    blueLocation.state = 'B';

    nodeMap.put(blueLocation.getLocStr(), blueLocation);
    nodeMap.put("blue", blueLocation);
    return nodeMap;
  }

  public static Map<String, Node> redDown(Map<String, Node> nodeMap, Node redLocation) {
    redLocation.state = '.';
    redLocation.down = 'R';
    nodeMap.put(redLocation.getLocStr(), redLocation);

    redLocation.column++;
    redLocation = nodeMap.get(redLocation.getLocStr());

    redLocation.up = '.';
    redLocation.state = 'R';

    nodeMap.put(redLocation.getLocStr(), redLocation);
    nodeMap.put("red", redLocation);
    return nodeMap;
  }

  public static Map<String, Node> blueDown(Map<String, Node> nodeMap, Node blueLocation) {
    blueLocation.state = '.';
    blueLocation.down = 'B';
    nodeMap.put(blueLocation.getLocStr(), blueLocation);

    blueLocation.column++;
    blueLocation = nodeMap.get(blueLocation.getLocStr());

    blueLocation.up = '.';
    blueLocation.state = 'B';

    nodeMap.put(blueLocation.getLocStr(), blueLocation);
    nodeMap.put("blue", blueLocation);
    return nodeMap;
  }

  public static Map<String, Node> redRight(Map<String, Node> nodeMap, Node redLocation) {
    redLocation.state = '.';
    redLocation.right = 'R';
    nodeMap.put(redLocation.getLocStr(), redLocation);

    redLocation.row++;
    redLocation = nodeMap.get(redLocation.getLocStr());

    redLocation.left = '.';
    redLocation.state = 'R';

    nodeMap.put(redLocation.getLocStr(), redLocation);
    nodeMap.put("red", redLocation);
    return nodeMap;
  }

  public static Map<String, Node> blueRight(Map<String, Node> nodeMap, Node blueLocation) {
    blueLocation.state = '.';
    blueLocation.right = 'B';
    nodeMap.put(blueLocation.getLocStr(), blueLocation);

    blueLocation.row++;
    blueLocation = nodeMap.get(blueLocation.getLocStr());

    blueLocation.left = '.';
    blueLocation.state = 'B';

    nodeMap.put(blueLocation.getLocStr(), blueLocation);
    nodeMap.put("blue", blueLocation);
    return nodeMap;
  }

  public static Map<String, Node> redLeft(Map<String, Node> nodeMap, Node redLocation) {
    redLocation.state = '.';
    redLocation.left = 'R';
    nodeMap.put(redLocation.getLocStr(), redLocation);

    redLocation.row--;
    redLocation = nodeMap.get(redLocation.getLocStr());

    redLocation.right = '.';
    redLocation.state = 'R';

    nodeMap.put(redLocation.getLocStr(), redLocation);
    nodeMap.put("red", redLocation);
    return nodeMap;
  }

  public static Map<String, Node> blueLeft(Map<String, Node> nodeMap, Node blueLocation) {
    blueLocation.state = '.';
    blueLocation.left = 'B';
    nodeMap.put(blueLocation.getLocStr(), blueLocation);

    blueLocation.row--;
    blueLocation = nodeMap.get(blueLocation.getLocStr());

    blueLocation.right = '.';
    blueLocation.state = 'B';

    nodeMap.put(blueLocation.getLocStr(), blueLocation);
    nodeMap.put("blue", blueLocation);
    return nodeMap;

  }

  public static void pirntStage(Map<String, Node> nodeMap) {

    for (int c = 0; c < 7; c++) {
      for (int r = 0; r < 7; r++) {
        Node node = nodeMap.get(Arrays.toString(new int[]{c, r}));
        System.out.print(node.state);
      }
      System.out.print("\n");
    }

    System.out.println("\n" + "---------------" + "\n");
  }

  public static int BFS(Map<String, Node> nodeMap) {

    int cnt = 0;

    int count;

    if (nodeMap.get(nodeMap.get("red").getLocStr()).up != '#') {
      if ((count = move("up", cnt, nodeMap)) > 0) {
        return count;
      }
    }
    if (nodeMap.get(nodeMap.get("red").getLocStr()).down != '#') {
      if ((count = move("down", cnt, nodeMap)) > 0) {
        return count;
      }
    }

    if (nodeMap.get(nodeMap.get("red").getLocStr()).left != '#') {
      if ((count = move("left", cnt, nodeMap)) > 0) {
        return count;
      }
    }

    if (nodeMap.get(nodeMap.get("red").getLocStr()).right != '#') {
      if ((count = move("right", cnt, nodeMap)) > 0) {
        return count;
      }
    }
    return -1;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String initInfo = br.readLine();

    int row = Integer.parseInt(initInfo.substring(0, initInfo.indexOf(' ')));
    int column = Integer.parseInt(initInfo.substring(initInfo.indexOf(' ') + 1, initInfo.length()));

    Map<String, Node> nodeMap = new HashMap<>();

    // input값으로  Node 정의
    for (int col = 0; col < column; col++) {
      String line = br.readLine();
      for (int ro = 0; ro < row; ro++) {

        Node node = new Node();
        node.column = col;
        node.row = ro;
        node.state = line.charAt(ro);

        if (node.state == 'R') {
          nodeMap.put("red", node);
          // node.state = '.';

        } else if (node.state == 'B') {
          nodeMap.put("blue", node);
          // node.state = '.';

        } else if (node.state == 'O') {
          nodeMap.put("hole", node);
          //node.state = 'O';
        }

        nodeMap.put(Arrays.toString(new int[]{col, ro}), node);
      }
    }

    // 상하좌우 노드 연결
    for (int col = 0; col < column; col++) {
      for (int ro = 0; ro < row; ro++) {

        Node node = nodeMap.get(Arrays.toString(new int[]{col, ro}));

        if (ro - 1 >= 0) {
          node.left = nodeMap.get(Arrays.toString(new int[]{col, ro - 1})).state;
        }
        if (ro + 1 < row) {
          node.right = nodeMap.get(Arrays.toString(new int[]{col, ro + 1})).state;
        }
        if (col - 1 >= 0) {
          node.up = nodeMap.get(Arrays.toString(new int[]{col - 1, ro})).state;
        }
        if (col + 1 < column) {
          node.down = nodeMap.get(Arrays.toString(new int[]{col + 1, ro})).state;
        }
      }
    }
    System.out.println("...");
    pirntStage(nodeMap);
    System.out.println(BFS(nodeMap));
  }

  public static class Node {

    int column;
    int row;

    char state = '#';

    char left = '#';
    char right = '#';
    char up = '#';
    char down = '#';

    public String getLocStr() {
      return Arrays.toString(new int[]{column, row});
    }
  }
}
