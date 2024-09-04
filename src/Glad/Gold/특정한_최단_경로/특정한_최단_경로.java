package Glad.Gold.특정한_최단_경로;

import java.util.*;

public class 특정한_최단_경로 {
    static int N;
    static int E;
    static int[] dist;
    static final int MAX = 200000000;
    static boolean[] visited;
    static List<List<Integer[]>> lines;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        lines = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            lines.add(new ArrayList<>());
        }
        sc.nextLine();
        for (int i = 0; i < E; i++) {
            String[] split = sc.nextLine().split(" ");
            int v1 = Integer.parseInt(split[0]);
            int v2 = Integer.parseInt(split[1]);
            int dist = Integer.parseInt(split[2]);
            lines.get(v1).add(new Integer[]{v2, dist});
            lines.get(v2).add(new Integer[]{v1, dist});
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int dist1 = 0;
        dist1 += dijkstra(1, v1);
        dist1 += dijkstra(v1,v2);
        dist1 += dijkstra(v2, N);

        int dist2 = 0;
        dist2 += dijkstra(1, v2);
        dist2 += dijkstra(v2,v1);
        dist2 += dijkstra(v1, N);

        int answer = -1;
        if(dist1 < MAX || dist2 < MAX) {
            answer = Math.min(dist1, dist2);
        }
        System.out.println(answer);

    }
    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, MAX);
        Arrays.fill(visited, false);

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((node1, node2) -> node1[1] - node2[1]);
        boolean[] visited = new boolean[N + 1];
        pq.offer(new Integer[]{start, 0});
        dist[start] = 0;

        while(!pq.isEmpty()){
            Integer[] curNode = pq.poll();
            int cur = curNode[0];

            if(!visited[cur]){
                visited[cur] = true;

                for (Integer[] node: lines.get(cur)) {
                    if(!visited[node[0]] &&
                            dist[node[0]] > dist[cur] + node[1] ){
                        dist[node[0]] = dist[cur] + node[1];
                        pq.add(new Integer[]{node[0], dist[node[0]]});
                    }
                }
            }
        }
        return dist[end];
    }
}
