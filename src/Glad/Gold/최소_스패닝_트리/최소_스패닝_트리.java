package Glad.Gold.최소_스패닝_트리;

import java.util.Arrays;
import java.util.Scanner;

public class 최소_스패닝_트리 {
    public static void union(int[] parent ,int v1, int v2) {
        int parent1 = findParent(parent, v1);
        int parent2 = findParent(parent, v2);
        if( parent1 < parent2) {
            parent[parent2] = parent1;
        } else {
            parent[parent1] = parent2;
        }
    }
    public static int findParent(int[] parent, int node){
        if(parent[node] == node){
            return node;
        }
        return findParent(parent, parent[node]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] linesInfo = new int[E][3];
        sc.nextLine();
        for (int i = 0; i < E; i++) {
            String ABC = sc.nextLine();
            String[] ABCSplit = ABC.split(" ");
            linesInfo[i][0] = Integer.parseInt(ABCSplit[0]);
            linesInfo[i][1] = Integer.parseInt(ABCSplit[1]);
            linesInfo[i][2] =  Integer.parseInt(ABCSplit[2]);
        }
        Arrays.sort(linesInfo, (p1, p2) -> p1[2] - p2[2]);
        int[] parents = new int[V + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }
        int weight = 0;
        for (int i = 0; i < linesInfo.length; i++) {
            if( findParent(parents ,linesInfo[i][0]) != findParent(parents, linesInfo[i][1])){
                union(parents, linesInfo[i][0], linesInfo[i][1]);
                weight += linesInfo[i][2];
            }
        }
        System.out.println(weight);

    }

}
