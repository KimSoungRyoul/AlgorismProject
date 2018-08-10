package AlgoStudyGroup;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/*

2
----------
4 4
10 1 100 10
1 2
1 3
2 4
3 4
4
----------
8 8
10 20 1 5 8 7 1 43
1 2
1 3
2 4
2 5
3 6
5 7
6 7
7 8
7
----------
*/

public class ACMCraft_위상정렬 {

  public static int solution(Map<Integer, Node> nodeMap, int destinationNodeNum, int nodeSize) {

    Queue<Node> nodeQueue = new LinkedList<>();

    //System.out.println("ddd: " + destinationNodeNum);
    int[] result = new int[nodeSize + 1];

    for (int i = 1; i <= nodeSize; i++) {
      Node node = nodeMap.get(i);
      if (node.targetNodeCnt == 0) {

        //두개 차이없음..
        //result[node.nodeNum] += node.buildTime;
        result[node.nodeNum] = Math.max(result[node.nodeNum], node.buildTime);

        nodeQueue.add(node);
      }
    }

    List<Node> sortingList = new LinkedList<>();

    while (!nodeQueue.isEmpty()) {
      Node visitedNode = nodeQueue.poll();
      // result[visitedNode.nodeNum]+=visitedNode.buildTime;
      sortingList.add(visitedNode);

      for (int i : visitedNode.linkedNodeNum) {
        Node targetNode = nodeMap.get(i);
        result[targetNode.nodeNum] = Math
            .max(result[targetNode.nodeNum], result[visitedNode.nodeNum] + targetNode.buildTime);
        targetNode.targetNodeCnt--;

        if (targetNode.targetNodeCnt == 0) {
          nodeQueue.add(targetNode);

        }
      }
    }

    System.out.println(sortingList.toString());

    return result[destinationNodeNum];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      // n 개 노드 생성
      int nodeSize = sc.nextInt();
      int buildRuleCnt = sc.nextInt();

      Map<Integer, Node> nodeMap = new LinkedHashMap<>();

      for (int a = 1; a < nodeSize + 1; a++) {
        nodeMap.put(a, new Node(a));
      }

      // node 별 빌드타임 넣기
      for (int j = 1; j < nodeSize + 1; j++) {
        Node node = nodeMap.get(j);
        node.buildTime = sc.nextInt();
      }

      // node 별 연결 노드 지정
      for (int k = 1; k < buildRuleCnt + 1; k++) {
        int startNode = sc.nextInt();
        int endNode = sc.nextInt();

        Node node1 = nodeMap.get(startNode);
        node1.linkedNodeNum.add(endNode);
        nodeMap.put(startNode, node1);

        Node node2 = nodeMap.get(endNode);
        node2.targetNodeCnt++;
        nodeMap.put(endNode, node2);
      }
      int destinationNodeNum = sc.nextInt();

      System.out.println(solution(nodeMap, destinationNodeNum, nodeSize));
      // System.out.println(nodeMap.toString());

    }
  }

  static class Node {

    int nodeNum;

    // 현노드를 가리키는 Cnt
    int targetNodeCnt;

    int buildTime;

    List<Integer> linkedNodeNum = new ArrayList<>();

    public Node(int nodeNum) {
      this.nodeNum = nodeNum;
    }

    public Node() {
    }

    @Override
    public String toString() {
      return "Node{" +
          "nodeNum=" + nodeNum +
         /* ", targetNodeCnt=" + targetNodeCnt +
          ", buildTime=" + buildTime +
          ", linkedNodeNum=" + linkedNodeNum +*/
          '}';
    }
  }
}
