package Glad.Gold.트리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 트리 {
    static Node[] nodes;
    static int removeNum;
    static List<Integer> leafNodes = new ArrayList<>();
    public static void main(String[] args) {
        /*
        1. 각 노드는 자신의 자식이 무엇인지 알 수 있어야 한다. (리프 노드인지 확인)
        2. 노드 삭제 = 삭제할 노드 부모의 노드 주소 삭제
         */
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        nodes = new Node[count];
        int root = -1;
        for (int i = 0; i < count; i++) {
          nodes[i] = new Node();
        }
        for (int i = 0; i < count; i++) {
            int parent = sc.nextInt();
            if (parent != -1)
                nodes[parent].childs.add(i);
            else
                root = i;
        }
        removeNum = sc.nextInt();
        if(root == removeNum){
            System.out.println(0);
            return;
        }
        findLeafNodes(root);
        System.out.println(leafNodes.size());
    }
    public static class Node{
        List<Integer> childs = new ArrayList<>(); //자식 노드들
        @Override
        public String toString() {
            return childs.toString();
        }
    }
    static void findLeafNodes(Integer root){
        //모든 자식 번호를 얻어서 반환해야 함
        //왼쪽 번호 부터 얻자
        List<Integer> nodeList = nodes[root].childs;
        nodeList.remove((Integer) removeNum);
        if (nodeList.isEmpty())
            leafNodes.add(root);
        for (Integer child : nodeList) {
            if (child != removeNum){
                findLeafNodes(child);
            }
        }

    }
}
