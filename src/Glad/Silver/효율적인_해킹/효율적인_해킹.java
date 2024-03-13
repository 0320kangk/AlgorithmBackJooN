package Glad.Silver.효율적인_해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 효율적인_해킹 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            lists.add(new ArrayList());
        }
        for (int i = 0; i < M; i++) {
            String[] s = bf.readLine().split(" ");
            lists.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
        }
        int[] hackingComputerCount = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            bfs(lists, i, hackingComputerCount);
        }
        int max = 0;
        for (int i = 0; i < hackingComputerCount.length; i++) {
            if (hackingComputerCount[i] > max) max = hackingComputerCount[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            if (max == hackingComputerCount[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    //해킹한 컴퓨터 수 출력
    static void bfs(List<List<Integer>> lists, int point,int[] hackingComputerCount) {
        boolean[] visited = new boolean[lists.size()];
        visited[point] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(point);
        while(!q.isEmpty()) {
            Integer poll = q.poll();
            List<Integer> list = lists.get(poll);
            for (Integer i : list) {
                if (!visited[i]) {
                    visited[i] = true;
                    hackingComputerCount[i]++;
                    q.add(i);
                }
            }
        }
    }
}
