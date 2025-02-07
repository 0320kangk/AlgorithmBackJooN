package Glad.Gold.도시_분할_계획;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 도시_분할_계획 {
    public static void union(int[] parent, int v1, int v2){
        int parent1 = findParent(parent, v1);
        int parent2 = findParent(parent, v2);
        if(parent1 < parent2){
            parent[parent2] = parent1;
        } else{
            parent[parent1] = parent2;
        }
    }
  /*  public static int findParent(int[] parent, int node){
        if (parent[node] == node) {
            return node;
        }
        return findParent(parent, parent[node]);
    }*/
  public static int findParent(int[] parent, int node) {
      if (parent[node] != node) {
          parent[node] = findParent(parent, parent[node]); // 경로 압축 추가
      }
      return parent[node];
  }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //집의 개수
        int M = sc.nextInt(); // 길의 개수

        List<Integer[]> roads = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            String[] split = sc.nextLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            int cost = Integer.parseInt(split[2]);
            roads.add(new Integer[]{start,end,cost});
        }

        roads.sort((r1, r2)->  r1[2]-r2[2] );
        int[] parents = new int[N + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        int weight = 0;
        int maxWeight = 0;
        for (int i = 0; i < roads.size(); i++) {
            Integer[] road = roads.get(i);
            if(findParent(parents, road[0]) != findParent(parents, road[1])){
                union(parents, road[0], road[1]);
                weight += road[2];
                maxWeight = road[2];
            }
        }
        System.out.println(weight -maxWeight);
    }
}
