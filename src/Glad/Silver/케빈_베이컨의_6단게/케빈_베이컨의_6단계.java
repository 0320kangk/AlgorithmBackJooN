package Glad.Silver.케빈_베이컨의_6단게;

import java.util.*;

public class 케빈_베이컨의_6단계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //유저 수
        ArrayList<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new HashSet<>());
        }
        int M = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            String[] split = sc.nextLine().split(" ");
            list.get(Integer.parseInt(split[0]) ).add(Integer.parseInt(split[1]));
            list.get(Integer.parseInt(split[1]) ).add(Integer.parseInt(split[0]));
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int kebinBacon = findKebinBacon(i, N, list);
            System.out.println(kebinBacon);
            min = Math.min(kebinBacon, min);
        }
        System.out.println(min);

    }
    public static int findKebinBacon(int start, int N, List<Set<Integer>> list) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{start, 0});
        int dist = 0;
        //bfs
        while(!q.isEmpty()){
            Integer[] poll = q.poll();
            for (Integer i : list.get(poll[0])) {
                if(!visited[i]){
                    visited[i] = true;
                    dist += poll[1] + 1;
                    q.add(new Integer[]{i, dist});
                }
            }
        }
        return dist;
    }
}
