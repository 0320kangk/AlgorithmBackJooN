package Glad.Gold.북쪽나라의_도로;

import java.util.*;

public class 북쪽나라의_도로 {

    static List<List<Integer[]>> roads = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10001; i++) {
            roads.add(new ArrayList<>());
        }
        while(sc.hasNextLine()){
            try{
                String[] road = sc.nextLine().split(" ");
                int p1 = Integer.parseInt(road[0]);
                int p2 = Integer.parseInt(road[1]);
                int dist = Integer.parseInt(road[2]);
                roads.get(p1).add(new Integer[]{p2, dist});
                roads.get(p2).add(new Integer[]{p1, dist});
            } catch (Exception e){
                break;
            }


        }
        int start = 1;

        int[] node = bfs(1);

        int answer = bfs(node[0])[1];

        System.out.println(answer);

    }
    static int[] bfs(int start){
        boolean[] visited = new boolean[roads.size()];
        visited[start] = true;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{start, 0});
        int maxDist = 0;
        int maxDistNode = 0;
        while(!q.isEmpty()){
            Integer[] node = q.poll();
            Integer cur = node[0];
            Integer dist = node[1];
            if(maxDist < dist){
                maxDist = dist;
                maxDistNode = cur;
            }
            for (Integer[] next: roads.get(cur)) {
                if(!visited[next[0]]){
                    visited[next[0]] = true;
                    q.add(new Integer[]{next[0], dist + next[1]});
                }
            }
        }
        return new int[]{maxDistNode, maxDist};
    }
}
