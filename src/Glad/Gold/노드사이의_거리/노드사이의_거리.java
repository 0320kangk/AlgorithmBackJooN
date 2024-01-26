package Glad.Gold.노드사이의_거리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 노드사이의_거리 {
    static boolean[] visited;
    static List<List<Integer[]>> list;
    static int sum = 0;
    public static void main(String[] args) {
        /*
        1. 값을 저장할 리스트 만들기
        2. dfs 를 통하여 길 찾기
        3. 거리 찾기
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        sc.nextLine();
        for (int i = 0; i < N - 1; i++) {
            String roadString = sc.nextLine();
            String[] split = roadString.split(" ");
            Integer[] road = new Integer[3];
            road[0] = Integer.parseInt(split[0]);
            road[1] = Integer.parseInt(split[1]);
            road[2] = Integer.parseInt(split[2]);
            list.get(road[0]).add(new Integer[]{road[1], road[2]});
            list.get(road[1]).add(new Integer[]{road[0], road[2]});
        }
        visited = new boolean[N + 1];
        int[][] nodes = new int[M][2];
        for (int i = 0; i < M; i++) {
            nodes[i][0] = sc.nextInt();
            nodes[i][1] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            visited[nodes[i][0]] = true;
            dfs(nodes[i][0], nodes[i][1], 0);
            System.out.println(sum);
            sum = 0;
            visited = new boolean[N + 1];
        }
    }
    static void dfs(int loc, int end, int dist) {
        //탈출 조건
        if(loc == end){
            sum = dist;
            return;
        }
        List<Integer[]> roadData = list.get(loc);
        for (int i = 0; i < roadData.size(); i++) {
            if(!visited[roadData.get(i)[0]]){
                Integer[] road = roadData.get(i);
                visited[road[0]] = true;
                dfs(road[0], end, dist + road[1]);
                visited[road[0]] = false;
            }
        }
    }
}
